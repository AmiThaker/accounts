package com.ami.accounts.service;

import com.ami.accounts.dto.CustomerDTO;

public interface AccountsService {

    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccountDetails(String mobileNumber);
    boolean updateAccount(CustomerDTO customerDTO);
    boolean deleteAccount(String mobileNumber);
}
