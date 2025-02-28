package com.accounts.springGraphQL.service;

import com.accounts.springGraphQL.domains.BankAccount;
import com.accounts.springGraphQL.domains.Client;
import com.accounts.springGraphQL.domains.Currency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    // Immutable lists for bank accounts and clients
    private static final List<BankAccount> bankAccounts = List.of(
            new BankAccount("A100", "C100", Currency.USD, 106.00f, "A"),
            new BankAccount("A101", "C200", Currency.CAD, 250.00f, "A"),
            new BankAccount("A102", "C300", Currency.CAD, 333.00f, "I"),
            new BankAccount("A103", "C400", Currency.EUR, 4000.00f, "A"),
            new BankAccount("A104", "C500", Currency.EUR, 4000.00f, "A")
    );
    private static final List<Client> clients = List.of(
            new Client("C100", "A100", "Elena", "Maria", "Gonzalez"),
            new Client("C200", "A101", "James", "Robert", "Smith"),
            new Client("C300", "A102", "Aarav", "Kumar", "Patel"),
            new Client("C400", "A103", "Linh", "Thi", "Nguyen"),
            new Client("C500", "A104", "Olivia", "Grace", "Johnson")
    );

    public List<BankAccount> getAccounts() {
        return bankAccounts;
    }


    public Client getClientByAccountId(String id) {
       return clients.stream().filter(client -> client.accountId().equals(id))
               .findFirst().orElse(null);
    }
}
