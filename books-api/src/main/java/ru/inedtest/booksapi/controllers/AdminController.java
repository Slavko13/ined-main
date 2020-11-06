package ru.inedtest.booksapi.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inedtest.dbtools.domains.books.Authors;
import ru.inedtest.dbtools.domains.books.BookStyle;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.dto.adminDTO.AuthorDTO;
import ru.inedtest.dbtools.dto.adminDTO.BookDTO;
import ru.inedtest.dbtools.dto.adminDTO.BookStyleDTO;
import ru.inedtest.dbtools.services.AuthorsService;
import ru.inedtest.dbtools.services.BookStyleService;
import ru.inedtest.dbtools.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class AdminController {


   private final AuthorsService authorsService;
   private final BooksService booksService;
   private final BookStyleService bookStyleService;


   public AdminController(AuthorsService authorsService, BooksService booksService, BookStyleService bookStyleService) {
           this.authorsService = authorsService;
           this.booksService = booksService;
           this.bookStyleService = bookStyleService;
   }


   //Book CRUD
    @PostMapping("/addBook")
    @CrossOrigin
    public ResponseEntity<Books> addBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(booksService.addBook(bookDTO), HttpStatus.OK);
    }

   @PostMapping("/getAllBooks")
   @CrossOrigin
   public ResponseEntity<List<Books>> getAllBooks() {
           return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
   }

    @PostMapping("/updateBook")
    @CrossOrigin
    public ResponseEntity<Books> updateBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(booksService.updateBook(bookDTO), HttpStatus.OK);
    }

    @PostMapping("/deleteBook")
    @CrossOrigin
    public ResponseEntity deleteBook(@RequestBody BookDTO bookDTO) {
       booksService.deleteBookByID(bookDTO.getId());
       return new ResponseEntity<>(HttpStatus.OK);
    }

    //Authors CRUD
    @PostMapping("/getAllAuthors")
    @CrossOrigin
    public ResponseEntity<List<Authors>> getAllAuthors() {
        return new ResponseEntity<>(authorsService.getAllAuthors(), HttpStatus.OK);
    }

    @PostMapping("/addAuthor")
    @CrossOrigin
    public ResponseEntity<Authors> addAuthor(@RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorsService.addNewAuthor(authorDTO), HttpStatus.OK);
    }

    @PostMapping("/updateAuthor")
    @CrossOrigin
    public ResponseEntity<Authors> updateAuthor(@RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorsService.updateAuthors(authorDTO), HttpStatus.OK);
    }

    @PostMapping("/deleteAuthor")
    @CrossOrigin
    public ResponseEntity deleteAuthor(@RequestBody AuthorDTO authorDTO) {
       authorsService.deleteAuthor(authorDTO.getId());
       return new ResponseEntity<>(HttpStatus.OK);
    }

    //BookStyle(Жанры) CRUD
    @PostMapping("/updateBookStyle")
    @CrossOrigin
    public ResponseEntity<BookStyle> updateBookStyle(@RequestBody BookStyleDTO bookStyleDTO) {
        return new ResponseEntity<>(bookStyleService.updateBookStyle(bookStyleDTO), HttpStatus.OK);
    }

    @PostMapping("/addBookStyle")
    @CrossOrigin
    public ResponseEntity<BookStyle> addBookStyle(@RequestBody BookStyleDTO bookStyleDTO) {
        return new ResponseEntity<>(bookStyleService.addStyle(bookStyleDTO), HttpStatus.OK);
    }

    @PostMapping("/getAllBookStyles")
    @CrossOrigin
    public ResponseEntity<List<BookStyle>> getAllStyles() {
        return new ResponseEntity<>(bookStyleService.getAllBooksStyle(), HttpStatus.OK);
    }

    @PostMapping("/deleteBookStyle")
    @CrossOrigin
    public ResponseEntity deleteBookStyle(@RequestBody BookStyleDTO bookStyleDTO) {
       bookStyleService.deleteStyle(bookStyleDTO.getId());
       return new ResponseEntity<>( HttpStatus.OK);
    }


}
