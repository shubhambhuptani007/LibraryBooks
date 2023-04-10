package com.example.LibraryBooks.DaO;

import com.example.LibraryBooks.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDaO extends JpaRepository<Book,String> {
}
