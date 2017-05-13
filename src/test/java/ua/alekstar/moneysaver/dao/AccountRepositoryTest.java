package ua.alekstar.moneysaver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.dao.entities.Currency;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void shouldCreateAccountWithUsdCurrency() {
        final Currency USD = new Currency("USD", "US Dollars", '$');
        final Account account = new Account("Account with USD", USD);
        accountRepository.save(account);
        final Account foundAccount = accountRepository.findOne(account.getId());
        assertThat(foundAccount.getCurrency().getId(), is(USD.getId()));
    }
}