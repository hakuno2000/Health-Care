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
@Table(name = "checkupform")
public class CheckUpForm {
    @Id
    @Column(name = "formID", nullable = false)
    private Long formID;

    @Column(name = "patient", nullable = false)
    private Long patient;

    @Column(name = "clinic", nullable = false)
    private Long clinic;

    @Column(name = "checkUpDate")
    private Date checkUpDate;

    @Column(name = "description")
    private String description;

    @Column(name = "resolved")
    private boolean resolved;
}
