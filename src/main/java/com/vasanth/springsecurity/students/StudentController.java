package com.vasanth.springsecurity.students;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {




    private List<Student> studentsList = new ArrayList<>(Arrays.asList(
            new Student(1,"vasanth"),
            new Student(2,"rahul"),
            new Student(3,"vijay"),
            new Student(4,"vasu"),
            new Student(5,"jeeva"),
            new Student(6,"soundar")
    ));

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId,HttpServletRequest requestt){

        System.out.println("Your Session Id = " + requestt.getSession().getId());
        return studentsList.stream().
                filter(stu -> studentId.equals(stu.getStudentId())).
                findFirst().
                orElseThrow(()-> new IllegalArgumentException("studen "+studentId+" does not exist" +"Your Session Id = " + requestt.getSession().getId() ));
    }


   @GetMapping(path = "list")
   public List<Student> getList(HttpServletRequest requestt){
       System.out.println("Your Session Id = " + requestt.getSession().getId());
        return studentsList;
   }


    @GetMapping(path = "csrf")
    public CsrfToken getCsrf(HttpServletRequest requestt){
        return (CsrfToken) requestt.getAttribute("_csrf");
    }



    @PostMapping(path = "list")
    public Student addToList(HttpServletRequest requestt,@RequestBody Student student){

        System.out.println("Your Session Id = " + requestt.getSession().getId());
        studentsList.add(student);
        return student;
    }




}
