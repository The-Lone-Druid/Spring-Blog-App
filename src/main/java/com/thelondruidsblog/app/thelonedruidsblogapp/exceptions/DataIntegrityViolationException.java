package com.thelondruidsblog.app.thelonedruidsblogapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataIntegrityViolationException extends RuntimeException{

        String message;

        public DataIntegrityViolationException(String message) {
            super(String.format("%s", message));
            this.message = message;
        }
}
