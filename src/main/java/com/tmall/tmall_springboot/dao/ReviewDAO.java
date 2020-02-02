package com.tmall.tmall_springboot.dao;

import com.tmall.tmall_springboot.pojo.Product;
import com.tmall.tmall_springboot.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);
}
