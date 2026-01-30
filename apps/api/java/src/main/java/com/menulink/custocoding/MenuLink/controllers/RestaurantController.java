package com.menulink.custocoding.MenuLink.controllers;


import com.menulink.custocoding.MenuLink.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.models.Restaurant;
import com.menulink.custocoding.MenuLink.repositories.RestaurantRepository;
import com.menulink.custocoding.MenuLink.services.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
public class RestaurantController {


    private final RestaurantService restaurantService;


    @PostMapping("/restaurants")
    public RestaurantResponseDTO createRestaurant(
            @RequestBody RestaurantCreateDTO request
    ){
        return restaurantService.saveRestaurant(request);
    }


  /*  @GetMapping("/restaurants/{id}")
    public RestaurantResponseDTO getRestaurant(
            @PathVariable String id
    ){
         Restaurant restaurant = restaurantRepository.findById(id)
                 .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Restaurant not found"
                ));

         return toRestaurantResponseDTO(restaurant);
    }*/


}
