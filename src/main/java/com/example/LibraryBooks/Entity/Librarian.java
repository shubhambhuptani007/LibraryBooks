package com.example.LibraryBooks.Entity;

import jakarta.persistence.Id;
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
    private String name;
    private String password;
    private int salary;
    private List<Book> loans;

}
