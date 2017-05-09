package ua.alekstar.moneysaver.rest.currency;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Currencies {

    final private Iterable<Currency> currencies;


    public Currencies(Iterable<ua.alekstar.moneysaver.dao.entities.Currency> currencies) {
        this.currencies = StreamSupport.stream(currencies.spliterator(), false)
                .map(Currency::new)
                .collect(Collectors.toList());
    }

    public Iterable<Currency> getCurrencies() {
        return currencies;
    }
}
