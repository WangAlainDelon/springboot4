package com.wx.springboot4.dao;

import com.wx.springboot4.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    int add(@Param("name") String name, @Param("age") Integer age, @Param("addr") String addr);


    int update(@Param("name") String name, @Param("age") Integer age, @Param("addr") String addr, @Param("id") int id);

    int delete(int id);

    User findAccount(@Param("id") int id);

    List<User> findAccountList();
}
