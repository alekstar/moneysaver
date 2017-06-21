package ua.alekstar.moneysaver.rest;

import org.springframework.web.bind.annotation.*;
import ua.alekstar.moneysaver.dao.entities.Currency;
import ua.alekstar.moneysaver.rest.account.Account;
import ua.alekstar.moneysaver.rest.account.Accounts;
import ua.alekstar.moneysaver.rest.transaction.Transactions;
import ua.alekstar.moneysaver.service.AccountService;
import ua.alekstar.moneysaver.service.CurrencyService;
import ua.alekstar.moneysaver.service.TransactionService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/json/account")
public class AccountJsonRestController {

    private final AccountService accountService;
    private final CurrencyService currencyService;
    private final TransactionService transactionService;

    public AccountJsonRestController(AccountService accountService, CurrencyService currencyService,
                                     TransactionService transactionService) {
        this.accountService = accountService;
        this.currencyService = currencyService;
        this.transactionService = transactionService;
    }

    @GetMapping
    @ResponseBody
    public Accounts get(@RequestParam(required = false) Long id) {
        if (id == null) {
            return readAll();
        }
        return read(id);
    }

    @GetMapping(path ="{accountId}/transactions")
    @ResponseBody
    public Transactions getTransactions(@PathVariable(name = "accountId") Long id) {
        return new Transactions(accountService.readTransactions(id));
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
        final ua.alekstar.moneysaver.dao.entities.Account account = accountService.read(id);
        final Account restAccount = new Account(account);
        restAccount.setAmount(transactionService.calculateAmountForAccount(account.getId()));
        return new Accounts(Collections.singletonList(restAccount));
    }

    private Accounts readAll() {
        final Iterable<ua.alekstar.moneysaver.dao.entities.Account> accounts = accountService.readAll();
        final List<Account> restAccounts = StreamSupport.stream(accounts.spliterator(), false)
                .map(Account::new)
                .collect(Collectors.toList());
        restAccounts.forEach(a -> a.setAmount(transactionService.calculateAmountForAccount(a.getId())));
        return new Accounts(restAccounts);
    }

    private ua.alekstar.moneysaver.dao.entities.Account toEntity(Account account) {
        final Currency currency = currencyService.readByIsoCode(account.getCurrency());
        return new ua.alekstar.moneysaver.dao.entities.Account(account.getId(), account.getName(), currency);
    }

}
