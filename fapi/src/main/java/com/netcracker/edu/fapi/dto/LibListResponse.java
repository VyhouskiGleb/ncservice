package com.netcracker.edu.fapi.dto;
import com.netcracker.edu.fapi.models.Lib;

import java.util.Arrays;
import java.util.List;

public class LibListResponse extends Response {
    private long counter;

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    private List<Lib> data;

    public List<Lib> getData() {
        return data;
    }

    public void setData(List<Lib> data) {
        this.data = data;
    }
    public LibListResponse() {
        super();
    }
    public LibListResponse(boolean status, String message, long counter, List<Lib> data) {
        super(status, message);
        this.data = data;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "LibListResponse{" +
                "data=" + data +
                '}';
    }
}
