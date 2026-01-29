package com.menulink.custocoding.MenuLink.controllers;


import com.menulink.custocoding.MenuLink.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.models.Restaurant;
import com.menulink.custocoding.MenuLink.repositories.RestaurantRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {


    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/api/restaurants")
    public RestaurantResponseDTO createRestaurant(
            @RequestBody RestaurantCreateDTO request
    ){
        var restaurant = toRestaurantDTO(request);
        var savedRestaurant = restaurantRepository.save(restaurant);
        return toRestaurantResponseDTO(savedRestaurant);
    }

    private Restaurant toRestaurantDTO(RestaurantCreateDTO dto){
        var restaurant = new Restaurant();
        restaurant.setName(dto.name());
        restaurant.setPhonenumber(dto.phonenumber());
        restaurant.setEmail(dto.email());
        restaurant.setNuit(dto.nuit());

        return restaurant;

    }

    private RestaurantResponseDTO toRestaurantResponseDTO(Restaurant dto){
        return new RestaurantResponseDTO(
                dto.getName(),
                dto.getPhonenumber(),
                dto.getEmail()
        );
    }


}
