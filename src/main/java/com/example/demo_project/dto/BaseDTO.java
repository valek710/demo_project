package com.example.demo_project.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
@EqualsAndHashCode
@Getter
public class BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "bigint")
    private Long id;
}
