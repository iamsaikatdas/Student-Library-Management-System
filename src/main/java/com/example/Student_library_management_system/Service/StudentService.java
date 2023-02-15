package com.example.Student_library_management_system.Service;

import com.example.Student_library_management_system.DTOs.StudentUpdateEmailDto;
import com.example.Student_library_management_system.DTOs.StudentUpdatePhoneNo;
import com.example.Student_library_management_system.Enums.CardStatus;
import com.example.Student_library_management_system.Models.Book;
import com.example.Student_library_management_system.Models.Card;
import com.example.Student_library_management_system.Models.Student;
import com.example.Student_library_management_system.Repository.CardRepository;
import com.example.Student_library_management_system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardRepository cardRepository;

    public String createStudent(Student student){

        // student attributes sets

        // card should be auto generated when createStudent function called
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student); // it is foreign key

        // lets go to the student
        student.setCard(card);

        // if there was a unidirectional mapping : we had to save both

        // if there was a bidirectional mapping: we had to save only parent, child automatic save
        studentRepository.save(student);
        return student.getName() + " your details saved successfully";


    }

//    public List<Student> getAllStudent() {
//        List<Student> st = studentRepository.getAllStudent();
//        return st;
//    }
//
    public List<String> getStudentWithEmail(String email){
        Student student = studentRepository.findByEmail(email);
        List<String> list = new ArrayList<>();
        list.add("Name: " + student.getName());
        list.add("Email: " +student.getEmail());
        list.add("Country: " + student.getCountry());
        return list;
    }
    public String updateMobileNo(StudentUpdatePhoneNo studentUpdatePhoneNo){
        // directly jodi newStudent ke save kori tahole others attributes null hoyejabe.

        // convert the dto to actual object or entity it helps can save data

        // first - the fetch original data;
        Student originalStudet = studentRepository.findById(studentUpdatePhoneNo.getId()).get();

        // other properties omon e thakbe jeta required thakbe otai change hobe.
        originalStudet.setPhNo(studentUpdatePhoneNo.getPhNo());

        // save the original student
        studentRepository.save(originalStudet);

        return "Student has been update successfully.";
    }

    public List<String> getStudentWithPhNo(String phNo){
        Student student = studentRepository.findByPhNo(phNo);
        List<String> list = new ArrayList<>();
        list.add("Name: " + student.getName());
        list.add("Phone No.: " + student.getPhNo());
        return list;
    }


    public String updateEmail(StudentUpdateEmailDto studentUpdateEmailDto){
        Student originalObject = studentRepository.findById(studentUpdateEmailDto.getId()).get();
        originalObject.setEmail(studentUpdateEmailDto.getEmail());
        studentRepository.save(originalObject);
        return "Email has been updated";
    }
}
