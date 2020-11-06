package ru.inedtest.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.inedtest.dbtools.domains.books.Comments;

public interface CommentRepo extends CrudRepository<Comments, Long> {



}
