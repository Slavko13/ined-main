package ru.inedtest.dbtools.dto.adminDTO;

import lombok.Builder;
import lombok.Data;
import ru.inedtest.dbtools.domains.books.Books;

import java.util.List;

@Data
@Builder
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Books> booksList;

}
