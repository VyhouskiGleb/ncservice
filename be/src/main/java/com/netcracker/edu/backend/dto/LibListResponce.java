package com.netcracker.edu.backend.dto;

import com.netcracker.edu.backend.entity.Library;

import java.util.ArrayList;
import java.util.List;

public class LibListResponce extends Responce {
    private long counter = 0;

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

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

    public LibListResponce(boolean status, String message, long counter, List<Library> data) {
        super(status, message);
        this.counter = counter;
        this.data = data;
    }
}
