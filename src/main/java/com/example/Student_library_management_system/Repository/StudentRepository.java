package com.example.Student_library_management_system.Repository;

import com.example.Student_library_management_system.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    // this is the second way to create custom queries, inbuilt by we need to define query
    Student findByEmail(String email);
    Student findByPhNo(String phNo);
    List<Student> findByCountry(String country);
}
