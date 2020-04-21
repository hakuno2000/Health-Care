package com.ashina.healthcare.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userID", nullable = false)
    private Long userID;

    @Column(name = "email")
    private String email;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "idCardSerial")
    private String idCardSerial;
}
