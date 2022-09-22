package gmo.category.service.impl;

import gmo.category.entity.Category;
import gmo.category.proxy.ProductProxy;
import gmo.category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ProductProxy productProxy;

    @Override
    public Category findPhone() {
        Category category = new Category();
        category.setId(1L);
        category.setNameCategory("Phone");
        category.setProducts(productProxy.findAllProducts().getBody());
        return category;
    }

    @Override
    public Category search() {
        Category category = new Category();
        category.setId(1L);
        category.setNameCategory("Phone");
        category.setProducts(productProxy.search(5, 10).getBody());
        return category;
    }
}
