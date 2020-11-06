package ru.inedtest.booksapi.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inedtest.booksapi.dto.FindByIdDTO;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.json.views.BooksView;
import ru.inedtest.dbtools.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/main/api")
public class MainPageController {

    private final BooksService booksService;


    @Autowired
    public MainPageController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping("/books")
    @CrossOrigin
    @JsonView({BooksView.MainPageBooksView.class})
    public ResponseEntity<List<Books>> getAllBooks() {
        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/bookByID")
    @CrossOrigin
    @JsonView({BooksView.SinglePageBookView.class})
    public ResponseEntity<Books> getAllBookById(@RequestBody FindByIdDTO findByIdDTO) {
        return new ResponseEntity<>(booksService.getBookByID(findByIdDTO.getId()), HttpStatus.OK);
    }

    @PostMapping("/booksByStyle")
    @CrossOrigin
    public ResponseEntity<List<Books>> getAllBooksByStyle(@RequestBody FindByIdDTO findByIdDTO) {
        return new ResponseEntity<>(booksService.getAllByBookStyle(findByIdDTO.getId()), HttpStatus.OK);
    }

}
