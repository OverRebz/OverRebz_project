package com.example.swaredemo1.Bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Data1 {

    List<Object[]> data;
    String dataGroupId;

    public Data1(Double tag_weight, String tag_name , String name) {
        this.data=new ArrayList<>();
        this.dataGroupId = tag_name;
        Object[] objects = new Object[2];
        objects[0]=name;
        objects[1]=tag_weight;
        this.data.add(objects);
    }

}
