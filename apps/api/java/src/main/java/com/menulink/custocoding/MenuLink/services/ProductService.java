package com.menulink.custocoding.MenuLink.services;


import com.menulink.custocoding.MenuLink.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.mappers.ProductMapper;
import com.menulink.custocoding.MenuLink.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductResponseDTO saveProduct(
            ProductCreateDTO request
    ){
        var product = productMapper.toProductDTO(request);
        var savedProduct = productRepository.save(product);
        return productMapper.toProductResponseDTO(savedProduct);
    }

}
