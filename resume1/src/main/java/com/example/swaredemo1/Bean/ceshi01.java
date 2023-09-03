package com.example.swaredemo1.Bean;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

@Data
public class ceshi01 {
    int Code;
    String message;
    Map<String,List> Data;
}
