package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.DTOs.BookEntryDto;
import com.example.Student_library_management_system.DTOs.IssueBookRequestDto;
import com.example.Student_library_management_system.Models.Author;
import com.example.Student_library_management_system.Models.Book;
import com.example.Student_library_management_system.Repository.AuthorRepository;
import com.example.Student_library_management_system.Repository.BookRepository;
import com.example.Student_library_management_system.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CardRepository cardRepository;

    public String addBook(BookEntryDto bookEntryDto){
        // -------------------------------------------------------------------
        // ############### Author details sett hocche eakhne ##################
        // first author details adding done, then book add korte jaoar somoi amr book ke auther
        // issue korte hobe, thole through author details author issue hoyjabe.

        // convert DTO to original object;
        Book book = new Book();
        int authorId = bookEntryDto.getAuthorId(); // get the author id
        book.setBookGenre(bookEntryDto.getBookType());
        book.setBookPage(bookEntryDto.getBookPage());
        book.setBookName(bookEntryDto.getBookName());
        book.setRating(bookEntryDto.getRating());

        // then fetching the author entity
        Author author;
        try {
            author = authorRepository.findById(authorId).get(); // find the author entity, who is the author
        }catch (Exception e){
            return "Author details not found.";
        }

        // basic attributes already set by postman.

        // setting the foreign attributes in the child lass.
        book.setAuthor(author);  // set the particular book into the  author

        // udpate the listofbookswritten in the parent class;
        List<Book> currentBooksWritten = author.getBooksWritten();   // get have got list of books written;
        currentBooksWritten.add(book); // - set the list of books written

        // akhn author ke abar save (updating) korte hobe karon, kichu jinis author er chagne hoyeche.
        // resave/updating
        authorRepository.save(author); // data was modified (save function works on save & update also)

        // #########################################################################

        // update list of book
        // bookRepository.save(book); -- its not required : because cascading effect
        // book automatically saved, book is child of author;

        return book.getBookName() + ", book added successfully.";
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

}
