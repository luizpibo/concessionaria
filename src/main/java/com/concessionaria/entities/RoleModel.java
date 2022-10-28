package com.concessionaria.entities;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Role")
public class RoleModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserModel> users;

    @ManyToMany
    @JoinTable(
        name = "roles_privileges",
        joinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "privilege_id", referencedColumnName = "id"))
    private List<PrivilegeModel> privilegeModels;
}
