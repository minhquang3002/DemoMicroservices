package gmo.category.controller;

import gmo.category.entity.Category;
import gmo.category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> findPhone() {
        try {
            return new ResponseEntity<Category>(iCategoryService.findPhone(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> search() {
        try {
            return new ResponseEntity<Category>(iCategoryService.search(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
        }
    }
}
