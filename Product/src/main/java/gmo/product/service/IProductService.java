package gmo.product.service;

import gmo.product.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    List<Product> findAllByPriceBetween(double minPrice, double maxPrice);
}
