package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetail(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getLocalDateTime() {
        return timestamp;
    }

    public void setLocalDateTime(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return details;
    }

    public void setDetail(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
