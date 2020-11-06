package ru.inedtest.dbtools.services;

import ru.inedtest.dbtools.domains.books.Comments;
import ru.inedtest.dbtools.dto.othersDTO.CommentDTO;

public interface CommentService {

    Comments addComment(CommentDTO commentDTO);
    void deleteComment(Long id);

}
