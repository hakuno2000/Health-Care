package com.ashina.healthcare.support;

import com.ashina.healthcare.entity.Prescription;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResponsePrescription {
    List<Prescription> prescription;
}
