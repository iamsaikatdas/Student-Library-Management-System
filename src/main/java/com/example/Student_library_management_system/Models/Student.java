package com.example.Student_library_management_system.Models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "Email_address", unique = true)
    private String email;

    @Column(name = "Mobile_no", unique = true)
    private String phNo;

    private int age;
    private String country;


    // bidirectional mapping syntax

    // 1. mappedBy = " " -> jei naam ta ache seti child class e jokhn foreign key
    // dei tate jei variable er naam ta ache parent class er setai ata
    // 2. name of variable of the parent entity that you have return in the child class
    // foreign key attributes
    @OneToOne(mappedBy = "studentVariableName", cascade = CascadeType.ALL)
    private Card card; // eakhne akta student er aktai card thekbe tai card kei use kora hoyeche.


    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }

    public Student() {
    }

    public Student(int id, String name, String email, String phNo, int age, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phNo = phNo;
        this.age = age;
        this.country = country;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
