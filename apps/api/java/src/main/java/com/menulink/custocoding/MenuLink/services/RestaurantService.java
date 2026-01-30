package com.menulink.custocoding.MenuLink.services;


import com.menulink.custocoding.MenuLink.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.mappers.RestaurantMapper;
import com.menulink.custocoding.MenuLink.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
