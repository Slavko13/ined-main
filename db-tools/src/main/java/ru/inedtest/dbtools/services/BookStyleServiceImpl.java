package ru.inedtest.dbtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inedtest.dbtools.domains.books.BookStyle;
import ru.inedtest.dbtools.dto.adminDTO.BookStyleDTO;
import ru.inedtest.dbtools.repositories.BooksStyleRepo;

import java.util.List;

@Service
public class BookStyleServiceImpl implements BookStyleService {

    private final BooksStyleRepo booksStyleRepo;


    @Autowired
    public BookStyleServiceImpl(BooksStyleRepo booksStyleRepo) {
        this.booksStyleRepo = booksStyleRepo;
    }


    @Override
    @Transactional
    public void addStyle(BookStyleDTO bookStyleDTO) {

    }

    @Override
    @Transactional
    public void deleteStyle(Long id) {

    }

    @Override
    @Transactional
    public BookStyle updateBookStyle(BookStyleDTO bookStyleDTO) {
        return null;
    }

    @Override
    @Transactional
    public List<BookStyle> getAllBooksStyle() {
        return (List<BookStyle>) booksStyleRepo.findAll();
    }
}
