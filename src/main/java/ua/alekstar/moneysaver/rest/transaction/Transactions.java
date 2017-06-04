package ua.alekstar.moneysaver.rest.transaction;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Transactions {

    private final Iterable<Transaction> transactions;

    public Transactions(Iterable<ua.alekstar.moneysaver.dao.entities.Transaction> transactions) {
        this.transactions = StreamSupport.stream(transactions.spliterator(), false)
                .map(Transaction::new).collect(Collectors.toList());
    }

    public Iterable<Transaction> getTransactions() {
        return transactions;
    }
}
