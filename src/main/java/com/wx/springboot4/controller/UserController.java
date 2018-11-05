package com.wx.springboot4.controller;


import com.wx.springboot4.pojo.User;
import com.wx.springboot4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    /*
      springboot 整合mybatis,测试restful的远程调用
     */
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @RequestMapping(value = "/getuser/{id}")
    public User getUser(@PathVariable Integer id)
    {
        System.out.print("---------------------------------"+id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        User object = restTemplate.getForObject("http://localhost:8081/finduser/?id={id}", User.class, id);
        return object;
    }
    @RequestMapping(value = "/adduser")
    public int addUser(@RequestParam String name,@RequestParam Integer age,@RequestParam String addr)
    {
        int add = userService.add(name, age, addr);
        return add;
    }
    @RequestMapping(value = "/finduser")
    public User fingUser(@RequestParam Integer id)
    {
        return userService.findUser(id);
    }
    @RequestMapping(value = "findAll")
    public List<User> findAll()
    {
        return userService.findAccountList();
    }
    @RequestMapping("/testTransactional")
    public void testTransactional()
    {
        userService.update2();
    }
}
