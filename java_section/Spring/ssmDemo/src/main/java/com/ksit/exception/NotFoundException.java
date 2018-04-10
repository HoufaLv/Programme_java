package com.ksit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Lvhoufa
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "No resource found!")
public class NotFoundException extends RuntimeException {

}
