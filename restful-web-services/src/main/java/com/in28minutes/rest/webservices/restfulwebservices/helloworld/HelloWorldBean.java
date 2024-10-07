package com.in28minutes.rest.webservices.restfulwebservices.helloworld;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "A simple bean that holds a hello world message")
public class HelloWorldBean {

    @Schema(description = "Message to display", example = "Hello, World!")
    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
