package com.busify.bus.validate;

public class Validator {

    public boolean validateName(String name) {
        return name.matches("[a-zA-Z]+") && name.length() >= 3;
    }

}
