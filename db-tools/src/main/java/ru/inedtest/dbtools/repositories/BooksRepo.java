package ru.inedtest.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.inedtest.dbtools.domains.books.BookStyle;
import ru.inedtest.dbtools.domains.books.Books;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BooksRepo extends CrudRepository<Books, Long> {



}
