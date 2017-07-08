package ua.alekstar.moneysaver.rest;

import org.springframework.web.bind.annotation.*;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.rest.transaction.Transaction;
import ua.alekstar.moneysaver.rest.transaction.Transactions;
import ua.alekstar.moneysaver.service.AccountService;
import ua.alekstar.moneysaver.service.TransactionService;

import static java.util.Collections.singletonList;

@RestController
@RequestMapping("/json/transaction")
public class TransactionJsonRestController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionJsonRestController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping
    @ResponseBody
    public Transactions get(@RequestParam(required = false) Long id){
        if (id == null) {
            return readAll();
        }
        return read(id);
    }

    @PostMapping
    public void post(@RequestBody Transaction transaction) {
        transactionService.create(toEntity(transaction));
    }

    @PutMapping
    public void put(@RequestBody Transaction transaction) {
        transactionService.update(toEntity(transaction));
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        transactionService.delete(id);
    }

    private Transactions readAll() {
        return new Transactions(transactionService.readAll());
    }

    private Transactions read(Long id) {
        return new Transactions(singletonList(transactionService.read(id)));
    }

    private ua.alekstar.moneysaver.dao.entities.Transaction toEntity(Transaction transaction) {
        final Account account = accountService.readWithCheck(transaction.getAccountId());
        return new ua.alekstar.moneysaver.dao.entities.Transaction(transaction.getId(), transaction.getTime(), account,
                transaction.getAmount());
    }

}
