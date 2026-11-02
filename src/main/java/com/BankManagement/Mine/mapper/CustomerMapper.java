package com.BankManagement.Mine.mapper;

import com.BankManagement.Mine.dto.CustomerDto;
import com.BankManagement.Mine.entity.Accounts;
import com.BankManagement.Mine.entity.Customer;

public class CustomerMapper {
    public static Customer customerDtoToCustomerEntity(CustomerDto customerDto)
    {
        return Customer.builder().name(customerDto.getName())
                .email(customerDto.getEmail())
                .mobileNumber(customerDto.getMobileNumber()).build();

    }
    public static CustomerDto customerAccountEntityToCustomerDto(Customer customer, Accounts accounts)
    {
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .accountsDto(AccountMapper.accountEntityToAccountDto(accounts)).build();

    }
    public static void updateCustomerEntity(CustomerDto customerDto, Customer customer)
    {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
    }
}
