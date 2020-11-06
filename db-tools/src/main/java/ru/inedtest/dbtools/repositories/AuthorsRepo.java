package ru.inedtest.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.inedtest.dbtools.domains.books.Authors;

public interface AuthorsRepo extends CrudRepository<Authors, Long> {

}
