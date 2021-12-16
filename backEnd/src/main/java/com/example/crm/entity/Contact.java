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

    // ToString method
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", team='" + team + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getContactid() {
        return contactid;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Integer getUserId() {
        return userId;
    }

    public String toCsv(){
        String csv = this.getName() + ',' + this.getPhone() + ',' + this.getEmail() + ','
                + ',' + this.getTeam()+ ',' + this.getStatus()+ ','+this.getDescription();
        return csv;
    }
}
