package com.tmall.tmall_springboot.dao;

import com.tmall.tmall_springboot.pojo.Product;
import com.tmall.tmall_springboot.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer> {
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
}
