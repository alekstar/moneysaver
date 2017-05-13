package ua.alekstar.moneysaver.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.alekstar.moneysaver.dao.AccountRepository;
import ua.alekstar.moneysaver.dao.entities.Account;

@Component
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
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
}
