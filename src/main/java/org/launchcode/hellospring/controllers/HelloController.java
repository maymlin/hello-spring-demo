package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// https://www.youtube.com/watch?v=DvEvhB20e2s
@Controller // tells Spring Boot that this class represents controllers
@RequestMapping("hello")
@ResponseBody
public class HelloController {

    /**
    // handles request at path /hello
    @GetMapping("hello") // tells Spring Boot that this method will only handle GET requests
    @ResponseBody   // tells Spring Boot it will return a plain response
    public String hello() {
        return "Hello, Spring!";
    }
    */

    // lives at /hello/goodbye
    @GetMapping("goodbye")  // handles request at path /goodbye
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles both GET and POST requests
    // lives at /hello/hellogoodbye
    @RequestMapping(value="hellogoodbye", method = {RequestMethod.POST, RequestMethod.GET})
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
    @GetMapping("{name}")
    public String hellowWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // 10.2.6 Check Your Understanding
    // lives at hello/venus
    @GetMapping("venus")
    public String venusSurface(@RequestParam boolean terrestrial) {
        if (terrestrial == true) {
            return "Venus is rocky.";
        } else {
            return "Venus is gaseous.";
        }
    }

    // 10.2.6 Check Your Understanding
    // lives at hello/venus
    @GetMapping("venus/{orbiter}")
    public String venusOrbiter(@PathVariable String orbiter) {
        return orbiter + " currently orbits Venus.";
    }

    // https://www.youtube.com/watch?v=LQxzrKPnUGY
    // lives at hello/form
    @GetMapping("form")
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

    @RequestMapping(method={ RequestMethod.POST, RequestMethod.GET })
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // 10.4.3 Check Your Understanding
    @RequestMapping(method={ RequestMethod.POST, RequestMethod.GET }, value="friend")
    public String helloFriendForm() {
        String html =
                "<html>" +
                    "<body>" +
                        "<form method='post' action='helloFriend' />" +
                            "<input type='text' name='name' />" +
                            "<input type='text' name='friend' />" +
                            "<input type='submit' value='Greet Us!' />" +
                        "</form>" +
                    "</body>" +
                "<html>";

        return html;
    }

    // 10.4.3 Check Your Understanding
    @RequestMapping(value="helloFriend", method={ RequestMethod.POST, RequestMethod.GET })
    public String helloFriend(@RequestParam String name, @RequestParam String friend) {
        return "Hello, " + name + " and " + friend + "!";
    }
}
