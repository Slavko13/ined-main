package ru.inedtest.booksapi.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.dto.adminDTO.BookDTO;
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
   @PostMapping("/addBook")
   @CrossOrigin
   public ResponseEntity<Books> getAllBooks(@RequestBody BookDTO bookDTO) {
           return new ResponseEntity<>(booksService.addBook(bookDTO), HttpStatus.OK);
   }


}
