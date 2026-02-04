package com.menulink.custocoding.MenuLink.auth.services;


import com.menulink.custocoding.MenuLink.auth.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.auth.mappers.RestaurantMapper;
import com.menulink.custocoding.MenuLink.auth.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantService {


    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantResponseDTO saveRestaurant(
            RestaurantCreateDTO request
    ){
        var restaurant = restaurantMapper.toRestaurantDTO(request);
        var savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.toRestaurantResponseDTO(savedRestaurant);

    }

    public List<RestaurantResponseDTO> getAllRestaurants(){
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::toRestaurantResponseDTO)
                .collect(Collectors.toList());
    }

    public RestaurantResponseDTO getRestaurantById(
            String id
    ){
        return restaurantRepository.findById(id)
                .map(restaurantMapper::toRestaurantResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Restaurant not found"
                ));
    }


    public void deleteRestaurant(
            String id
    ){
        restaurantRepository.deleteById(id);
    }


}
