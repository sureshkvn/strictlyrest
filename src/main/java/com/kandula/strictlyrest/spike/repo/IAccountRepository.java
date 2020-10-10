package com.kandula.strictlyrest.spike.repo;

import com.kandula.strictlyrest.spike.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Integer> {
}
