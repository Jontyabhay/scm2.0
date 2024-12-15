package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
    
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    @Column(length = 10000)
    private String description;
    private String picture;
    private boolean favorite=false;
    private String websiteLink;
    private String linkedInLink;
    @ManyToOne
    private User user;
    //private List<String> socialLinks=new ArrayList<>();

}
