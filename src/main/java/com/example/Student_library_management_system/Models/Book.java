package com.example.Student_library_management_system.Models;

import com.example.Student_library_management_system.Enums.BookType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;
    private int bookPage;
    private double rating;

    @Enumerated(value = EnumType.STRING)
    private BookType bookType;


    // Book child holo author class er
    // Setting foreign key : with three steps
    @ManyToOne  // first current class and others is parent class - many is book, one is author
    @JoinColumn // parent table primary key holo foreign key
    private Author author; // this is the parent entity, connecting hocche child class e


    // book is also child with respect to card class
    // book child, abar card class er.
    // setting foreign key of card class
    @ManyToOne
    @JoinColumn
    private Card card;

    // parent of transaction table;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    private boolean isIssued;

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(int id, String bookName, int bookPage, BookType bookType, double rating) {
        this.id = id;
        this.bookName = bookName;
        this.bookPage = bookPage;
        this.bookType = bookType;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public BookType getBookGenre() {
        return bookType;
    }

    public void setBookGenre(BookType bookType) {
        this.bookType = bookType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
