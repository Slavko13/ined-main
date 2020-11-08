package ru.inedtest.booksapi.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inedtest.dbtools.domains.books.Comments;
import ru.inedtest.dbtools.dto.othersDTO.CommentDTO;
import ru.inedtest.dbtools.dto.othersDTO.RegistrationDTO;
import ru.inedtest.dbtools.json.views.CommentViews;
import ru.inedtest.dbtools.services.CommentService;
import ru.inedtest.oauthservice.services.RegistrationService;

@RestController
@RequestMapping("/user/api")
public class UserController {

    private final RegistrationService registrationService;
    private final CommentService commentService;

    @Autowired
    public UserController(RegistrationService registrationService, CommentService commentService) {
        this.registrationService = registrationService;
        this.commentService = commentService;
    }


    @PostMapping("/newUser")
    @CrossOrigin
    public ResponseEntity registrateUser(@RequestBody RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("comment/newComment")
    @CrossOrigin
    @JsonView(CommentViews.MainCommentsView.class)
    public ResponseEntity<Comments> addedComment(@RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.addComment(commentDTO),HttpStatus.OK);
    }

    @PostMapping("comment/deleteComment")
    @CrossOrigin
    public ResponseEntity deleteComment(@RequestBody CommentDTO commentDTO) {
        commentService.deleteComment(commentDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
