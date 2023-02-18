package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

    // this is native query or custom query
    @Query(value = "select * from transactions t where t.book_id=:bookId and t.card_id=:cardId and " +
            "is_issue_operation=true", nativeQuery = true)
    public List<Transactions> getTransactionForBookAndCard(int bookId, int cardId);

    @Query(value = "select * from transactions t where t.book_id=:bookId", nativeQuery = true)
    public List<Transactions> getTransactionForBook(int bookId);

}
