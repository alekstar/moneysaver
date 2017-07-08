package ua.alekstar.moneysaver.rest;

import org.springframework.web.bind.annotation.*;
import ua.alekstar.moneysaver.rest.transaction.Transaction;
import ua.alekstar.moneysaver.rest.transaction.Transactions;
import ua.alekstar.moneysaver.service.AccountService;
import ua.alekstar.moneysaver.service.TransactionService;

import static java.util.Collections.singletonList;

@RestController
@RequestMapping("/json/transaction")
public class TransactionJsonRestController {

    private final TransactionService transactionService;
    private final TransactionRestService transactionRestService;

    public TransactionJsonRestController(TransactionService transactionService,
                                         TransactionRestService transactionRestService) {

        this.transactionService = transactionService;
        this.transactionRestService = transactionRestService;
    }

    @GetMapping
    @ResponseBody
    public Transactions get(@RequestParam(required = false) Long id){
        if (id == null) {
            return transactionRestService.readAll();
        }
        return transactionRestService.read(id);
    }

    @PostMapping
    public void post(@RequestBody Transaction transaction) {
        transactionRestService.create(transaction);
    }

    @PutMapping
    public void put(@RequestBody Transaction transaction) {
        transactionRestService.update(transaction);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        transactionService.delete(id);
    }

}
