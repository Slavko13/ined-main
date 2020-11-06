package ru.inedtest.dbtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inedtest.base.exceptions.NotFoundException;
import ru.inedtest.dbtools.domains.books.BookStyle;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.dto.adminDTO.BookDTO;
import ru.inedtest.dbtools.dto.adminDTO.BookStyleDTO;
import ru.inedtest.dbtools.repositories.BooksRepo;
import ru.inedtest.dbtools.repositories.BooksStyleRepo;


import java.awt.print.Book;
import java.util.List;


@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepo booksRepo;
    private final BooksStyleRepo booksStyleRepo;


    @Autowired
    public BooksServiceImpl(BooksRepo booksRepo, BooksStyleRepo booksStyleRepo) {
        this.booksRepo = booksRepo;
        this.booksStyleRepo = booksStyleRepo;
    }

    @Override
    @Transactional
    public List<Books> getAllBooks() {
        return  (List<Books>) booksRepo.findAll();
    }

    @Override
    @Transactional
    public Books getBookByID(Long id) {
        return booksRepo.findById(id).orElseThrow(()-> new NotFoundException("{BooksServiceImpl.findByID.NotFound}"));
    }

    @Override
    @Transactional
    public void deleteBookByID(Long id) {
        booksRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Books addBook(BookDTO bookDTO) {
        Books book = Books.builder()
                .name(bookDTO.getName())
                .authors(bookDTO.getAuthors())
                .description(bookDTO.getDescription())
                .bookStyle(bookDTO.getBookStyle())
                .build();

        booksRepo.save(book);
        return book;
    }

    @Override
    @Transactional
    public List<Books> getAllByBookStyle(Long id) {
        BookStyle bookStyle = booksStyleRepo.findById(id).orElseThrow(() -> new NotFoundException("{BookService.UpdateBook.NotFound}"));;
        return bookStyle.getBooks();
    }

    @Override
    @Transactional
    public Books updateBook(BookDTO bookDTO) {
        Books booksFromDB = booksRepo.findById(bookDTO.getId()).get();
        booksFromDB.setAuthors(bookDTO.getAuthors());
        booksFromDB.setBookStyle(bookDTO.getBookStyle());
        booksFromDB.setDescription(bookDTO.getDescription());
        booksFromDB.setName(bookDTO.getName());
        return booksRepo.save(booksFromDB);

    }

}
