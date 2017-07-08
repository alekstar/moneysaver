package ua.alekstar.moneysaver.rest;

import org.springframework.stereotype.Service;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.rest.transaction.Transaction;
import ua.alekstar.moneysaver.rest.transaction.Transactions;
import ua.alekstar.moneysaver.service.AccountService;
import ua.alekstar.moneysaver.service.TransactionService;

import static java.util.Collections.singletonList;

@Service
public class TransactionRestService {

    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionRestService(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    public Transactions readAll() {
        return new Transactions(transactionService.readAll());
    }

    public Transactions read(Long id) {
        return new Transactions(singletonList(transactionService.read(id)));
    }

    private ua.alekstar.moneysaver.dao.entities.Transaction toEntity(Transaction transaction) {
        final Account account = accountService.readWithCheck(transaction.getAccountId());
        return new ua.alekstar.moneysaver.dao.entities.Transaction(transaction.getId(), transaction.getTime(), account,
                transaction.getAmount());
    }

    public void create(Transaction transaction) {
        transactionService.create(toEntity(transaction));
    }

    public void update(Transaction transaction) {
        transactionService.update(toEntity(transaction));
    }
}
