package com.cart.cartService.exceptions;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartExceptions {

	private String message;
	private HttpStatus status;
	private ZonedDateTime zonedDateTime;

}