package com.tmall.tmall_springboot.service;

import com.tmall.tmall_springboot.dao.PropertyDAO;
import com.tmall.tmall_springboot.pojo.Category;
import com.tmall.tmall_springboot.pojo.Property;
import com.tmall.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PropertyService {
    @Autowired
    PropertyDAO propertyDAO;

    @Autowired
    CategoryService categoryService;

    public void add(Property bean) {
        propertyDAO.save(bean);
    }

    public void delete(int id) {
        propertyDAO.deleteById(id);
    }

    public Property get(int id) {
        return propertyDAO.getOne(id);
    }

    public void update(Property bean) {
        propertyDAO.save(bean);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);

        Page<Property> pageFromJPA =propertyDAO.findByCategory(category,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);

    }


}
