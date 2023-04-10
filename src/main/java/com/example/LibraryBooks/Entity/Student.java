package com.example.LibraryBooks.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Student{

    @Id
    @NotNull(message = "Matric no cannot be null")
    private int matricNo;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @OneToOne
    private List<Book> books;

}
