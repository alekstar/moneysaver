package ua.alekstar.moneysaver.rest.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;
    private Long accountId;
    private BigDecimal amount;

    private Transaction() {
    }

    public Transaction(ua.alekstar.moneysaver.dao.entities.Transaction transaction) {
        this();
        this.id = transaction.getId();
        this.time = transaction.getTime();
        this.accountId = transaction.getAccount().getId();
        this.amount = transaction.getAmount();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Long getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
