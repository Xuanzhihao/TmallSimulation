package com.tmall.tmall_springboot.web;

import com.tmall.tmall_springboot.pojo.Product;
import com.tmall.tmall_springboot.pojo.PropertyValue;
import com.tmall.tmall_springboot.service.ProductService;
import com.tmall.tmall_springboot.service.PropertyService;
import com.tmall.tmall_springboot.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception{
        Product product = productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues = propertyValueService.list(product);
        return  propertyValues;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception{
        propertyValueService.update(bean);
        return bean;
    }
}
