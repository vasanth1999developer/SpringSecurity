package com.vasanth.springsecurity.students;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {


    private static final List<Student> StudentsList = Arrays.asList(
            new Student(1,"vasanth"),
            new Student(2,"rahul"),
            new Student(3,"vijay")

    );



    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){


        return StudentsList.stream().
                filter(stu -> studentId.equals(stu.getStudentId())).
                findFirst().
                orElseThrow(()-> new IllegalArgumentException("studen "+studentId+" does not exist"));
    }


}
