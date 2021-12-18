package com.example.demo_project.service;

import com.example.demo_project.dto.UserDTO;
import com.example.demo_project.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<UserDTO> getUsers() {
        return userRepo.getUsers();
    }

    public UserDTO getUser(long id) {
        return userRepo.getUser(id);
    }

    public UserDTO addUser(@NonNull UserDTO userDTO) {
        return userRepo.save(userDTO);
    }

    public void deleteUser(@NonNull UserDTO userDTO) {
        userRepo.delete(userDTO);
    }

    @PostConstruct
    public void populateData() {
        if (userRepo.getUsers().size() == 0) {
            userRepo.saveAll(List.of(
                    new UserDTO("test", "test", 18),
                    new UserDTO("test1", "test1", 25),
                    new UserDTO("test2", "test2", 28),
                    new UserDTO("test5", "test5", 31)
            ));
        }
    }
}
