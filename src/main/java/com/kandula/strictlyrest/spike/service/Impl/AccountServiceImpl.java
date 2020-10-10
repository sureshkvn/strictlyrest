package com.kandula.strictlyrest.spike.service.Impl;

import com.kandula.strictlyrest.spike.model.Account;
import com.kandula.strictlyrest.spike.repo.IAccountRepository;
import com.kandula.strictlyrest.spike.service.IAccountService;
import com.kandula.strictlyrest.spike.web.errors.businessexceptions.AccountFrozenException;
import com.kandula.strictlyrest.spike.web.errors.businessexceptions.AccountNotAccessibleException;
import com.kandula.strictlyrest.spike.web.errors.businessexceptions.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Objects.isNull;

@Service
public class AccountServiceImpl implements IAccountService {

    private IAccountRepository accountRepository;

    public AccountServiceImpl(IAccountRepository repo) {
        this.accountRepository = repo;
    }

    @Override
    public Account findById(Integer id) {
        Account acct = this.accountRepository.findById(id)
                .orElse(null);
        if(isNull(acct)) throw new AccountNotFoundException("Requested Account " + id + " not found");

        if(acct.getId() == 3) throw new AccountNotAccessibleException("Requested Account " + id + " is forbidden");

        if(acct.getId() == 2) throw new HttpClientErrorException(HttpStatus.TOO_MANY_REQUESTS, "too many requests for Account details");

        return acct;
    }

    @Override
    public Account save(Account account) {

        String TEST_ACCT = "Test";

        System.out.println("creating with account Type: " + account.getAccountType());
        if(account.getAccountType().equals(TEST_ACCT)) {
            throw new AccountFrozenException("Account details are frozen");
        }

        return this.accountRepository.save(account);
    }

    @Override
    public Iterable<Account> findAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        this.accountRepository.deleteById(id);
    }
}
