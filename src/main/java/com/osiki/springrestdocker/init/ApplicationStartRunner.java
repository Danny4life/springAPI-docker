package com.osiki.springrestdocker.init;

import com.osiki.springrestdocker.model.Role;
import com.osiki.springrestdocker.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role(1L, "001", "ROLE_USER");

        Role roleAdmin = new Role(2L, "002", "ROLE_ADMIN");

        roleRepository.saveAll(asList(roleUser, roleAdmin));


    }
}
