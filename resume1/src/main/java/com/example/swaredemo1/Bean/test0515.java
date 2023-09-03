package com.example.swaredemo1.Bean;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.json.JSONObject;

import java.util.List;

@Data
public class test0515 {
    int Code;
    String message;
    List<JSON> data;
}
