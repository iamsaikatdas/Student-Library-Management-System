package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.DTOs.IssueBookRequestDto;
import com.example.Student_library_management_system.Models.Book;
import com.example.Student_library_management_system.Models.Card;
import com.example.Student_library_management_system.Models.Transactions;
import com.example.Student_library_management_system.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto){
        Transactions transactions = new Transactions();
        Book book = new Book();

        return "Issue book request hits.";
    }

}
