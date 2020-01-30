package com.tmall.tmall_springboot.dao;

import com.tmall.tmall_springboot.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
}
