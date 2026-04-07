package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNum;
    private String address;
    private String pic;
    @Column(length=10000)
    private String description;
    private boolean favourite = false;
    private String websiteLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="contact", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    private List<SocialLink> socialLinks = new ArrayList<>();
}
