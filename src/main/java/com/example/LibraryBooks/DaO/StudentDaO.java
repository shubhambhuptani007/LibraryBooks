package com.example.LibraryBooks.DaO;


import com.example.LibraryBooks.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDaO extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
