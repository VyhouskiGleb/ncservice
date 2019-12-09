package com.netcracker.edu.backend.dto;

import com.netcracker.edu.backend.entity.Library;

public class LibResponce extends Responce {
    private Library data;

    public Library getData() {
        return data;
    }

    public void setData(Library data) {
        this.data = data;
    }

    public LibResponce(boolean status, String message, Library data) {
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
