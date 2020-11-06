package ru.inedtest.dbtools.services;

import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.dto.adminDTO.BookDTO;
import ru.inedtest.dbtools.dto.adminDTO.BookStyleDTO;

import java.util.List;

public interface BooksService {

    List<Books> getAllBooks();
    Books getBookByID(Long id);
    void deleteBookByID(Long id);
    Books addBook(BookDTO bookDTO);
    List<Books> getAllByBookStyle(Long id);
    Books updateBook(BookDTO bookDTO);

}
