package com.example.swaredemo1.Bean;

import lombok.Data;

@Data
public class Num_tags {
    public String groupId;
    public Integer value;

    public Num_tags(String tag_name, Integer num) {
        this.groupId = tag_name;
        this.value = num;
    }
}