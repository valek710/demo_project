package com.example.demo_project.service;

import com.example.demo_project.dto.UserDTO;
import com.example.demo_project.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<UserDTO> getUsers() {
        return userRepo.findAll();
    }

    public UserDTO getUser(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public UserDTO addUser(@NonNull UserDTO userDTO) {
        return userRepo.save(userDTO);
    }

    public void deleteUser(@NonNull UserDTO userDTO) {
        userRepo.delete(userDTO);
    }

    @PostConstruct
    public void populateData() {
        if (userRepo.findAll().size() == 0) {
            var list = new ArrayList<UserDTO>();
            for (int i = 0; i < 1000; i++)
                list.add(new UserDTO("testName" + i, "testLastName" + i, 18));

            userRepo.saveAll(list);
        }
    }
}
