package com.example.Student_library_management_system.Models;

import com.example.Student_library_management_system.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // auto

    // auto timestamp the time when an entry created
    @CreationTimestamp
    private Date createdOn; // auto

    // sets timestamp when an entry updated
    @UpdateTimestamp
    private Date updateOn; // auto

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus; // done


    // card child holo student class
    // mapping for foreign key
    @OneToOne
    @JoinColumn
    private Student studentVariableName; // this variable name is used in the parent class
    // while doing bidirectional mapping
    // done


    // card parent holo book class
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> bookIssued; // akti card e ank book thakte pare.

    // parent table of transaction table;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public List<Book> getBookIssued() { return bookIssued;}
    public void setBookIssued(List<Book> bookIssued) {this.bookIssued = bookIssued;}
    public Student getStudentVariableName() {
        return studentVariableName;
    }
    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }
    public Card() {
        bookIssued = new ArrayList<>();
    }

    public Card(int id, Date createdOn, Date updateOn, CardStatus cardStatus) {
        this.id = id;
        this.createdOn = createdOn;
        this.updateOn = updateOn;
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
