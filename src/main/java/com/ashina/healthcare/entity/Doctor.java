package com.ashina.healthcare.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "doctorID", nullable = false)
    private Long doctorID;

    @Column(name = "clinic", nullable = false)
    private Long clinic;

    @Column(name = "degree")
    private String degree;
}
