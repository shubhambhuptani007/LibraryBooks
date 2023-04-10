package com.example.LibraryBooks.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Library {

    @Id
    @NotNull(message = "Id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "location cannot be empty")
    private String location;
    private List<Book> books;

}
