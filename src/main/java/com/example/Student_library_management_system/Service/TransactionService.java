package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.DTOs.IssueBookRequestDto;
import com.example.Student_library_management_system.Enums.CardStatus;
import com.example.Student_library_management_system.Enums.TransactionStatus;
import com.example.Student_library_management_system.Models.Book;
import com.example.Student_library_management_system.Models.Card;
import com.example.Student_library_management_system.Models.Transactions;
import com.example.Student_library_management_system.Repository.BookRepository;
import com.example.Student_library_management_system.Repository.CardRepository;
import com.example.Student_library_management_system.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
        // 1 - step (fetch bookid and cardid)
        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        // get the book entity and card entity bcz we want to set transaction attributes;
        // 2 - step ( then search book and card with id)
        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        // 3 - set its attributes and save it;
        Transactions transactions = new Transactions();
            // setting the transaction attributes;
        transactions.setBook(book);
        transactions.setCard(card);
        // transactions.setTransactionId(UUID.randomUUID().toString());
        transactions.setIssueOperation(true);

        transactions.setTransactionStatus(TransactionStatus.PENDING);

            // check for validations;
            // transaction success/failed
        if (book == null || book.isIssued()==true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");
        }
        if (card == null || card.getCardStatus() != CardStatus.ACTIVATED){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Card is not valid");
        }
            // success case
        transactions.setTransactionStatus(TransactionStatus.SUCCESS);


            // se the attributes of book
        book.setIssued(true);
            // akta book ank bar transaction hocche tar e list
            // between the book and transaction : bidirectional
        List<Transactions> listOfTransactionForBook = book.getTransactionsList(); // getting the list of transaction
        listOfTransactionForBook.add(transactions); // adding the current transaction
        book.setTransactionsList(listOfTransactionForBook); // setting it back

            // need to make change in card
            // akta book ank bar transaction hocche tar e list
            // Book and card
        List<Book> issuedBooksForCard = card.getBookIssued(); // getting the list of transaction
        issuedBooksForCard.add(book); // adding the current transaction
        card.setBookIssued(issuedBooksForCard); // setting is back

            // card and the transaction : bidirectional
        List<Transactions> listOfTransactionForCard = card.getTransactionsList(); // getting the list of transaction
        listOfTransactionForCard.add(transactions); // adding the current transaction
        card.setTransactionsList(listOfTransactionForCard); // setting it back


        // save the parent
        cardRepository.save(card);

        // automatically book and transaction save by the cascading
        // saving the parent

        return "Book issued successfully from issue book.";
    }

    public String   getTransactions(int bookId, int cardId){

        List<Transactions> transactionsLists = transactionRepository.getTransactionForBookAndCard(bookId, cardId);
        String transactionId = transactionsLists.get(1).getTransactionId();

        return transactionId;
//       return list;
    }

}
