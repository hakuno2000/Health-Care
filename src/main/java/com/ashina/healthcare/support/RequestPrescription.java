package com.ashina.healthcare.support;

import com.ashina.healthcare.entity.Prescription;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestPrescription extends Prescription {
    private String form;
}
