package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=DvEvhB20e2s
@Controller // tells Spring Boot that this class represents controllers
@RequestMapping("hello")
//@ResponseBody
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
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles both GET and POST requests
    // lives at /hello/hellogoodbye
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
    @GetMapping("{name}")
    @ResponseBody
    public String hellowWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // 10.2.6 Check Your Understanding
    // lives at hello/venus
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
    // lives at hello/venus
    @GetMapping("venus/{orbiter}")
    @ResponseBody
    public String venusOrbiter(@PathVariable String orbiter) {
        return orbiter + " currently orbits Venus.";
    }

    /**
    // https://www.youtube.com/watch?v=LQxzrKPnUGY
    // lives at hello/form
    // replaced in 11.2 Creating a Template
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
    */

    /**
    // Replaced by 11.5. Conditionals in a Template dynamic / Thymeleaf way below
    @RequestMapping(method={ RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    */

    // 10.4.3 Check Your Understanding
    @RequestMapping(method={ RequestMethod.POST, RequestMethod.GET }, value="friend")
    @ResponseBody
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
    @ResponseBody
    public String helloFriend(@RequestParam String name, @RequestParam String friend) {
        return "Hello, " + name + " and " + friend + "!";
    }

    // 10.5 Exercise
    @GetMapping("exerciseform")
    @ResponseBody
    public String greetingForm() {
        String html =
                "<html>" +
                    "<body>" +
                        "<form action='exercise' method='post'>" +
                        "<input type='text' name='name'>" +
                        "<select name='greetings' id='greetings-select'>" +
                            "<option value=''>--Please choose a language--</option>" +
                            "<option value='farsi'>Farsi</option>" +
                            "<option value='german'>German</option>" +
                            "<option value='hindi'>Hindi</option>" +
                            "<option value='italian'>Italian</option>" +
                            "<option value='swissGerman'>Swiss German</option>" +
                        "</select>" +
                        "<input type='submit' value='Greet me!'/>" +
                        "</form>" +
                    "</body>" +
                "</html>";

        return html;
    }

    // 10.5 Exercise
    @PostMapping("exercise")
    @ResponseBody
    public String greeting(@RequestParam String name, @RequestParam String greetings) {
        String greetingString = "";
        switch (greetings) {
            case "farsi": greetingString = "Salaam ";
                break;
            case "german": greetingString = "Guten tag ";
                break;
            case "hindi": greetingString = "Namaste ";
                break;
            case "italian": greetingString = "Ciao ";
                break;
            case "swissGerman": greetingString = "Grüezi ";
                break;
            default:
                break;
        }

        String html =
                "<html>" +
                    "<body>" +
                        "<p style='background-color:SlateBlue; color:yellow; font-size:5em; font-weight:bold;" +
                        "font-style:italic'>" +
                        greetingString + name +
                        "</p>" +
                    "</body>" +
                "</html>";
        return html;
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    // 11.5. Conditionals in a Template
    // https://www.youtube.com/watch?v=bT5Zt9xZYSU
    // lives at /hello
    @RequestMapping(method={ RequestMethod.POST, RequestMethod.GET })
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // 11.5. Conditionals in a Template
    // https://www.youtube.com/watch?v=bT5Zt9xZYSU
    // lives at /hello/hello-names
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>(
                List.of("C++", "Go", "Haskell", "Java", "Python", "Swift")
        );
        model.addAttribute("names", names);
        return "hello-list";    // Thymeleaf template
    }

}
