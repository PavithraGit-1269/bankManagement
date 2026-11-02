package com.BankManagement.Mine.Repository;

import com.BankManagement.Mine.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Long> {
    Accounts findByCustomerId(Long customerId);
}
