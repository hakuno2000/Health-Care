package com.ashina.healthcare.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "clinics")
public class clinic {
    @Id
    @Column(name = "clinicID", nullable = false)
    private Long clinicID;

    @Column(name = "clinicName", nullable = false)
    private String clinicName;

    @Column(name = "clinicEmail")
    private String clinicEmail;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "description")
    private String description;
}
