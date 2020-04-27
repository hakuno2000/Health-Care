package com.ashina.healthcare.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
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
