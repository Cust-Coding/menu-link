package com.menulink.custocoding.MenuLink.controllers;


import com.menulink.custocoding.MenuLink.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.models.Product;
import com.menulink.custocoding.MenuLink.repositories.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
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

    private Product toProductDTO(ProductCreateDTO dto){
        var product = new Product();

        product.setNome(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setRestaurant(dto.restaurant());
        product.setStock(dto.stock());

        return product;
    }

    private ProductResponseDTO toProductResponseDTO(Product dto){
        return new ProductResponseDTO(
                dto.getId(),
                dto.getNome(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getRestaurant(),
                dto.getStock()
        );
    }



}
