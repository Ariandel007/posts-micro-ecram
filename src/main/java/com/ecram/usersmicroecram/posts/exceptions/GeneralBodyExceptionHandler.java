package com.ecram.usersmicroecram.posts.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralBodyExceptionHandler {
    private String errorCode;
    private String message;
    private String localizedMessage;
}
