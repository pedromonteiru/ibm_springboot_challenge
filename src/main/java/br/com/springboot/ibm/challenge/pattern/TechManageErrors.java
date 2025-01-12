package br.com.springboot.ibm.challenge.pattern;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum TechManageErrors {
    INVALID_NAME(100, "Invalid Username.", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(110,"Invalid Email.", HttpStatus.BAD_REQUEST),
    INVALID_PHONE(120, "Invalid Phone Number", HttpStatus.BAD_REQUEST),
    INVALID_BIRTH_DATE(130, "Invalid birth date", HttpStatus.BAD_REQUEST),
    INVALID_USER_TYPE(140,"Invalid User Type.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(300,"User Not Registered.", HttpStatus.NOT_FOUND);

    private int errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    TechManageErrors(int errorCode, String errorMessage, HttpStatus httpStatus){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

}