package com.wx.springboot4.service;


import com.wx.springboot4.dao.UserMapper;
import com.wx.springboot4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public int add(String name, Integer age,String addr) {
        return userMapper.add(name, age,addr);
    }

    public int update(String name, Integer age,String addr, int id) {
        return userMapper.update(name, age,addr,id);
    }
    public int delete(int id) {
        return userMapper.delete(id);
    }
    public User findUser(int id) {
        return userMapper.findAccount(id);
    }
    public List<User> findAccountList() {
        return userMapper.findAccountList();
    }
    @Transactional
    public void update2() {
        userMapper.update("李四", 4,"崂山",1);
        //int i=10/0;
        userMapper.update("张三", 3,"崂山",2);
    }
}
