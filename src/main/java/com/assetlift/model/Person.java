package com.assetlift.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "person")
    private String person;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;

    @Column(name = "department")
    private String department;

    @Column(name = "supervisor")
    private String supervisor;
}
