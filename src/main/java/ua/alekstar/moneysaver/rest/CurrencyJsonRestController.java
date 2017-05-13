package ua.alekstar.moneysaver.rest;

import org.springframework.web.bind.annotation.*;
import ua.alekstar.moneysaver.rest.currency.Currencies;
import ua.alekstar.moneysaver.rest.currency.Currency;
import ua.alekstar.moneysaver.service.CurrencyService;

import java.util.Collections;

@RestController
@RequestMapping("/json/currency")
public class CurrencyJsonRestController {

    private final CurrencyService currencyService;

    public CurrencyJsonRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    @ResponseBody
    public Currencies get(@RequestParam(required = false) Long id) {
        if (id == null) {
            return readAll();
        }
        return read(id);
    }

    private Currencies read(Long id) {
        return new Currencies(Collections.singletonList(currencyService.read(id)));
    }

    private Currencies readAll() {
        return new Currencies(currencyService.readAll());
    }

    @PostMapping
    public void post(@RequestBody Currency currency) {
        currencyService.create(currency.toEntity());
    }

    @PutMapping
    public void put(@RequestBody Currency currency) {
        currencyService.update(currency.toEntity());
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        currencyService.delete(id);
    }
}
