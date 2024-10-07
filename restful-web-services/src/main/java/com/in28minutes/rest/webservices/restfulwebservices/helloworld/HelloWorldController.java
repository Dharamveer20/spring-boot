package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController Annotation
//The @RestController annotation tells Spring that this class will handle HTTP requests and return data directly to the browser or client, typically in JSON or XML format.
//Unlike @Controller, which usually returns views (like JSPs or HTML pages), @RestController returns data (like objects, strings, etc.) directly as a response body.
@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String helloWorld() {
//        RestController annotated hai isliye we are returning the string to the web not the jsp page
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
//    Spring converts this HelloWorldBean object into a JSON response, which is sent back to the client when they access /hello-world-bean
    }

//    Path Variable
    @GetMapping("/hello-world-path-variable/{name}") // ${name} here is dynamic part of the url which user will enter
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) { // @PathVariable with bind String name with name passed in url
        return new HelloWorldBean("Path Variable " + name);
    }
}
