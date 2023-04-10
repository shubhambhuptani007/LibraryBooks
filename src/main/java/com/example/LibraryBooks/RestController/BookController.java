package com.example.LibraryBooks.RestController;

import com.example.LibraryBooks.DaO.BookDaO;
import com.example.LibraryBooks.DaO.LibrarianDaO;
import com.example.LibraryBooks.DaO.LibraryDaO;
import com.example.LibraryBooks.DaO.StudentDaO;
import com.example.LibraryBooks.Entity.*;
import com.example.LibraryBooks.Exceptions.BookExceptions.BookAlreadyExistException;
import com.example.LibraryBooks.Exceptions.BookExceptions.BookNotFoundException;
import com.example.LibraryBooks.Exceptions.LibrarianException.NoSuchLibrarianFound;
import com.example.LibraryBooks.Exceptions.LibraryException.NoSuchLibraryPresent;
import com.example.LibraryBooks.Exceptions.StudentException.NoSuchStudentFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookDaO bookService;
    @Autowired
    LibrarianDaO librarianService;
    @Autowired
    StudentDaO studentService;
    @Autowired
    LibraryDaO libraryDaO;
    @GetMapping("/getBook/{bookTitle}")
    public ResponseEntity getBook(@PathVariable("bookTitle") String bookTitle){
        Optional<Book> bookOptional = bookService.findById(bookTitle);
        if(bookOptional.isPresent()){
            return new ResponseEntity(bookOptional.get(), HttpStatus.OK);
        }
        throw new BookNotFoundException("Book Not Found");
    }

    @GetMapping("/allBooks")
    public ResponseEntity getAllBooks(){
        Optional<List<Book>> optionalBookList = Optional.ofNullable(bookService.findAll());
        if(optionalBookList.isPresent()){
            return new ResponseEntity(optionalBookList.get(), HttpStatus.OK);
        }
        throw new BookNotFoundException("Book Not Found");
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        Optional bookPresent = bookService.findById(book.getTitle());
        if(bookPresent.isPresent()){
            throw new BookAlreadyExistException("Book with id Already Exist");
        }
        Optional<Person> personOptional = Optional.of(book.getOnLoanTo());
        if(personOptional.isPresent()){
            Optional<Librarian> librarianOptional = librarianService.findById(personOptional.get().getName());
            if(!librarianOptional.isPresent()){
                Optional<Student> studentOptional = Optional.ofNullable(studentService.findByName(personOptional.get().getName()));
                if(!studentOptional.isPresent()){
                    throw new NoSuchStudentFoundException("No such Student and Librarian exist");
                }
            }
        }
        Optional<Library> libraryOptional = Optional.ofNullable(book.getOwnedBy());
        if(libraryOptional.isPresent()){
            Optional<Library> libraryPresent = Optional.ofNullable(librarianService.findByName(book.getOwnedBy().getName()));
            if(!libraryPresent.isPresent()){
                throw new NoSuchLibraryPresent("No such library exist");
            }
        }
        bookService.save(book);
        return new ResponseEntity("Added",HttpStatus.OK);
    }

    @DeleteMapping("/removeBook/{bookTitle}")
    public ResponseEntity removeBook(@PathVariable("bookTitle") String bookTitle){
        Optional<Book> book = bookService.findById(bookTitle);
        if(!book.isPresent()){
            throw new BookNotFoundException("Book Not Found");
        }
        bookService.delete(book.get());
        return new ResponseEntity("Deleted",HttpStatus.OK);
    }
}
