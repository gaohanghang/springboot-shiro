package com.gaohang.springbootshiro.domin;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/22 12:45
 */
@Entity(name = "user")
public class User {

    @Id
    int id;
    String name;
    String password;
    String perms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
