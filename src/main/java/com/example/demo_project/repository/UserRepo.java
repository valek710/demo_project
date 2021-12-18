package com.example.demo_project.repository;

import com.example.demo_project.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Long> {
    @Query(value = "SELECT * FROM demo_user", nativeQuery = true)
    List<UserDTO> getUsers();

    @Query(value = "SELECT * FROM demo_user WHERE id = :id", nativeQuery = true)
    UserDTO getUser(@Param("id") long id);
}
