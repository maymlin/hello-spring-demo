package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // tells Spring Boot that this class represents controllers
public class HelloController {

    // handles request at path /hello
    @GetMapping("hello") // tells Spring Boot that this method will only handle GET requests
    @ResponseBody   // tells Spring Boot it will return a plain response
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")  // handles request at path /goodbye
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles both GET and POST requests
    @RequestMapping(value="hellogoodbye", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String helloGoodbye() {
        return "Hello and good bye, Spring!";
    }
}
