package com.example.swaredemo1.Dao;

import com.example.swaredemo1.Bean.data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Mapper
public interface dao {
    @Insert("insert into test(title,name) VALUES (#{a},#{name})")
    void add(String a, String name);

    @Select("select * from test")
    List<data> getALl();

    @Select("select * from asd")
    String gets();

    @Select("select * from test")
    List<data> getALl1();
@Select("select title from test")
    List<String> gettitle();
}
