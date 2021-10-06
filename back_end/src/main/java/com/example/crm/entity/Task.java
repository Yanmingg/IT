package com.example.crm.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DateTimeException;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskid;
    private Integer contactid;
    private String name;
    private String description;
    private Boolean completed;
    private Integer userId;
    private String time;
}
