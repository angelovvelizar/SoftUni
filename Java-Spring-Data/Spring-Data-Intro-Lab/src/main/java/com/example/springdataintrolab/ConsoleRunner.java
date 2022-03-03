package com.example.springdataintrolab;

import com.example.springdataintrolab.exceptions.UserAlreadyExistsException;
import com.example.springdataintrolab.models.Account;
import com.example.springdataintrolab.models.User;
import com.example.springdataintrolab.services.AccountService;
import com.example.springdataintrolab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;


    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService){
        this.userService = userService;
        this.accountService = accountService;
    }
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("dmitri");
        user.setAge(43);

        Account account = new Account();
        account.setUser(user);


        try {
            this.userService.registerUser(user);
        }catch (UserAlreadyExistsException e){
            System.out.println("User already exist!");
        }




    }
}
