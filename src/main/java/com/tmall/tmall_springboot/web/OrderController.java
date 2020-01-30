package com.tmall.tmall_springboot.web;

import com.tmall.tmall_springboot.pojo.Order;
import com.tmall.tmall_springboot.service.OrderItemService;
import com.tmall.tmall_springboot.service.OrderService;
import com.tmall.tmall_springboot.util.Page4Navigator;
import com.tmall.tmall_springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/orders")
    public Page4Navigator<Order> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size){
        start = start < 0 ? 0 : start;
        Page4Navigator<Order> page4Navigator = orderService.list(start, size, 5);
        orderItemService.fill(page4Navigator.getContent());
        orderService.removeOrderFromOrderItem(page4Navigator.getContent());
        return page4Navigator;
    }

    @GetMapping("deliveryOrder/{oid}")
    public Object deliverOrder(@PathVariable int oid) throws Exception{
        Order order = orderService.get(oid);
        order.setDeliveryDate(new Date());
        order.setStatus(OrderService.waitDelivery);
        orderService.update(order);
        return Result.success();
    }
}
