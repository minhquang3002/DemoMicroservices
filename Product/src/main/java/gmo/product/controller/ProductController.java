package gmo.product.controller;

import gmo.product.entity.Product;
import gmo.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAllProducts() {
        try {
            return new ResponseEntity<List<Product>>(iProductService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "search/{min}/{max}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> search(@PathVariable double min, @PathVariable double max) {
        try {
            return new ResponseEntity<List<Product>>(iProductService.findAllByPriceBetween(min, max), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
        }
    }
}
