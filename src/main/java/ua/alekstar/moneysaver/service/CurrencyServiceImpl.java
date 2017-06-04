package ua.alekstar.moneysaver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alekstar.moneysaver.dao.CurrencyRepository;
import ua.alekstar.moneysaver.dao.entities.Currency;

import static ua.alekstar.moneysaver.dao.entities.Currency.currencyForCreate;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void create(Currency currency) {
        currencyRepository.save(currencyForCreate(currency));
    }

    @Override
    public Iterable<Currency> readAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency read(Long id) {
        return currencyRepository.findOne(id);
    }

    @Override
    public void update(Currency currency) {
        currencyRepository.save(currency);
    }

    @Override
    public void delete(Long id) {
        currencyRepository.delete(id);;
    }

    @Override
    public Currency readByIsoCode(String isoCode) {
        return currencyRepository.readByIsoCode(isoCode);
    }
}
