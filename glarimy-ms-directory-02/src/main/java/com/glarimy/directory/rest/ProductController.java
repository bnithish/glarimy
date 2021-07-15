package com.glarimy.directory.rest;

import com.glarimy.directory.data.ProductRepository;
import com.glarimy.directory.domain.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("product/add")
    public List<Product> add(@RequestBody List<Product> products) {
        return productRepository.saveAll(products);
    }

    @GetMapping("product/name/{name}")
    public List<Product> get(@PathVariable String name) {
        return productRepository.findAllByName(name);
    }

    @Transactional
    @DeleteMapping("product/name/{name}")
    public int delete(@PathVariable String name) {
        return productRepository.deleteAllByName(name);
    }
}
