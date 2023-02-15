package com.example.Student_library_management_system.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String country;
    private int age;
    private String phNo;
    private double rating;


    // bidirectional mapping
    // jokhn one to many asbe tkhn list korte hobe, ba set ba hashmap
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    // eakhne akta child entity nei, ank child ache tai, list use hocche.
    private List<Book> booksWritten;  // akta author ank book likhte pare, tai eai khne list use kra hoyeche.


    public Author() {
        booksWritten = new ArrayList<>();
    }

    public List<Book> getBooksWritten() { return booksWritten; }

    public void setBooksWritten(List<Book> booksWritten) {this.booksWritten = booksWritten;}

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }
}
