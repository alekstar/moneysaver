package ua.alekstar.moneysaver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.alekstar.moneysaver.dao.entities.Currency;

@Component
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    Currency readByIsoCode(String isoCode);
}
