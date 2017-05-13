package ua.alekstar.moneysaver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.alekstar.moneysaver.dao.entities.Currency;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyRepositoryTest {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    public void shouldReadByIsoCode() {
        final Currency currency = new Currency("USD", "Us Dollar", '$');
        currencyRepository.save(currency);
        final Currency foundCurrency = currencyRepository.readByIsoCode("USD");
        assertThat(foundCurrency.getId(), is(currency.getId()));
    }
}