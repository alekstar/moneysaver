package ua.alekstar.moneysaver.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Currency  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String isoCode;
    private String name;
    private Character symbol;

    private Currency() {}

    public Currency(Long id, String isoCode, String name, Character symbol) {
        this(isoCode, name, symbol);
        this.id = id;
    }

    public Currency(String isoCode, String name, Character symbol) {
        this.isoCode = isoCode;
        this.name = name;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public static Currency currencyForCreate(Currency currency) {
        return new Currency(currency.getIsoCode(), currency.getName(), currency.getSymbol());
    }
}
