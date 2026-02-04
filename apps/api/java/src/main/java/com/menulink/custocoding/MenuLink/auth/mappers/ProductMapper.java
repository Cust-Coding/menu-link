package com.menulink.custocoding.MenuLink.auth.mappers;


import com.menulink.custocoding.MenuLink.auth.dtos.ProductCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.ProductResponseDTO;
import com.menulink.custocoding.MenuLink.auth.models.Product;
import com.menulink.custocoding.MenuLink.auth.models.Restaurant;
import com.menulink.custocoding.MenuLink.auth.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProductMapper {

    private final RestaurantRepository restaurantRepository;


    public Product toProductDTO(ProductCreateDTO dto){

        Restaurant restaurant = restaurantRepository.findById(dto.restaurantId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND , "Restaurant not found"
                ));

        var product = new Product();

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setRestaurant(restaurant);


        return product;
    }

    public ProductResponseDTO toProductResponseDTO(Product dto){
        return new ProductResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getRestaurant().getId(),
                dto.getRestaurant().getName()
        );
    }
}
