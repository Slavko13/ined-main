package ru.inedtest.dbtools.domains.books;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import ru.inedtest.dbtools.json.views.BookStyleView;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
@Builder
public class BookStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(BookStyleView.MainBooksStyleView.class)
    private Long id;
    @JsonView(BookStyleView.MainBooksStyleView.class)
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "bookStyle", fetch = FetchType.EAGER)
    private List<Books> books;




}
