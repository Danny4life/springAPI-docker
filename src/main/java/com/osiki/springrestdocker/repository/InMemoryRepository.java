package com.osiki.springrestdocker.repository;

import com.osiki.springrestdocker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface InMemoryRepository extends JpaRepository<Employee, Long> {

}
