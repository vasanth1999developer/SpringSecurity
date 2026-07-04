package com.vasanth.springsecurity.students;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/sessionID")

    public String grettings(HttpServletRequest requestt){

        return "welcome Vasanth Your Session Id = "+ requestt.getSession().getId();
    }
}
