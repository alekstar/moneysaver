package ua.alekstar.moneysaver.dao;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.dao.entities.Currency;
import ua.alekstar.moneysaver.dao.entities.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void shouldSaveNewTransaction() {
        final Currency currency = new Currency("USD", "US Dollar", '$');
        final Account account = new Account("Test account", currency);
        final LocalDateTime time = LocalDateTime.now();
        final Transaction transaction = new Transaction(time, account, new BigDecimal("10.45"));
        save(transaction);
        assertThat(transaction.getId(), is(not(nullValue())));
    }

    @Test
    public void shouldReadTransactionHaveSameAccountName() {
        final Currency currency = new Currency("USD", "US Dollar", '$');
        final Account account = new Account("Test account", currency);
        final LocalDateTime time = LocalDateTime.now();
        final Transaction transaction = new Transaction(time, account, new BigDecimal("10.45"));
        save(transaction);
        final Transaction readTransaction = findOne(transaction.getId());
        assertThat(readTransaction.getAccount().getName(), is("Test account"));
    }

    @Test
    public void shouldReadTransactionHaveTheSameTimeAsSaved() {
        final Currency currency = new Currency("USD", "US Dollar", '$');
        final Account account = new Account("Test account", currency);
        final LocalDateTime time = LocalDateTime.now();
        final Transaction transaction = new Transaction(time, account, new BigDecimal("10.45"));
        save(transaction);
        final Transaction readTransaction = findOne(transaction.getId());
        assertThat(readTransaction.getTime(), is(time));
    }

    @Test
    public void shouldReadTransactionHaveSameAmountAsSaved() {
        final Currency currency = new Currency("USD", "US Dollar", '$');
        final Account account = new Account("Test account", currency);
        final LocalDateTime time = LocalDateTime.now();
        final BigDecimal amount = new BigDecimal("10.45");
        final Transaction transaction = new Transaction(time, account, amount);
        save(transaction);
        final Transaction readTransaction = findOne(transaction.getId());
        assertThat(readTransaction.getAmount(), is(amount));
    }



    @Test
    public void shouldReturnTotalAmountForAccount() {
        final Currency USD = new Currency("USD", "US Dollars", '$');
        final Account account = new Account("Account with USD", USD);
        addTransactionWithAmount(account, "10.45");
        addTransactionWithAmount(account, "10.45");
        final BigDecimal totalAmount = transactionRepository.calculateAmountForAccount(account.getId());
        assertThat(totalAmount, is(new BigDecimal("20.90")));
    }

    private void addTransactionWithAmount(Account account, String amountInString) {
        final LocalDateTime time = LocalDateTime.now();
        final BigDecimal amount = new BigDecimal(amountInString);
        final Transaction transaction = new Transaction(time, account, amount);
        transactionRepository.save(transaction);
    }

    private Transaction findOne(Long id) {
        return transactionRepository.findOne(id);
    }

    private void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}