package ua.alekstar.moneysaver.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.alekstar.moneysaver.rest.currency.Currencies;
import ua.alekstar.moneysaver.rest.currency.Currency;

import java.util.ArrayList;
import java.util.List;

@RestController("/json/currency")
public class CurrencyJsonRestController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Currencies get() {
        final List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency(1L, "USD", "US Dollar", '$'));
        return new Currencies(currencies);
    }
}
