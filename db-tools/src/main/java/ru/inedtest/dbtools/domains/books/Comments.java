package ru.inedtest.dbtools.domains.books;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.inedtest.dbtools.domains.user.AppUser;
import ru.inedtest.dbtools.json.views.CommentViews;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CommentViews.MainCommentsView.class)
    private Long id;
    @JsonView(CommentViews.MainCommentsView.class)
    private String commentText;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    @JsonView(CommentViews.MainCommentsView.class)
    private AppUser appUser;


    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Books books;


}
