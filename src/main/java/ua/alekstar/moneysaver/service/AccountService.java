package ua.alekstar.moneysaver.service;

import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.dao.entities.Transaction;

import javax.annotation.Nonnull;

public interface AccountService {

    void create(Account currency);

    Iterable<Account> readAll();

    Account read(Long id);

    void update(Account currency);

    void delete(Long id);

    Iterable<Transaction> readTransactions(Long accountId);

    @Nonnull
    Account readWithCheck(Long id);
}
