package com.netcracker.edu.fapi.dto;

import com.netcracker.edu.fapi.models.Lib;

public class LibResponce extends Responce {
    private Lib data;


    public Lib getData() {
        return data;
    }

    public void setData(Lib data) {
        this.data = data;
    }

    public LibResponce(boolean status, String message, Lib data) {
        super(status, message);
        this.data = data;
    }

    @Override
    public String toString() {
        return "LibResponce{" +
                "data=" + data +
                '}';
    }
}
