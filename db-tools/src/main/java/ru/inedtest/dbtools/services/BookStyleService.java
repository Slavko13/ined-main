package ru.inedtest.dbtools.services;

import ru.inedtest.dbtools.domains.books.BookStyle;
import ru.inedtest.dbtools.dto.adminDTO.BookStyleDTO;

import java.util.List;

public interface BookStyleService {

    BookStyle addStyle(BookStyleDTO bookStyleDTO);
    void deleteStyle(Long id);
    BookStyle updateBookStyle(BookStyleDTO bookStyleDTO);
    List<BookStyle> getAllBooksStyle();


}
