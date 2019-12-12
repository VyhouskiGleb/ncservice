package com.netcracker.edu.fapi.dto;

import java.util.Objects;

public class Response {
    private boolean status;
    private String  message;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
        Response that = (Response) o;
        return status == that.status &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }
    public Response() {

    }

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
