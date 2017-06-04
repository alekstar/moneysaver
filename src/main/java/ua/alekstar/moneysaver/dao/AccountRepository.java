package ua.alekstar.moneysaver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.alekstar.moneysaver.dao.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
