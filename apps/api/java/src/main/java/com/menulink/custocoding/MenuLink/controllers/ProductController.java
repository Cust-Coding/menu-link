package com.menulink.custocoding.MenuLink.controllers;

import com.menulink.custocoding.MenuLink.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/products")
    public ProductResponseDTO createProduct(
            @RequestBody ProductCreateDTO request
    ){
        return productService.saveProduct(request);
    }





}
