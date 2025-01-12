package br.com.springboot.ibm.challenge.pattern;

import lombok.Getter;

public enum UserType {
    ADMIN(10, "admin"),
    EDITOR(20, "editor"),
    VIEWER(30, "viewer");

    @Getter
    private final int code;
    @Getter
    private final String userType;

    private UserType(int code, String userType) {
        this.userType = userType;
        this.code = code;
    }

}
