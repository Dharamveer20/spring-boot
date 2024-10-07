package com.in28minutes.rest.webservices.restfulwebservices.user;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Schema(description = "User entity representing a person in the system")
public class User {

    @Schema(description = "Unique identifier of the user", example = "1")
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @Schema(description = "Full name of the user", example = "John Doe")
    private String name;

    @Past(message = "Birthdate must be in the past")
    @Schema(description = "User's date of birth", example = "1990-12-31")
    private LocalDate birthDate;

    // Constructor, Getters, and Setters
    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }

}

