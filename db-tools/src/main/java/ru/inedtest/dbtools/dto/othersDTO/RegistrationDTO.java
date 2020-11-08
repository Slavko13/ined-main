package ru.inedtest.dbtools.dto.othersDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Long roleID;


}
