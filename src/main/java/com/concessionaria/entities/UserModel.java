package com.concessionaria.entities;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "User")
public class UserModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true, length = 50, nullable = false)
    @NonNull
    private String username;
    @Column(length = 50, nullable = false)
    @NonNull
    private String password;
    @Column(unique = true, length = 50, nullable = false)
    @NonNull
    private String email;

    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))
    private List<RoleModel> roles;
}
