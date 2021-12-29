package com.retailstore.product.exception;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

public class ProductException {

    private String message;
    private HttpStatus status;
    private ZonedDateTime zonedDateTime;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ProductException{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }

    public ProductException(String message, HttpStatus status, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.status = status;
        this.zonedDateTime = zonedDateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }
}
