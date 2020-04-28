package com.ashina.healthcare.support;

import com.ashina.healthcare.entity.Patient;
import com.ashina.healthcare.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserResult {
    private List<User> result;
}
