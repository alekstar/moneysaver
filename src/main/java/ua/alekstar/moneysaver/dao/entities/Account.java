package ua.alekstar.moneysaver.dao.entities;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Currency currency;

    private Account() {

    }

    public Account(Long id, String name, Currency currency) {
        this(name, currency);
        this.id = id;
    }

    public Account(String name, Currency currency) {
        this.name = name;
        this.currency = currency;
    }

    public Account(Account account) {
        this(account.getName(), account.getCurrency());
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
