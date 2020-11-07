package ru.inedtest.dbtools.domains.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ru.inedtest.dbtools.domains.books.Comments;
import ru.inedtest.dbtools.json.views.UserView;

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
    @JsonView(UserView.UserMainInfo.class)
    private UUID id;

    @Column(name = "EMAIL", nullable = false)
    @JsonView(UserView.UserMainInfo.class)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @JsonView(UserView.UserFullInfoWithCreds.class)
    private String password;

    @Column(name = "FIRST_NAME", nullable = false)
    @JsonView(UserView.UserMainInfo.class)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @JsonView(UserView.UserMainInfo.class)
    private String lastName;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Comments> commentsList;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name="role_id")
    private Role role;

}
