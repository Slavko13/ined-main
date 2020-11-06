package ru.inedtest.dbtools.domains.books;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
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
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CommentViews.MainCommentsView.class)
    private Long id;
    @JsonView(CommentViews.MainCommentsView.class)
    private String commentText;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    @JsonView(CommentViews.MainCommentsView.class)
    private AppUser appUser;


    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Books books;


}
