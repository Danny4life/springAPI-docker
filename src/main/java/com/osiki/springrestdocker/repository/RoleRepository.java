package com.osiki.springrestdocker.repository;

import com.osiki.springrestdocker.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
