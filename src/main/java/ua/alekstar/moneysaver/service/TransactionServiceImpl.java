package ua.alekstar.moneysaver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alekstar.moneysaver.dao.TransactionRepository;
import ua.alekstar.moneysaver.dao.entities.Transaction;

import java.math.BigDecimal;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void create(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Iterable<Transaction> readAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction read(Long id) {
        return transactionRepository.findOne(id);
    }

    @Override
    public void update(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(id);
    }

    @Override
    public BigDecimal calculateAmountForAccount(Long accountId) {
        final BigDecimal amount = transactionRepository.calculateAmountForAccount(accountId);
        if (amount == null) {
            return BigDecimal.ZERO;
        }
        return amount;
    }
}
