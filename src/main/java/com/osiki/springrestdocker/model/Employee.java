package com.osiki.springrestdocker.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
}
