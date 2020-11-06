package ru.inedtest.dbtools.domains.books;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ru.inedtest.dbtools.json.views.BooksView;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"authors", "bookStyle"})
public class Books {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonView({BooksView.MainPageBooksView.class})
    private Long id;

    @Column(name = "NAME", nullable = false)
    @JsonView({BooksView.MainPageBooksView.class})
    private String name;

    @Column(name = "DESCRIPTION")
    @JsonView({BooksView.MainPageBooksView.class})
    private String description;

    @Column(name = "PICTURE")
    @JsonView({BooksView.MainPageBooksView.class})
    private String picture;


    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bookStyle_id")
    @JsonView({BooksView.SinglePageBookView.class})
    private BookStyle bookStyle;


    @ManyToMany
    @JoinTable(name = "BOOKS_AUTHORS",
            joinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    )
    @JsonView({BooksView.SinglePageBookView.class})
    private List<Authors> authors;

}
