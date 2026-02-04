package com.menulink.custocoding.MenuLink.auth.mappers;


import com.menulink.custocoding.MenuLink.auth.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.auth.models.Menu;
import com.menulink.custocoding.MenuLink.auth.models.Restaurant;
import com.menulink.custocoding.MenuLink.auth.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class MenuMapper {

    private final RestaurantRepository restaurantRepository;

    public Menu toMenuDTO(MenuCreateDTO dto){

        Restaurant restaurant = restaurantRepository.findById(dto.restaurantId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Restaurant not found"
                ));


        var menu = new Menu();
        menu.setName(dto.name());
        menu.setDescription(dto.description());
        menu.setRestaurant(restaurant);

        return menu;
    }


    public MenuResponseDTO toMenuResponse(Menu dto){
        return new MenuResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getRestaurant().getId(),
                dto.getRestaurant().getName()
        );
    }
}
