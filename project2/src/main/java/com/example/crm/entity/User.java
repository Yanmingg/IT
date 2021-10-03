package com.example.crm.entity;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String address;
    private String name;
    private String password;
}
