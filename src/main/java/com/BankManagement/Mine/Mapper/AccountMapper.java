package com.BankManagement.Mine.Mapper;

import com.BankManagement.Mine.DTO.AccountsDto;
import com.BankManagement.Mine.DTO.CustomerDto;
import com.BankManagement.Mine.Entity.Accounts;

public class AccountMapper{
public static Accounts customerDtoToAccountEntity(CustomerDto customerDto)
{

    return Accounts.builder().accountType(customerDto.getAccountsDto().getAccountType())
            .branchAddress(customerDto.getAccountsDto().getBranchAddress()).build();

}

public static AccountsDto accountEntityToAccountDto(Accounts account)
{

    return AccountsDto.builder()
            .customerId(account.getCustomerId())
            .accountNumber(account.getAccountNumber())
            .accountType(account.getAccountType())
            .branchAddress(account.getBranchAddress())
            .accountNumber(account.getAccountNumber())
            .build();
}
public static void updateAccountEntity(AccountsDto accountsDto, Accounts account)
{
    account.setAccountType(accountsDto.getAccountType());
    account.setBranchAddress(accountsDto.getBranchAddress());
}
}

