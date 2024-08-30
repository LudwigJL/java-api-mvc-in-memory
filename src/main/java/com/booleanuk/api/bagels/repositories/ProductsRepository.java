package com.booleanuk.api.bagels.repositories;

import com.booleanuk.api.bagels.models.Product;
import com.sun.source.tree.BreakTree;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductsRepository {
    private List<Product> data = new ArrayList<>();

    public ProductsRepository(){
        this.data = new ArrayList<>();


        this.data.add(new Product("Fidget Spinner", "Toys", 200));
        this.data.add(new Product("Xbox Series X", "Gaming", 7500));
    }

    public Product create(Product insertProduct) {
        for (Product item : data){
            if (Objects.equals(item.getName(), insertProduct.getName())){
                return null;
            }
        }

        Product product = new Product(insertProduct.getName(), insertProduct.getCategory(), insertProduct.getPrice());

        this.data.add(product);
        return product;
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product find(int id){
        for (Product product : data){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public Product update(int id, Product insertProduct){
        for(Product product : data){
            if (product.getId() == id){
                product.setName(insertProduct.getName());
                product.setCategory(insertProduct.getCategory());
                product.setPrice(insertProduct.getPrice());

                return product;
            }
        }

        return null;
    }

    public Product remove(int id){
        for (Product product : data){
            if(product.getId() == id){
                data.remove(product);

                return product;
            }
        }
        return null;
    }


}
