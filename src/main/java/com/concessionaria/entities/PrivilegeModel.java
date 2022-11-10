package com.concessionaria.entities;

import com.concessionaria.entities.abstracts.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PrivilegeModel extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<RoleModel> roles;
}
