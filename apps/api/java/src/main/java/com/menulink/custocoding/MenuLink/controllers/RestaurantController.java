package com.menulink.custocoding.MenuLink.controllers;

import com.menulink.custocoding.MenuLink.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.services.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class RestaurantController {


    private final RestaurantService restaurantService;

    @GetMapping("/api/restaurant")
    public List<RestaurantResponseDTO> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/api/restaurant/{id}")
    public RestaurantResponseDTO getRestaurantById(
            @PathVariable("id") String id
    ){
        return restaurantService.getRestaurantById(id);
    }


    @PostMapping("/api/restaurant")
    public RestaurantResponseDTO createRestaurant(
            @RequestBody RestaurantCreateDTO request
    ){
        return restaurantService.saveRestaurant(request);
    }

    @DeleteMapping("/api/restaurant/{id}")
    public void deleteRestaurant(
            @PathVariable("id") String id
    ){
        restaurantService.deleteRestaurant(id);
    }





}
