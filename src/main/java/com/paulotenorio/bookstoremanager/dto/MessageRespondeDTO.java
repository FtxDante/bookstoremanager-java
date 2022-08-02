package com.paulotenorio.bookstoremanager.dto;

public class MessageRespondeDTO {
    private String message;

    public MessageRespondeDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
