package com.accounts.springGraphQL.domains;

public record BankAccount(String id, String clientId, Currency currency, float balance, String status) {}
