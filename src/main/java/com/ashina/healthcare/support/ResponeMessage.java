package com.ashina.healthcare.support;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponeMessage {
    private String message;

    public ResponeMessage(String message) {
        this.message = message;
    }
}
