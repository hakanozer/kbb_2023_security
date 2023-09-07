package com.works.repositories;

import com.works.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    Optional<Employe> findByUsernameEquals(String username);

}