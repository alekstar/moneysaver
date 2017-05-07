package ua.alekstar.moneysaver.rest.currency;

import java.util.List;

public class Currencies {

    final private List<Currency> currencies;


    public Currencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
