package ru.inedtest.dbtools.dto.adminDTO;

import lombok.Builder;
import lombok.Data;
import ru.inedtest.dbtools.domains.books.Books;

import java.util.List;

@Data
@Builder
public class BookStyleDTO {

    private Long id;
    private String name;
    private List<Books> books;

}
