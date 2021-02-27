package com.example.backbank.repositories;

import com.example.backbank.entity.Role;
import com.example.backbank.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleEnum name);
    Role findById(long id);
    List<Role> findAll();
}
