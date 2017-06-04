package ua.alekstar.moneysaver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.alekstar.moneysaver.dao.entities.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    Currency readByIsoCode(String isoCode);
}
