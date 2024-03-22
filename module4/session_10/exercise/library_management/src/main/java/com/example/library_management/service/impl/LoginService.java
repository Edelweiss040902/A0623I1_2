package com.example.library_management.service.impl;

import com.example.library_management.model.Account;
import com.example.library_management.repository.ILoginRepository;
import com.example.library_management.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {
    @Autowired
    ILoginRepository loginRepository;
    @Override
    public List<Account> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return loginRepository.findById(id).get();
    }

    @Override
    public void save(Account account) {
        loginRepository.save(account);
    }

    @Override
    public void deleteById(Long id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Account findAllByAccountNameAndAccountPassword(String accountName, String accountPassword) {
        return loginRepository.findAllByAccountNameAndAccountPassword(accountName, accountPassword);
    }
}
