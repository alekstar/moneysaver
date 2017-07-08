package ua.alekstar.moneysaver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alekstar.moneysaver.dao.AccountRepository;
import ua.alekstar.moneysaver.dao.TransactionRepository;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.dao.entities.Transaction;

import javax.annotation.Nonnull;

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
        return transactionRepository.findByAccountIdOrderByTime(accountId);
    }

    @Override
    @Nonnull
    public Account readWithCheck(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("accountId should be specified");
        }
        final Account account = read(id);
        if (account == null) {
            throw new IllegalArgumentException("There is no account with ID " + id);
        }
        return account;
    }
}
