package com.retailstore.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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


}
