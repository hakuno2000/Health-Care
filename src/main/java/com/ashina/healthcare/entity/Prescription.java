package com.ashina.healthcare.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    /*@OneToOne
    @JoinColumn(name = "checkUpForm", referencedColumnName = "formID")
    private CheckUpForm checkUpForm;*/

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

//    @Transient
    private Date checkUpDate;

//    @Transient
    private String description;

//    @Transient
    private Long clinic;
}
