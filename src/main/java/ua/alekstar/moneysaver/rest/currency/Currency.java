package ua.alekstar.moneysaver.rest.currency;

public class Currency {

    private Long id;
    private String isoCode;
    private String name;
    private Character symbol;

    private Currency() {}

    private Currency(Long id, String isoCode, String name, Character symbol) {
        this();
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
        this.symbol = symbol;
    }

    public Currency(ua.alekstar.moneysaver.dao.entities.Currency currency) {
        this(currency.getId(), currency.getIsoCode(), currency.getName(), currency.getSymbol());
    }

    public Long getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getName() {
        return name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public ua.alekstar.moneysaver.dao.entities.Currency toEntity() {
        return new ua.alekstar.moneysaver.dao.entities.Currency(getId(), getIsoCode(), getName(), getSymbol());
    }
}
