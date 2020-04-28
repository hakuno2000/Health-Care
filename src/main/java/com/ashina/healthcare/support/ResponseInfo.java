package com.ashina.healthcare.support;

import com.ashina.healthcare.entity.CheckUpForm;
import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResponseInfo {
    private String token = "tempToken";
    private String role = "patient";
}
