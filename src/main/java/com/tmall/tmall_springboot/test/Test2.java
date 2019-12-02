package com.tmall.tmall_springboot.test;

import com.tmall.tmall_springboot.dao.CategoryDAO;
import com.tmall.tmall_springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class Test2 {
    @Autowired
    CategoryDAO categoryDAO;


    List<Category> cs = categoryDAO.findAll();





}
