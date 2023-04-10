package com.example.LibraryBooks.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String title;
    private String author;
    private String year;
    @OneToOne
    private Person onLoanTo;
    @OneToOne
    private Library ownedBy;

}
