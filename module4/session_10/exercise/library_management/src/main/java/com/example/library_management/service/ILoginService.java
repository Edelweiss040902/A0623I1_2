package com.example.library_management.service;

import com.example.library_management.model.Account;

public interface ILoginService extends IGeneralService<Account> {
    Account findAllByAccountNameAndAccountPassword(String accountName,String accountPassword);
}
