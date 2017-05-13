package ua.alekstar.moneysaver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.alekstar.moneysaver.dao.entities.Account;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {

}
