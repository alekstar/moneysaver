package ua.alekstar.moneysaver.dao;

import org.springframework.data.repository.CrudRepository;
import ua.alekstar.moneysaver.dao.entities.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

}
