package com.example.Student_library_management_system.Service.Controllers;

import com.example.Student_library_management_system.DTOs.StudentUpdateEmailDto;
import com.example.Student_library_management_system.DTOs.StudentUpdatePhoneNo;
import com.example.Student_library_management_system.Models.Student;
import com.example.Student_library_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student data successfully added";
    }

    @PutMapping("/updateMobileNo")
    public String updateMobileNo(@RequestBody StudentUpdatePhoneNo studentUpdatePhoneNo){
        return studentService.updateMobileNo(studentUpdatePhoneNo);
    }

    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody StudentUpdateEmailDto studentUpdateEmailDto){
        return studentService.updateEmail(studentUpdateEmailDto);
    }

    @GetMapping("/getStudentWithEmail/{email}")
    public List<String> getStudentWithEmail(@PathVariable("email") String email){
        return studentService.getStudentWithEmail(email);
    }

    @GetMapping("/getStudentWithPhNo/{phNo}")
    public List<String> getStudentWithPhNo(@PathVariable("phNo") String phNo){
        return studentService.getStudentWithPhNo(phNo);
    }
}
