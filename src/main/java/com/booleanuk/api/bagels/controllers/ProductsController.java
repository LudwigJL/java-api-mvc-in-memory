package com.booleanuk.api.bagels.controllers;

import com.booleanuk.api.bagels.models.Product;
import com.booleanuk.api.bagels.repositories.ProductsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("products")
public class ProductsController {
    private ProductsRepository theProducts;

    public ProductsController(){
        this.theProducts = new ProductsRepository();
    }

    @GetMapping
    public List<Product> findAll(){
        return this.theProducts.findAll();

    }

    @GetMapping("{id}")
    public Product find(@PathVariable int id){
        return this.theProducts.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return this.theProducts.create(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable int id, @RequestBody Product product){
        return this.theProducts.update(id, product);
    }

    @DeleteMapping("{id}")
    public Product remove(@PathVariable int id){
        return this.theProducts.remove(id);
    }


}
