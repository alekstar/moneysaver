package ua.alekstar.moneysaver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alekstar.moneysaver.dao.AccountRepository;
import ua.alekstar.moneysaver.dao.TransactionRepository;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.dao.entities.Transaction;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void create(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Iterable<Account> readAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account read(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        accountRepository.delete(id);
    }

    @Override
    public Iterable<Transaction> readTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
