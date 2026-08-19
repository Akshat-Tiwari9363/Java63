package com.ecom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.repository.ProductRepo;
import com.ecom.model.Product;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;
    
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProduct(int id){
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product p,MultipartFile img) throws IOException{
        p.setImageName(img.getOriginalFilename());
        p.setImageType(img.getContentType());
        p.setImageData(img.getBytes());
        return repo.save(p);
    }

    public Product updateProduct(int id,Product p,MultipartFile img)throws IOException{
        p.setImageName(img.getOriginalFilename());
        p.setImageType(img.getContentType());
        p.setImageData(img.getBytes());
        return repo.save(p);
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }

}
