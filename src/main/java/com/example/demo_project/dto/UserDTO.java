package com.example.demo_project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "demo_user")
public class UserDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    private int age;

    public UserDTO(@NonNull String firstName, @NonNull String lastName, int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}


