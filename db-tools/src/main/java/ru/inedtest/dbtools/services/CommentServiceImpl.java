package ru.inedtest.dbtools.services;

import org.springframework.stereotype.Service;
import ru.inedtest.dbtools.domains.books.Books;
import ru.inedtest.dbtools.domains.books.Comments;
import ru.inedtest.dbtools.domains.user.AppUser;
import ru.inedtest.dbtools.dto.othersDTO.CommentDTO;
import ru.inedtest.dbtools.repositories.CommentRepo;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final UserService userService;
    private final BooksService booksService;

    public CommentServiceImpl(CommentRepo commentRepo, UserService userService, BooksService booksService) {
        this.commentRepo = commentRepo;
        this.userService = userService;
        this.booksService = booksService;
    }


    @Override
    public Comments addComment(CommentDTO commentDTO) {
        AppUser userAddedThisComment = userService.findByEmail(commentDTO.getUserName());
        Books bookWithThisComment = booksService.getBookByID(commentDTO.getBookID());

        Comments comment = Comments.builder()
                .appUser(userAddedThisComment)
                .commentText(commentDTO.getCommentText())
                .books(bookWithThisComment)
                .build();

        return commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Long id) {

    }
}
