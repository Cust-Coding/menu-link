package com.menulink.custocoding.MenuLink.mappers;


import com.menulink.custocoding.MenuLink.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.models.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMapper {


    public Restaurant toRestaurantDTO(RestaurantCreateDTO dto){
        var restaurant = new Restaurant();
        restaurant.setName(dto.name());
        restaurant.setPhonenumber(dto.phonenumber());
        restaurant.setEmail(dto.email());
        restaurant.setNuit(dto.nuit());

        return restaurant;

    }

    public RestaurantResponseDTO toRestaurantResponseDTO(Restaurant dto){
        return new RestaurantResponseDTO(
                dto.getName(),
                dto.getPhonenumber(),
                dto.getEmail()
        );
    }

}
