package ru.inedtest.dbtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inedtest.base.exceptions.NotFoundException;
import ru.inedtest.dbtools.domains.books.Authors;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.dto.adminDTO.AuthorDTO;
import ru.inedtest.dbtools.repositories.AuthorsRepo;

import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepo authorsRepo;


    @Autowired
    public AuthorsServiceImpl(AuthorsRepo authorsRepo) {
        this.authorsRepo = authorsRepo;
    }


    @Override
    @Transactional
    public Authors addNewAuthor(AuthorDTO authorDTO) {
        Authors  authors = Authors.builder()
                .firstName(authorDTO.getFirstName())
                .lastName(authorDTO.getLastName())
                .build();

        return authorsRepo.save(authors);
    }

    @Override
    @Transactional
    public Authors updateAuthors(AuthorDTO authorDTO) {
        Authors authorsFromDB = authorsRepo.findById(authorDTO.getId()).orElseThrow(() -> new NotFoundException("{AuthorsService.UpdateAuthor.NotFound}"));
        authorsFromDB.setFirstName(authorDTO.getFirstName());
        authorsFromDB.setLastName(authorDTO.getLastName());
        return authorsRepo.save(authorsFromDB);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        authorsRepo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Authors> getAllAuthors() {
        return (List<Authors>) authorsRepo.findAll();
    }
}
