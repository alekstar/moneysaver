package ua.alekstar.moneysaver.rest.currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CurrencyToEntityTest {

    private final Long id;
    private final String isoCode;
    private final String name;
    private final Character symbol;

    public CurrencyToEntityTest(Long id, String isoCode, String name, Character symbol) {
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
        this.symbol = symbol;
    }

    @Parameterized.Parameters(name = "" + "id: {0}, isoCode: {1}, name: {2}, symbol: {3}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {null, null, null, null},
                {1L, "isoCode", "name", 's'},
                {null, "isoCode1", "name2", '$'},
                {2L, null, "Some name", '$'},
                {2L, "", "", null}
        });
    }

    @Test
    public void shouldIdBeSame() {
        assertThat(defineResult().getId(), is(id));
    }

    @Test
    public void shouldIsoCodeBeSame() {
        assertThat(defineResult().getIsoCode(), is(isoCode));
    }

    @Test
    public void shouldNameBeSame() {
        assertThat(defineResult().getName(), is(name));
    }

    @Test
    public void shouldSymbolBeSame() {
        assertThat(defineResult().getSymbol(), is(symbol));
    }

    private ua.alekstar.moneysaver.dao.entities.Currency defineResult() {
        return Currency.builder()
                .withId(id)
                .withIsoCode(isoCode)
                .withName(name)
                .withSymbol(symbol)
                .build()
                .toEntity();
    }
}