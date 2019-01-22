package com.gaohang.springbootshiro.mapper;

import com.gaohang.springbootshiro.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/22 12:45
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByName(String name);

    public Optional<User> findById(Integer id);
}
