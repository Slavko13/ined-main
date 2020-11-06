package ru.inedtest.dbtools.services;

import ru.inedtest.dbtools.domains.books.Authors;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.dto.adminDTO.AuthorDTO;

import java.util.List;

public interface AuthorsService {

    Authors addNewAuthor(AuthorDTO authorDTO);
    Authors updateAuthors(AuthorDTO authorDTO);
    void deleteAuthor(Long id);
    List<Authors> getAllAuthors();


}
