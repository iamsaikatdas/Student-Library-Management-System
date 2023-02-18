package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Query(value = "select * from card", nativeQuery = true)
    public List<Card> getAllCardDetails();
}
