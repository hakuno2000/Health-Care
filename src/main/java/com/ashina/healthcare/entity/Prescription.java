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
@Table(name = "prescription")
public class Prescription {
    @Id
    @Column(name = "prescriptionID", nullable = false)
    private Long presciptionID;

    @Column(name = "checkUpForm", nullable = false)
    private Long checkUpForm;

    @Column(name = "doctor", nullable = false)
    private Long doctor;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "dose")
    private String dose;

    @Column(name = "reExaminationTime")
    private Date reExaminationTime;
}
