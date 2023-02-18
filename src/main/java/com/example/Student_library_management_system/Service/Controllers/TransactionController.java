package com.example.Student_library_management_system.Service.Controllers;

import com.example.Student_library_management_system.DTOs.IssueBookRequestDto;
import com.example.Student_library_management_system.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) {
        try {
            return transactionService.issueBook(issueBookRequestDto);
        }catch (Exception e){
           return e.getMessage();
        }
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId") int bookId, @RequestParam("cardId") int cardId){
        return transactionService.getTransactions(bookId, cardId);
    }
}
