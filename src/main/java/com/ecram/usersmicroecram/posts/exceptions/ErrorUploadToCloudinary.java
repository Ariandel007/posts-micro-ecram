package com.ecram.usersmicroecram.posts.exceptions;

public class ErrorUploadToCloudinary extends GeneralException {

    public ErrorUploadToCloudinary(String message, String errorCode) {
        super(message, errorCode);
    }
}