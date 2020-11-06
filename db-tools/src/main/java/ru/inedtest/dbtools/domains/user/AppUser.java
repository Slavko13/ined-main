package ru.inedtest.dbtools.domains.user;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ru.inedtest.dbtools.domains.books.Comments;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "AppUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AppUser {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid2")
    private UUID id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Comments> commentsList;

}
