package com.example.swaredemo1;

import com.alibaba.fastjson.JSON;
import com.example.swaredemo1.Bean.data;
import com.example.swaredemo1.Bean.resp;
import com.example.swaredemo1.Bean.test0515;
import com.example.swaredemo1.Dao.dao;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class test {
    @Autowired
    com.example.swaredemo1.Dao.dao testdao;


    @Test
    public void test1(){
        test0515 test0515=new test0515();
        JSONArray jsonArray=new JSONArray();
        List<String> tempdata=testdao.gettitle();
        List<JSON> data=new ArrayList<JSON>();
        for (int i=0;i<tempdata.size();i++){
            data.add(JSON.parseObject(tempdata.get(i)));
        }
        System.out.println(data);
        for (int i=data.size();i<data.size();i++){
            System.out.println( data.get(i));

        }
    }
    
}
