package com.example.swaredemo1.Controller;

import com.alibaba.fastjson.JSON;
import com.example.swaredemo1.Bean.*;
import com.example.swaredemo1.Bean.drilldownData.drilldownData;
import com.example.swaredemo1.Dao.dao;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Insert;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.swaredemo1.temp.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class controller {

    @Autowired
    dao testdao;

    @PostMapping(value = "/upload")
    public String outp(@RequestParam("file") MultipartFile multipartFile) {
        String url = "D:\\Java\\SWareDemo1\\src\\doc";
        System.out.println("------------------------");
        System.out.println(multipartFile.isEmpty());
        System.out.println(multipartFile.getSize());
        try {

            // 得到上传文件后缀
            String originalName = multipartFile.getOriginalFilename();
            // 新生成的文件名称
            String fileName = originalName;
            // 复制文件
            File targetFile = new File(url, fileName);
            FileUtils.writeByteArrayToFile(targetFile, multipartFile.getBytes());
            String jurl1 = url + "\\" + fileName;
            File JsonFile = new File(jurl1);
            System.out.println(JsonFile.getPath() + "--------------" + JsonFile.isDirectory());
            String url1 = "http://resumesdk.market.alicloudapi.com/ResumeParser";
            String appcode = "643d044796654bd18c817848b04461f3";
            JSONObject jsonObject = testParser.testParser(url1, jurl1, appcode, fileName);

            testdao.add(jsonObject.toString(),"测试姓名");
        } catch (IOException e) {
            System.out.println("faile");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "**************************************************************";
    }

    @GetMapping("/test")
    public String tessss(@RequestBody String a) {
        System.out.println(a);
        return null;
    }

    @PostMapping("/a")
    public void a(@RequestParam("id") String id) {
        System.out.println(id);
    }

    @GetMapping("/byd")
    public resp test() {
        resp resp = new resp();
        resp.setCode(20000);
        resp.setMessage("sss");
        List<data> datas = testdao.getALl();
        System.out.println("--------------------------------------------");
        System.out.println(datas);
        System.out.println("--------------------------------------------");
        return null;
    }
    @GetMapping("/zzz")
    public resp test111111(){
        List<data> dataList=testdao.getALl1();
        System.out.println(testdao.getALl1().toString()+"---------9898");
        resp resp=new resp();
        resp.setMessage("已传至前端");
        resp.setCode(20000);
        resp.setData(dataList);
        return resp;
    }
    @PostMapping("/byd")
    public void testsssss() throws IOException {
        File file = new File("D:\\Java\\SWareDemo1\\src\\doc\\18.docx.json");
        System.out.println(file.getName());
        String a = FileUtils.readFileToString(file, "UTF-8");
        String name="太酷啦！！！";
        System.out.println("-------------------------------------");
        testdao.add(a,name);

    }
    @GetMapping("/zber")
    public test0515 test0515(){
        test0515 test0515=new test0515();
        JSONArray jsonArray=new JSONArray();
        List<String> tempdata=testdao.gettitle();
        List<JSON> data=new ArrayList<JSON>();
            for (int i=0;i<tempdata.size();i++){
            data.add(JSON.parseObject(tempdata.get(i)));
            }
        System.out.println(jsonArray.length());
            test0515.setCode(20000);
            test0515.setMessage("whatever");
            test0515.setData(data);
        return test0515;
    }
//    @GetMapping("/downdata")
//    public drilldownData downtest(){
//        test0515 test0515=new test0515();
//        JSONArray jsonArray=new JSONArray();
//        List<String> tempdata=testdao.gettitle();
//        List<JSON> data=new ArrayList<JSON>();
//        for (int i=0;i<tempdata.size();i++){
//            data.add(JSON.parseObject(tempdata.get(i)));
//        }
//        System.out.println(data);
//        for (int i=data.size();i<data.size();i++){
//            System.out.println( data.get(i));
//
//        }
//
////        drilldownData drilldownData=new drilldownData();
////        String dataGroupId="animals";
////        Object[] os=new Object[2];
////        os[0]="Cats";
////        os[1]=1.2;
////        List<Object[]> objects=new ArrayList<>();
////        objects.add(os);
////        objects.add(os);
////        objects.add(os);
////        objects.add(os);
////        objects.add(os);
////        drilldownData.setDataGroupId(dataGroupId);
////        drilldownData.setData(objects);
////        System.out.println("测试");
//        return null;
//    }
@GetMapping("/ceshi01")
public ceshi01 ceshi01() {
    List<String> titleList = testdao.gettitle();
//        System.out.println(testdao.gettitle().toString() + "---------9898");
    ceshi01 ceshi01 = new ceshi01();
    ceshi01.setMessage("已传至前端");
    ceshi01.setCode(20000);

    List<Data1> dataList = new ArrayList<Data1>();

    for (int i =0 ;i<titleList.size();i++) {
        JSONObject result = (JSONObject) new JSONObject(titleList.get(i)).get("result");
        String name = result.getString("name");

        JSONObject tags = (JSONObject) new JSONObject(titleList.get(i)).get("tags");
        JSONArray pos_tags = (JSONArray) tags.get("pos_tags");
        if (pos_tags.length()==0){continue;}
        Double tag_weight = pos_tags.getJSONObject(0).getDouble("tag_weight");

        String tag_name = pos_tags.getJSONObject(0).getString("tag_name");
        Data1 data1 = new Data1(tag_weight,tag_name,name);
        dataList.add(data1);
    }
    List<Data1> data1List = new ArrayList<>();
    List<Num_tags> num_tagsList= new ArrayList<Num_tags>();

    for (int j = 0 ;j<dataList.size();j++){
        Data1 data1 = dataList.get(j);
        int disapear = 0;
        int i = 0;
        for (Num_tags num_tags: num_tagsList){
            if (data1.getDataGroupId().equals(num_tags.getGroupId())){
                disapear++;
                num_tags.value++;
                Object[] objects = new Object[2];
                objects[0]=dataList.get(j).getData().get(0)[0];
                objects[1]=dataList.get(j).getData().get(0)[1];
                data1List.get(i).getData().add(objects);

            }
            i++;
        }
        if (disapear==0){
            Num_tags num_tags = new Num_tags(data1.getDataGroupId(),1);
            num_tagsList.add(num_tags);
            Data1 _data1 = new Data1((Double) data1.getData().get(0)[1],data1.getDataGroupId(),(String) data1.getData().get(0)[0]);
            data1List.add(_data1);
        }
    }
    System.out.println(num_tagsList.get(0).getGroupId()+num_tagsList.get(0).value);
    Map<String,List> map = new HashMap<>();
    map.put("fubiao",data1List);
    map.put("zhubiao",num_tagsList);
    ceshi01.setData(map);
    return ceshi01;
}



}
