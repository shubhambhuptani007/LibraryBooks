package com.example.LibraryBooks.Entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {

    @Id
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "password cannot be empty")
    private String password;
    @NotNull(message = "salary cannot be empty")
    private int salary;
    private List<Book> loans;

}
