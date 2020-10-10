package com.kandula.strictlyrest.spike.web.controller;

import com.kandula.strictlyrest.spike.model.Account;
import com.kandula.strictlyrest.spike.service.IAccountService;
import com.kandula.strictlyrest.spike.web.dto.AccountDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{id}")
    public AccountDto findAccount(@PathVariable int id) {
        Account responseAcct = this.accountService.findById(id);
        return convertAccountToDto(responseAcct);
    }

    @PostMapping
    public AccountDto create(@RequestBody AccountDto newAccount) {
        return convertAccountToDto(
                    this.accountService.save(convertDtotoAccount(newAccount))
        );
    }

    @GetMapping
    public Collection<AccountDto> findAll() {
        Iterable<Account> allAccounts = this.accountService.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        allAccounts.forEach(p -> accountDtos.add(convertAccountToDto(p)));
        return accountDtos;
    }

    public AccountDto convertAccountToDto(Account responseAcct) {
        return new AccountDto(responseAcct.getId(), responseAcct.getAccountType(), responseAcct.getAccountBalance());
    }

    public Account convertDtotoAccount(AccountDto webAccount) {
        return new Account(webAccount.getAccountType(), webAccount.getAccountBalance());
    }
}
