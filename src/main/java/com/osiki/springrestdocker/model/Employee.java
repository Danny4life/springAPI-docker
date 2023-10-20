package com.osiki.springrestdocker.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "emp_tbl")
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
}
