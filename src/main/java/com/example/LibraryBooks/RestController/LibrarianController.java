package com.example.LibraryBooks.RestController;

import com.example.LibraryBooks.DaO.BookDaO;
import com.example.LibraryBooks.DaO.LibrarianDaO;
import com.example.LibraryBooks.DaO.StudentDaO;
import com.example.LibraryBooks.Entity.Book;
import com.example.LibraryBooks.Entity.Librarian;
import com.example.LibraryBooks.Exceptions.BookExceptions.BookNotFoundException;
import com.example.LibraryBooks.Exceptions.LibrarianException.LibrarianAlreadyExistsException;
import com.example.LibraryBooks.Exceptions.LibrarianException.LibrarianNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    @Autowired
    BookDaO bookService;
    @Autowired
    StudentDaO studentService;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    LibrarianDaO librarianService;
    @GetMapping("getLibrarian/{name}")
    public ResponseEntity getLibrarian(@PathVariable("name") String name){
        Optional<Librarian> librarianOptional = librarianService.findById(name);
        if(!librarianOptional.isPresent()){
            throw new LibrarianNotExistsException("Librarian does not exist");
        }
        return new ResponseEntity(librarianOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/addLibrarian")
    public ResponseEntity addLibrarian(@RequestBody Librarian librarian){
        Optional<Librarian> librarianOptional = librarianService.findById(librarian.getName());
        if(librarianOptional.isPresent()){
            throw new LibrarianAlreadyExistsException("Librarian Already Exists !!!");
        }
        for(Book book : librarian.getLoans()){
            if(!bookService.findById(book.getTitle()).isPresent()){
                throw new BookNotFoundException("Book with title "+book.getTitle()+" does not exist");
            }
        }
        String password = encoder.encode(librarian.getPassword());
        librarian.setPassword(password);
        librarianService.save(librarian);
        return new ResponseEntity(librarian,HttpStatus.OK);
    }
    @DeleteMapping("/removeLibrarian/{name}")
    public ResponseEntity removeBook(@PathVariable("name") String name){
        Optional<Librarian> librarian = librarianService.findById(name);
        if(!librarian.isPresent()){
            throw new LibrarianNotExistsException("Librarian Not Found");
        }
        librarianService.delete(librarian.get());
        return new ResponseEntity("Deleted",HttpStatus.OK);
    }
}
