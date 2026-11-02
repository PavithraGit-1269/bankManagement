package com.BankManagement.Mine.service;

import com.BankManagement.Mine.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountsService {
    void createAccount(CustomerDto customerModel);

    CustomerDto getCustomerByMobileNumber(String mobileNumber);

    void updateAccount(CustomerDto customerModel);

    void deleteAccount(String mobileNumber);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long customerId);
}
