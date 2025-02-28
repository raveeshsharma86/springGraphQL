package com.accounts.springGraphQL.controller;

import com.accounts.springGraphQL.domains.BankAccount;
import com.accounts.springGraphQL.domains.Client;
import com.accounts.springGraphQL.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class AccountsController {

    @Autowired
    private BankService bankService;

    @QueryMapping
    List<BankAccount> accounts(){
        log.info("Getting accounts");
        return bankService.getAccounts();

    }

    @SchemaMapping(typeName = "BankAccount", field = "client")
    Client getClient(BankAccount bankAccount){
        log.info("Getting Clients");
        return bankService.getClientByAccountId(bankAccount.id());
    }

}
