package com.tmall.tmall_springboot.dao;

import com.tmall.tmall_springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO  extends JpaRepository<User, Integer> {
    User findByName(String name);
}
