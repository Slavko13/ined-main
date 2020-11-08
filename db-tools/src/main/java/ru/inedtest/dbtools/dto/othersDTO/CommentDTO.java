package ru.inedtest.dbtools.dto.othersDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private Long id;
    private String commentText;
    private String email;
    private Long bookID;

}
