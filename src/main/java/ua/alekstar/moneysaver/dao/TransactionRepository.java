package ua.alekstar.moneysaver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.alekstar.moneysaver.dao.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
