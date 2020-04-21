package com.ashina.healthcare.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "patientID", nullable = false)
    private Long patientID;

    @Column(name = "medicalHistory")
    private String medicalHistory;

    @Column(name = "symptom")
    private String symptom;
}
