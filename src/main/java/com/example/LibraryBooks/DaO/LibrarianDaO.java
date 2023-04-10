package com.example.LibraryBooks.DaO;

import com.example.LibraryBooks.Entity.Librarian;
import com.example.LibraryBooks.Entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianDaO extends JpaRepository<Librarian,String> {
    Library findByName(String name);
}
