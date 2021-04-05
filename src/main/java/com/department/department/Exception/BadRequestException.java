package com.department.department.Exception;

public class BadRequestException extends Exception{

    private String errorDescription;
    private int errorCode;
    private String errorMessage;



    public BadRequestException(String message){
        this.errorMessage=message;
        this.errorCode=404;
        this.errorDescription=message;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BadRequestException{" +
                "errorDescription='" + errorDescription + '\'' +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
