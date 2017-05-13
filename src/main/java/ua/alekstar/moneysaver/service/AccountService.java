package ua.alekstar.moneysaver.service;

import ua.alekstar.moneysaver.dao.entities.Account;

public interface AccountService {

    void create(Account currency);

    Iterable<Account> readAll();

    Account read(Long id);

    void update(Account currency);

    void delete(Long id);
}
