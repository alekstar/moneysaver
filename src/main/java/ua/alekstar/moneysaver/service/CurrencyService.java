package ua.alekstar.moneysaver.service;

import ua.alekstar.moneysaver.dao.entities.Currency;

public interface CurrencyService {

    void create(Currency currency);

    Iterable<Currency> readAll();

    Currency read(Long id);

    void update(Currency currency);

    void delete(Long id);

    Currency readByIsoCode(String isoCode);
}
