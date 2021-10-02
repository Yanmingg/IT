package com.example.crm.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactid;
    private String phone;
    private String email;
    private String team;
    private String name;
    private String status;
    private String description;
    private Integer userId;
}
