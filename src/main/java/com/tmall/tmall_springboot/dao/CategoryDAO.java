package com.tmall.tmall_springboot.dao;

import com.tmall.tmall_springboot.pojo.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
