package gmo.product.service.impl;

import gmo.product.entity.Product;
import gmo.product.repository.IProductRepository;
import gmo.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> findAllByPriceBetween(double minPrice, double maxPrice) {
        return iProductRepository.findAllByPriceBetween(minPrice, maxPrice);
    }
}
