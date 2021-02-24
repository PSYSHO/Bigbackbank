package com.example.backbank.repositories;

import com.example.backbank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User,Long> {
}
