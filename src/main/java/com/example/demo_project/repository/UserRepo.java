package com.example.demo_project.repository;

import com.example.demo_project.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Long> {
}
