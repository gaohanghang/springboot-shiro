package com.gaohang.springbootshiro.service;

import com.gaohang.springbootshiro.domin.User;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/22 12:58
 */
public interface Userservice {
    public User findByName(String name);

    public User findById(Integer id);
}
