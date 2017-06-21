package ua.alekstar.moneysaver.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.alekstar.moneysaver.dao.entities.Account;
import ua.alekstar.moneysaver.dao.entities.Transaction;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Iterable<Transaction> findByAccountIdOrderByTime(Long accountId);

    @Query(value = "select sum(amount) from ua.alekstar.moneysaver.dao.entities.Transaction where account_id = ?1")
    BigDecimal calculateAmountForAccount(Long accountId);
}
