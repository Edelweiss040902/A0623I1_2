package com.example.library_management.repository;

import com.example.library_management.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends JpaRepository<Account,Long> {
    Account findAllByAccountNameAndAccountPassword(String accountName,String accountPassword);
}
