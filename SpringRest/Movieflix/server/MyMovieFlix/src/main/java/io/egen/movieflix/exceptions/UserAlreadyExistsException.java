package io.egen.movieflix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="User Already Exists")
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 3932906165189258949L;
}
