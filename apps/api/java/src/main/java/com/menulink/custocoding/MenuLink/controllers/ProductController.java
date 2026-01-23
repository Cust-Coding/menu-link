package com.menulink.custocoding.MenuLink.controllers;


import com.menulink.custocoding.MenuLink.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.models.Products;
import com.menulink.custocoding.MenuLink.repositories.ProductRepositoy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductRepositoy productRepository;

    public ProductController(ProductRepositoy productRepository){
        this.productRepository = productRepository;
    }


    @PostMapping("/api/products")
    public ProductResponseDTO createProduct(
            @RequestBody ProductCreateDTO request
    ){
        var product = toProductDTO(request);
        var savedProduct = productRepository.save(product);
        return toProductResponseDTO(savedProduct);
    }

    private Products toProductDTO(ProductCreateDTO dto){
        var product = new Products();

        product.setNome(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setRestaurants(dto.restaurants());
        product.setStock(dto.stock());

        return product;
    }

    private ProductResponseDTO toProductResponseDTO(Products dto){
        return new ProductResponseDTO(
                dto.getId(),
                dto.getNome(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getRestaurants(),
                dto.getStock()
        );
    }



}
