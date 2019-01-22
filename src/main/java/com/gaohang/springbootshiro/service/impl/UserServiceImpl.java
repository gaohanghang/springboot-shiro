package com.gaohang.springbootshiro.service.impl;

import com.gaohang.springbootshiro.domin.User;
import com.gaohang.springbootshiro.mapper.UserRepository;
import com.gaohang.springbootshiro.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/22 12:59
 */
@Service
public class UserServiceImpl implements Userservice {

    // 注入Mapper接口
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }
}
