package br.com.springboot.ibm.challenge.controller.handler;

import br.com.springboot.ibm.challenge.pattern.TechManageErrors;
import br.com.springboot.ibm.challenge.pattern.TechManagerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(TechManagerException.class)
    public ResponseEntity<Map<String, Object>> handlerValidation(TechManagerException tecEx) {
        Map<String, Object> response = new HashMap<>();
        response.put("errorCode", tecEx.getErrorCode());
        response.put("errorMessage", tecEx.getErrorMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            TechManageErrors techError = getError(error.getField());
            if (techError != null) {
                response.put("errorCode", techError.getErrorCode());
                response.put("errorMessage", techError.getErrorMessage());
                response.put("status", techError.getHttpStatus().value());
            } else {
                response.put(error.getField(), "Field validation failed.");
            }
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private TechManageErrors getError(String fieldName) {
        switch (fieldName) {
            case "fullName":
                return TechManageErrors.INVALID_NAME;
            case "email":
                return TechManageErrors.INVALID_EMAIL;
            case "phone":
                return TechManageErrors.INVALID_PHONE;
            case "birthDate":
                return TechManageErrors.INVALID_BIRTH_DATE;
            case "userType":
                return TechManageErrors.INVALID_USER_TYPE;
            default:
                return null;
        }
    }
}