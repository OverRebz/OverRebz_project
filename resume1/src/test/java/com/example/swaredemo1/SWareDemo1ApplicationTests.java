package com.example.swaredemo1;


import static com.alibaba.fastjson.JSON.parseObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.swaredemo1.Dao.dao;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class SWareDemo1ApplicationTests {
    @Autowired
    dao dao;

    int start = 0;
    int end = 1;
    int left = 0;
    int right = 0;
    int mark=0;
    @Autowired


//    @Test
//    void contextLoads() {
//        List<String> a = dao.getALl();
//        System.out.println(a);
//        System.out.println("test");
//    }

    @Test
    void Jsontest() throws IOException, JSONException {
        File file = new File("D:\\Java\\SWareDemo1\\src\\doc\\b.json");
        System.out.println(file.getName());
        String a = FileUtils.readFileToString(file, "UTF-8");
//        JSONObject jsonObject=new JSONObject(a);
//        JSONObject jsonObject=parseObject(a);
//        System.out.println(jsonObject);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '{') {
                start = i;
            }
            if (a.charAt(i) == '}') {
                end = i;
//                System.out.println("此时的字符串:"+a.substring(start,end));
                if (panduan(start, end, a)){
                    System.out.println(a.substring(start,end+1)+"----------------------------------------");
                }
                if (panduan(start, end,a)) {
                    start=i+1;
                    end=i+2;
                    mark++;
                }


            }
        }

    }


    private boolean panduan(int start, int end, String a) {
//        System.out.println("北侧目标是-----"+a.substring(start,end+1));
        right=0;
        left=0;
        for (int i = start; i < end; i++) {
//            System.out.println(a.charAt(i));
            if (a.charAt(i) == '{') {
                left++;
            }
            if (a.charAt(i) == '}') {
                right++;
            }
        }
//        System.out.println(left+"*****"+right);
        if (left == right) {
            return true;
        }
        return false;
    }


}
