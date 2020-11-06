package ru.inedtest.dbtools.domains.books;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.inedtest.dbtools.json.views.AuthorsView;
import ru.inedtest.dbtools.json.views.BookStyleView;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonView(AuthorsView.MainAuthorsView.class)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    @JsonView(AuthorsView.MainAuthorsView.class)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @JsonView(AuthorsView.MainAuthorsView.class)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    @JsonBackReference
    private List<Books> books;




}
