package com.menulink.custocoding.MenuLink.auth.controllers;

import com.menulink.custocoding.MenuLink.auth.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.auth.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;



    @GetMapping("/api/product")
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/api/product/{id}")
    public ProductResponseDTO getProductById(
            @PathVariable Long id
    ){
        return productService.getProductById(id);
    }


    @PostMapping("/api/product")
    public ProductResponseDTO createProduct(
            @RequestBody ProductCreateDTO request
    ){
        return productService.saveProduct(request);
    }


    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(
            @PathVariable Long id
    ){
        productService.deleteProduct(id);
    }






}
