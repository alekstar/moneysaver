package ua.alekstar.moneysaver.dao.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime time;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Account account;

    private BigDecimal amount;

    private Transaction() {};

    public Transaction(LocalDateTime time, Account account, BigDecimal amount) {
        this(null, time, account, amount);
    }

    public Transaction(Long id, LocalDateTime time, Account account, BigDecimal amount) {
        this();
        this.id = id;
        this.time = time;
        this.account = account;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
