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

    private void setId(Long id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    private void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    private void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public ua.alekstar.moneysaver.dao.entities.Currency toEntity() {
        return ua.alekstar.moneysaver.dao.entities.Currency.builder()
                .withId(getId())
                .withIsoCode(getIsoCode())
                .withName(getName())
                .withSymbol(getSymbol())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Currency currency;

        private Builder() {
            currency = new Currency();
        }

        public Builder withId(Long id) {
            currency.setId(id);
            return this;
        }
        public Builder withIsoCode(String isoCode) {
            currency.setIsoCode(isoCode);
            return this;
        }
        public Builder withName(String name) {
            currency.setName(name);
            return this;
        }
        public Builder withSymbol(Character symbol) {
            currency.setSymbol(symbol);
            return this;
        }

        public Currency build() {
            return this.currency;
        }
    }
}
