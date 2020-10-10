package com.kandula.strictlyrest.spike.service;

import com.kandula.strictlyrest.spike.model.Account;

import java.util.Optional;

public interface IAccountService {

    Account findById(Integer id);

    Account save(Account project);

    Iterable<Account> findAll();

    void delete(Integer id);
}
