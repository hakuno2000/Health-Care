package com.ashina.healthcare.support;

import com.ashina.healthcare.entity.CheckUpForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Form {
    private List<CheckUpForm> forms;
}