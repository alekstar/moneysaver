package ua.alekstar.moneysaver.rest.currency;

public class Currency {

    private Long id;
    private String isoCode;
    private String name;
    private Character symbol;

    public Currency(Long id, String isoCode, String name, Character symbol) {
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
        this.symbol = symbol;
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
}
