package com.example.Student_library_management_system.Service.Controllers;

import com.example.Student_library_management_system.DTOs.BookEntryDto;
import com.example.Student_library_management_system.DTOs.IssueBookRequestDto;
import com.example.Student_library_management_system.Models.Book;
import com.example.Student_library_management_system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookEntryDto bookEntryDto){
        return bookService.addBook(bookEntryDto);
    }

}
