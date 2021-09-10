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

    /**
    // https://www.youtube.com/watch?v=cXwlynCtZSM
    // Handles request of the form /hello?name={name}
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    */

    // https://www.youtube.com/watch?v=lRNO0eAcSs4
    // Responds to get requests at /hello/{name}
    @GetMapping("hello/{name}")
    @ResponseBody
    public String hellowWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // 10.2.6 Check Your Understanding
    @GetMapping("venus")
    @ResponseBody
    public String venusSurface(@RequestParam boolean terrestrial) {
        if (terrestrial == true) {
            return "Venus is rocky.";
        } else {
            return "Venus is gaseous.";
        }
    }

    // 10.2.6 Check Your Understanding
    @GetMapping("venus/{orbiter}")
    @ResponseBody
    public String venusOrbiter(@PathVariable String orbiter) {
        return orbiter + " currently orbits Venus.";
    }

    // https://www.youtube.com/watch?v=LQxzrKPnUGY
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                    "<body>" +
                        "<form method='post' action='/hello'>" +
                            "<input type='text' name='name' />" +
                            "<input type='submit' value='Greet Me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
        return html;
    }

    @RequestMapping(value="hello", method={ RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
}
