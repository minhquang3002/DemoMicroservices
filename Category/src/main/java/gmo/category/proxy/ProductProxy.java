package gmo.category.proxy;

import gmo.category.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductProxy {

    @RequestMapping(value = "findall", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProducts();

    @RequestMapping(value = "search/{min}/{max}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> search(@PathVariable double min, @PathVariable double max);
}
