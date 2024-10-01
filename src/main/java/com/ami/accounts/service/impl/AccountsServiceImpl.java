package com.ami.accounts.service.impl;

import com.ami.accounts.constants.AccountsConstants;
import com.ami.accounts.dto.AccountsDTO;
import com.ami.accounts.dto.CustomerDTO;
import com.ami.accounts.entity.Accounts;
import com.ami.accounts.entity.Customer;
import com.ami.accounts.exception.CustomerAlreadyExistsException;
import com.ami.accounts.exception.ResourceNotFoundException;
import com.ami.accounts.mapper.AccountsMapper;
import com.ami.accounts.mapper.CustomerMapper;
import com.ami.accounts.repository.AccountsRepository;
import com.ami.accounts.repository.CustomerRepository;
import com.ami.accounts.service.AccountsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountsServiceImpl implements AccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository){
        this.accountsRepository=accountsRepository;
        this.customerRepository=customerRepository;
    }

    @Override
    public void createAccount(CustomerDTO customerDTO) {

        Customer customer= CustomerMapper.mapToCustomer(customerDTO,new Customer());
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customerDTO.getMobileNumber());

        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer with mobile number : "+customerDTO.getMobileNumber()+" already exists!");
        }

        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDTO fetchAccountDetails(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));
        Accounts account=accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(()->new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString()));
        CustomerDTO customerDTO=CustomerMapper.mapToCustomerDTO(customer,new CustomerDTO());
        customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDTO(account,new AccountsDTO()));
        return customerDTO;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountsDTO accountsDTO = customerDTO.getAccountsDTO();

        if (accountsDTO != null) {
            Accounts accounts = accountsRepository.findById(accountsDTO.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber", accountsDTO.getAccountNumber().toString()));
            accounts=AccountsMapper.mapToAccounts(accountsDTO, accounts);
            accounts = accountsRepository.save(accounts);
            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer Id", customerId.toString()));
            CustomerMapper.mapToCustomer(customerDTO, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;

    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccount=new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber=1000000L+new Random().nextInt(900000);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
