package com.example.springdataintrolab.services;

import com.example.springdataintrolab.exceptions.NotEnoughMoneyException;
import com.example.springdataintrolab.models.Account;
import com.example.springdataintrolab.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account account = this.accountRepository.findAccountById(id);
        if(account.getBalance().compareTo(money) < 0){
            throw new NotEnoughMoneyException();
        }

        account.setBalance(account.getBalance().subtract(money));

    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account = this.accountRepository.findAccountById(id);
        account.setBalance(account.getBalance().add(money));

    }
}
