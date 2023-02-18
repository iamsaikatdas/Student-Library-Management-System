package com.example.Student_library_management_system.Service.Controllers;

import com.example.Student_library_management_system.DTOs.AuthorEntryDto;
import com.example.Student_library_management_system.Models.Author;
import com.example.Student_library_management_system.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.addAuthor(authorEntryDto);
    }

    @GetMapping("/getAllAuthor")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/getAllAuthorById")
    public Author getAuthorById(@RequestBody int id){
        return authorService.getAuthorById(id);
    }


}

