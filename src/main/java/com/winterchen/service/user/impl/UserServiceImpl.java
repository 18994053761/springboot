package com.winterchen.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.UserMapper;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapepr;// 这里会报错，但是并不会影响

	@Override
	public int addUser(UserDomain user) {

		return userMapepr.insert(user);
	}

	@Override
	public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize) {
		// 将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<UserDomain> userDomains = userMapepr.selectUsers();
		PageInfo<UserDomain> result = new PageInfo<UserDomain>(userDomains);
		return result;
	}
}
