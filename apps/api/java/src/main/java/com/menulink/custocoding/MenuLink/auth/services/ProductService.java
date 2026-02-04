package com.menulink.custocoding.MenuLink.auth.services;


import com.menulink.custocoding.MenuLink.auth.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.auth.mappers.ProductMapper;
import com.menulink.custocoding.MenuLink.auth.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductResponseDTO> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(
            Long id
    ){
        return productRepository.findById(id)
                .map(productMapper::toProductResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product not found"
                ));
    }

    public void deleteProduct(
            Long id
    ){
        productRepository.deleteById(id);
    }




}
