package com.tmall.tmall_springboot.dao;

import com.tmall.tmall_springboot.pojo.Order;
import com.tmall.tmall_springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
