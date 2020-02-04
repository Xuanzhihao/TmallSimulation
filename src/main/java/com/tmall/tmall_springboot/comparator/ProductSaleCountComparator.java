package com.tmall.tmall_springboot.comparator;

import com.tmall.tmall_springboot.pojo.Product;

import java.util.Comparator;

public class ProductSaleCountComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount() - o1.getSaleCount();
    }
}
