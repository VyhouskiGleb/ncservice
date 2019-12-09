package com.netcracker.edu.fapi.dto;

import java.util.Objects;

public class Responce {
    private boolean status;
    private String  message;


    public boolean status() {
        return status;
    }

    public void status(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responce that = (Responce) o;
        return status == that.status &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    public Responce(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
