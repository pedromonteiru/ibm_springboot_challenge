package br.com.springboot.ibm.challenge.pattern;

import org.springframework.http.HttpStatus;

public enum TechManageErrors {

    ;

    private int errorCode;
    private String errorMessage;
    private int httpStatusCode;
    TechManageErrors(int errorCode, String errorMessage, int httpStatusCode){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatusCode = httpStatusCode;
    }
}
