package com.tmall.tmall_springboot.service;

import com.tmall.tmall_springboot.dao.PropertyValueDAO;
import com.tmall.tmall_springboot.pojo.Product;
import com.tmall.tmall_springboot.pojo.Property;
import com.tmall.tmall_springboot.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {
    @Autowired
    PropertyValueDAO propertyValueDAO;

    @Autowired
    PropertyService propertyService;

    public void update(PropertyValue bean){
        propertyValueDAO.save(bean);
    }

    public void init(Product product){
        List<Property> properties = propertyService.listByCategory(product.getCategory());
        for (Property property : properties){
            PropertyValue propertyValue = getByPropertyAndProduct(product, property);
            if (propertyValue == null){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    public PropertyValue getByPropertyAndProduct(Product product, Property property) {
        return propertyValueDAO.getByPropertyAndProduct(property,product);
    }

    public List<PropertyValue> list(Product product) {
        return propertyValueDAO.findByProductOrderByIdDesc(product);
    }
}
