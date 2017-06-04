package ua.alekstar.moneysaver.service;

import ua.alekstar.moneysaver.dao.entities.Transaction;

public interface TransactionService {

    void create(Transaction transaction);

    Iterable<Transaction> readAll();

    Transaction read(Long id);

    void update(Transaction transaction);

    void delete(Long id);
}
