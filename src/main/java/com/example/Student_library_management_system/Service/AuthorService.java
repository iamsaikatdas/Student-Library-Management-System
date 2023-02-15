package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.DTOs.AuthorEntryDto;
import com.example.Student_library_management_system.Models.Author;
import com.example.Student_library_management_system.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(AuthorEntryDto authorEntryDto){
        // jkhn dto use korbo takhn, amk dto ke actual object e convert korte hobe.
        // because, db only store object, or dto is not object.

        // convert DTO to original object
        Author author = new Author();
        // and set the attributes
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setName(authorEntryDto.getName());
        author.setPhNo(authorEntryDto.getPhNo());
        author.setRating(authorEntryDto.getRating());
        // save the author
        authorRepository.save(author);
        return "Author details successfully added, and author name is: " + author.getName();
    }
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    public Author getAllAuthorById(int id) {
        return authorRepository.findById(id).get();
    }
}
