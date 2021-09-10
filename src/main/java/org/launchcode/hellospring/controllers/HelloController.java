package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // tells Spring Boot that this class represents controllers
public class HelloController {

    /**
    // handles request at path /hello
    @GetMapping("hello") // tells Spring Boot that this method will only handle GET requests
    @ResponseBody   // tells Spring Boot it will return a plain response
    public String hello() {
        return "Hello, Spring!";
    }
    */

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

    // https://www.youtube.com/watch?v=cXwlynCtZSM
    // Handles request of the form /hello?name={name}
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // https://www.youtube.com/watch?v=lRNO0eAcSs4
    // Responds to get requests at /hello/{name}
    @GetMapping("hello/{name}")
    @ResponseBody
    public String hellowWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
