package org.booksta.domain.common;

import lombok.Data;

@Data
public class BookstaException extends RuntimeException{
    private String code;
    private String message;
    private Throwable cause;

    public BookstaException(String message) {
        this.message = message;
    }
    public BookstaException(String code, String message) {
        this.message = message;
        this.code = code;
    }
    public BookstaException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
}
