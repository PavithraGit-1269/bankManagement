package com.BankManagement.Mine.Controller;

import com.BankManagement.Mine.Constants.AccountConstants;
import com.BankManagement.Mine.DTO.CustomerDto;
import com.BankManagement.Mine.DTO.ResponseDto;
import com.BankManagement.Mine.Service.AccountsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
    @RestController
    @RequestMapping("/accounts/api")
    public class AccountsController {
        @Autowired
        AccountsService accountsService;

        @PostMapping("/create")
        public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
            accountsService.createAccount(customerDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseDto(AccountConstants.ACCOUNT_CREATED, AccountConstants.ACCOUNT_CREATED_MESSAGE));
        }

        @GetMapping("/customer/{mobileNumber}")
        public ResponseEntity<CustomerDto> getCustomerByMobileNumber(
                @PathVariable String mobileNumber) {

            CustomerDto customerModel =
                    accountsService.getCustomerByMobileNumber(mobileNumber);

            return ResponseEntity.ok(customerModel);
        }

        @PutMapping("/update")
        public ResponseEntity<String> updateAccount(@Valid @RequestBody CustomerDto customerModel) {
            accountsService.updateAccount(customerModel);
            return ResponseEntity.ok("Account updated successfully");
        }

        @DeleteMapping("/delete/{mobileNumber}")
        public ResponseEntity<String> deleteAccount(
                @PathVariable String mobileNumber) {
            accountsService.deleteAccount(mobileNumber);
            return ResponseEntity.ok("Account deleted successfully");
        }

        @GetMapping("/all")
        public ResponseEntity<List<CustomerDto>> getAllCustomers() {
            List<CustomerDto> customers = accountsService.getAllCustomers();
            return ResponseEntity.ok(customers);
        }

        @GetMapping("/customer/id/{customerId}")
        public ResponseEntity<CustomerDto> getCustomerById(
                @PathVariable Long customerId) {

            CustomerDto customerModel =
                    accountsService.getCustomerById(customerId);

            return ResponseEntity.ok(customerModel);
        }
    }

