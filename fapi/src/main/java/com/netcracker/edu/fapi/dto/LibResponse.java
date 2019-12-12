package com.netcracker.edu.fapi.dto;

import com.netcracker.edu.fapi.models.Lib;

public class LibResponse {
    private boolean status;
    private String message;
    private Lib data;

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

    public Lib getData() {
        return data;
    }

    public void setData(Lib data) {
        this.data = data;
    }

    public LibResponse() {
    }

    public LibResponse(boolean status, String message, Lib data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "LibResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
