package com.osiki.springrestdocker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "acc_tbl")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;
    private boolean enabled = true;
    private boolean credentialExpired = false;
    private boolean expired = false;
    private boolean locked = false;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "AccountRole",
            joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id")
    )
    private Set<Role> roles;

}
