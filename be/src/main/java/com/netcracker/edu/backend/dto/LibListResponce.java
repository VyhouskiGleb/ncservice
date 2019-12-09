package com.netcracker.edu.backend.dto;

import com.netcracker.edu.backend.entity.Library;

import java.util.ArrayList;
import java.util.List;

public class LibListResponce extends Responce {
    private List<Library> data = new ArrayList<Library>();

    @Override
    public String toString() {
        return "LibListResponce{" +
                "data=" + data +
                '}';
    }

    public List<Library> getData() {
        return data;
    }

    public void setData(List<Library> data) {
        this.data = data;
    }

    public LibListResponce(boolean status, String message, List<Library> data) {
        super(status, message);
        this.data = data;
    }
}
