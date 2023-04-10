package com.example.LibraryBooks.DaO;

import com.example.LibraryBooks.Entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDaO extends JpaRepository<Library,Integer> {
    Library findByName(String name);
}
