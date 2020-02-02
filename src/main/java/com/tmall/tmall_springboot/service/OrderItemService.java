package com.tmall.tmall_springboot.service;

import com.tmall.tmall_springboot.dao.OrderDAO;
import com.tmall.tmall_springboot.dao.OrderItemDAO;
import com.tmall.tmall_springboot.pojo.Order;
import com.tmall.tmall_springboot.pojo.OrderItem;
import com.tmall.tmall_springboot.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired ProductImageService productImageService;

    public void fill(List<Order> orders){
        for (Order order : orders){
            fill(order);
        }
    }

    public void fill(Order order){
        List<OrderItem> orderItems = listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi :orderItems) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
            productImageService.setFirstProdutImage(oi.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    public void update(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }

    public void add(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }
    public OrderItem get(int id) {
        return orderItemDAO.getOne(id);
    }

    public void delete(int id) {
        orderItemDAO.deleteById(id);
    }

    public int getSaleCount(Product product) {
        List<OrderItem> ois =listByProduct(product);
        int result =0;
        for (OrderItem oi : ois) {
            if(null!=oi.getOrder())
                if(null!= oi.getOrder() && null!=oi.getOrder().getPayDate())
                    result+=oi.getNumber();
        }
        return result;
    }

    public List<OrderItem> listByProduct(Product product) {
        return orderItemDAO.findByProduct(product);
    }

    public List<OrderItem> listByOrder(Order order) {
        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }
}
