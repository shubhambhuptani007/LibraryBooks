package com.example.LibraryBooks.RestController;

import com.example.LibraryBooks.DaO.BookDaO;
import com.example.LibraryBooks.DaO.LibrarianDaO;
import com.example.LibraryBooks.DaO.LibraryDaO;
import com.example.LibraryBooks.DaO.StudentDaO;
import com.example.LibraryBooks.Entity.Book;
import com.example.LibraryBooks.Entity.Student;
import com.example.LibraryBooks.Exceptions.BookExceptions.BookNotFoundException;
import com.example.LibraryBooks.Exceptions.StudentException.StudentAlreadyExistException;
import com.example.LibraryBooks.Exceptions.StudentException.StudentNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    BookDaO bookService;
    @Autowired
    StudentDaO studentService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/getAllStudent")
    public ResponseEntity getAllStudents(){
        Optional<List<Student>> listOptional = Optional.ofNullable(studentService.findAll());
        if(!listOptional.isPresent()){
            throw new StudentNotExists("No Student present");
        }
        return new ResponseEntity(listOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity getStudent(int id){
        Optional<Student> studentOptional = studentService.findById(id);
        if(!studentOptional.isPresent()){
            throw new StudentNotExists("Student with the id does not exists");
        }
        return new ResponseEntity(studentOptional.get(),HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody Student student){
        Optional<Student> studentOptional = studentService.findById(student.getMatricNo());
        if(studentOptional.isPresent()){
            throw new StudentAlreadyExistException("Student already exists !!!");
        }
        for(Book book : student.getBooks()){
            if(!bookService.findById(book.getTitle()).isPresent()){
                throw new BookNotFoundException("Book with title "+book.getTitle()+" does not exist");
            }
        }
        String password = encoder.encode(student.getPassword());
        student.setPassword(password);
        studentService.save(student);
        return new ResponseEntity(student,HttpStatus.OK);
    }
    @DeleteMapping("/removeStudent/{id}")
    public ResponseEntity removeStudent(int id){
        Optional<Student> studentOptional = studentService.findById(id);
        if(!studentOptional.isPresent()){
            throw new StudentNotExists("Student does not exists");
        }
        studentService.delete(studentOptional.get());
        return new ResponseEntity("Deleted",HttpStatus.OK);
    }
}
