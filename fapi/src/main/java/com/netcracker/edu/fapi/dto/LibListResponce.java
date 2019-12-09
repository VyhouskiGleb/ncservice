package com.netcracker.edu.fapi.dto;
import com.netcracker.edu.fapi.models.Lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibListResponce extends Responce {
    private Lib[] data;

    @Override
    public String toString() {
        return "LibListResponce{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public Lib[] getData() {
        return data;
    }

    public void setData(Lib[] data) {
        this.data = data;
    }

    public LibListResponce(boolean status, String message, Lib[] data) {
        super(status, message);
        this.data = data;
    }
}
