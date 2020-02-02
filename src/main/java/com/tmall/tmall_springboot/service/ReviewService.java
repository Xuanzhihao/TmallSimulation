package com.tmall.tmall_springboot.service;

import com.tmall.tmall_springboot.dao.ReviewDAO;
import com.tmall.tmall_springboot.pojo.Product;
import com.tmall.tmall_springboot.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewDAO reviewDAO;

    @Autowired
    ProductService productService;

    public void add(Review review){
        reviewDAO.save(review);
    }

    public List<Review> list(Product product){
        List<Review> reviewList = reviewDAO.findByProductOrderByIdDesc(product);
        return reviewList;
    }

    public int getCount(Product product){
        return reviewDAO.countByProduct(product);
    }

}
