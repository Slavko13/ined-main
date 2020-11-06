package ru.inedtest.dbtools.dto.adminDTO;


import lombok.Builder;
import lombok.Data;
import ru.inedtest.dbtools.domains.books.Authors;
import ru.inedtest.dbtools.domains.books.BookStyle;

import java.util.List;

@Data
@Builder
public class BookDTO {

    private Long id;
    private String name;
    private String description;
    private List<Authors> authors;
    private BookStyle bookStyle;

}
