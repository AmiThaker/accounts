package com.ami.accounts.mapper;

import com.ami.accounts.dto.AccountsDTO;
import com.ami.accounts.entity.Accounts;

public class AccountsMapper {

        public static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO){
            accountsDTO.setAccountNumber(accounts.getAccountNumber());
            accountsDTO.setAccountType(accounts.getAccountType());
            accountsDTO.setBranchAddress(accounts.getBranchAddress());
            return accountsDTO;
        }

        public static Accounts mapToAccounts(AccountsDTO accountsDTO,Accounts accounts){
            System.out.println("Accounts DTO Data : "+accountsDTO.getAccountNumber()+","+accountsDTO.getAccountType()+","+accountsDTO.getBranchAddress());
            accounts.setAccountNumber(accountsDTO.getAccountNumber());
            accounts.setAccountType(accountsDTO.getAccountType());
            accounts.setBranchAddress(accountsDTO.getBranchAddress());
            System.out.println("Accounts Data : "+accounts.getAccountNumber()+" ,"+accounts.getAccountType()+", "+accounts.getBranchAddress());
            return accounts;
        }
}
