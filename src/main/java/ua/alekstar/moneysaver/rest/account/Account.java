package ua.alekstar.moneysaver.rest.account;

import ua.alekstar.moneysaver.dao.entities.Currency;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private String name;
    private String currency;
    private BigDecimal amount;

    private Account() {

    }

    public Account(Long id, String name, Currency currency) {
        this();
        this.id = id;
        this.name = name;
        this.currency = currency.getIsoCode();
    }

    public Account(ua.alekstar.moneysaver.dao.entities.Account account) {
        this(account.getId(), account.getName(), account.getCurrency());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
