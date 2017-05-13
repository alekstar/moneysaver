package ua.alekstar.moneysaver.rest.account;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Accounts {

    final private Iterable<Account> accounts;


    public Accounts(Iterable<ua.alekstar.moneysaver.dao.entities.Account> accounts) {
        this.accounts = StreamSupport.stream(accounts.spliterator(), false)
                .map(Account::new)
                .collect(Collectors.toList());
    }

    public Iterable<Account> getAccounts() {
        return accounts;
    }
}
