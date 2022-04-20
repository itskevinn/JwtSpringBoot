package com.kevcode.jwtpractice.application.shared;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response<T> {

    private T body;
    private String message;
    private String exceptionString;
    private HttpStatus httpStatusCode;

    public Response() {

    }

    public Response(T body, HttpStatus status, String message) {
        this.message = message;
        this.body = body;
        this.httpStatusCode = status;
    }

    public Response(T body, HttpStatus status, String message, Exception exception) {
        this.message = message;
        this.body = body;
        this.httpStatusCode = status;
        if (exception.getCause() != null) {
            this.exceptionString = exceptionToString(exception);
        }
    }

    public String exceptionToString(Exception exception) {
        return "An exception occurred in " + exception.getClass().getSimpleName() +
                ", in the line " + exception.getCause().getStackTrace()[0].getLineNumber() +
                ": " + exception.getMessage();
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionString() {
        return exceptionString;
    }

    public void setExceptionString(String exceptionString) {
        this.exceptionString = exceptionString;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

}
