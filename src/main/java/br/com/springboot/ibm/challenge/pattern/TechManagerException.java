package br.com.springboot.ibm.challenge.pattern;

import lombok.Getter;

@Getter
public class TechManagerException extends RuntimeException {

    private TechManageErrors error;

    public TechManagerException(TechManageErrors error) {
        super(error.getErrorMessage());
        this.error = error;
    }

    public int getErrorCode() {
        return error.getErrorCode();
    }

    public String getErrorMessage() {
        return error.getErrorMessage(); // Retorna a mensagem de erro associada
    }
}
