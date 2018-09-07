package com.winterchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public int addUser(UserDomain user){
        return userService.addUser(user);
    }

    @GetMapping("/user/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
    	
    	System.out.println("2222");
    	
        return userService.findAllUser(pageNum,pageSize);
    }
}
