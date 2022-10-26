package org.launchcode.hellospring.controllers;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

// A ROUTE IS THE MECHANISM BY WHICH A REQUEST PATH GETS ASSIGNED TO A CONTROLLER

// this controller has no routing information associated with it
@Controller
//@ResponseBody goes right here under @Controller if every method w/in the class has the annotation
//@RequestMapping(" ") sets the path for all the methods, /" " (ROUTE AT CONTROLLER LEVEL)
public class HelloController {

    //and this method has no routing information, so by default it will live at the route path
    @GetMapping
    @ResponseBody
    public String helloRea() { return "Hello, Rea!";}

    // the " " handles request at path /" " AND IT IS CASE SENSITIVE
    @GetMapping("helloSpring") //(ROUTE AT METHOD LEVEL
    @ResponseBody
    public String hello() {return "Hello, Spring!";}

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {return "Goodbye, Spring!";}

    //QUERY STRINGS ARE URL DATA - a dynamic handler that will accept data

    // this handles request with query data /hello-again?name=" " <- string query param "name" goes there
    @GetMapping("helloAgain")
    @ResponseBody
    public String helloAgainWithQueryParam(@RequestParam String name) {return "Hello again, " + name + "!";}


    // handles requests with dynamic data as part of path /hello/LaunchCode <-  data(param/variable)
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //handles data through FORM
    //action specifies where, below example lives at /helloAgain
    // /helloAgain already has a controller that handles the param name helloAgainWithQueryParam

    @GetMapping("formOne")
    @ResponseBody
    public String helloAgainFormOne() {
        return "<html>" +
            "<body>" +
                "<form action='helloAgain'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    // rather than get or post, use mapping
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) { return "Hello, " +name+ "!";}

    @GetMapping("formTwo")
    @ResponseBody
    public String helloFormTwo() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}