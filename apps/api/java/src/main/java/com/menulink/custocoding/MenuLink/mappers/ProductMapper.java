package com.menulink.custocoding.MenuLink.mappers;


import com.menulink.custocoding.MenuLink.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProductDTO(ProductCreateDTO dto){
        var product = new Product();

        product.setNome(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setRestaurant(dto.restaurant());
        product.setStock(dto.stock());

        return product;
    }

    public ProductResponseDTO toProductResponseDTO(Product dto){
        return new ProductResponseDTO(
                dto.getNome(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getRestaurant(),
                dto.getStock()
        );
    }
}
