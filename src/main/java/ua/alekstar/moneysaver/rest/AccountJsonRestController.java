package ua.alekstar.moneysaver.rest;

import org.springframework.web.bind.annotation.*;
import ua.alekstar.moneysaver.dao.entities.Currency;
import ua.alekstar.moneysaver.rest.account.Account;
import ua.alekstar.moneysaver.rest.account.Accounts;
import ua.alekstar.moneysaver.service.AccountService;
import ua.alekstar.moneysaver.service.CurrencyService;

import java.util.Collections;

@RestController
@RequestMapping("/json/account")
public class AccountJsonRestController {

    private final AccountService accountService;
    private final CurrencyService currencyService;

    public AccountJsonRestController(AccountService accountService, CurrencyService currencyService) {
        this.accountService = accountService;
        this.currencyService = currencyService;
    }

    @GetMapping
    @ResponseBody
    public Accounts get(@RequestParam(required = false) Long id) {
        if (id == null) {
            return readAll();
        }
        return read(id);
    }

    @PostMapping
    public void post(@RequestBody Account account) {
        accountService.create(toEntity(account));
    }

    @PutMapping
    public void put(@RequestBody Account account) {
        accountService.update(toEntity(account));
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        accountService.delete(id);
    }

    private Accounts read(Long id) {
        return new Accounts(Collections.singletonList(accountService.read(id)));
    }

    private Accounts readAll() {
        return new Accounts(accountService.readAll());
    }

    private ua.alekstar.moneysaver.dao.entities.Account toEntity(Account account) {
        final Currency currency = currencyService.readByIsoCode(account.getCurrency());
        return new ua.alekstar.moneysaver.dao.entities.Account(account.getId(), account.getName(), currency);
    }

}
