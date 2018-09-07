package com.winterchen.dao;


import java.util.List;

import com.winterchen.model.UserDomain;

public interface UserMapper {


    int insert(UserDomain record);



    List<UserDomain> selectUsers();
}