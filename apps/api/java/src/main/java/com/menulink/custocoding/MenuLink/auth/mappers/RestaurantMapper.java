package com.menulink.custocoding.MenuLink.auth.mappers;


import com.menulink.custocoding.MenuLink.auth.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.auth.models.Owner;
import com.menulink.custocoding.MenuLink.auth.models.Restaurant;
import com.menulink.custocoding.MenuLink.auth.repositories.OwnerRepository;
import com.menulink.custocoding.MenuLink.auth.repositories.RestaurantAdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class RestaurantMapper {

    private final OwnerRepository ownerRepository;
    private final RestaurantAdressRepository restaurantAdressRepository;

    public Restaurant toRestaurantDTO(RestaurantCreateDTO dto){


        Owner owner = ownerRepository.findById(dto.ownerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Owner not found"
                ));


        var restaurant = new Restaurant();
        restaurant.setName(dto.name());
        restaurant.setPhonenumber(dto.phonenumber());
        restaurant.setEmail(dto.email());
        restaurant.setNuit(dto.nuit());
        restaurant.setOwner(owner);


        return restaurant;

    }

    public RestaurantResponseDTO toRestaurantResponseDTO(Restaurant dto){
        String ownerName = null;
        if(dto.getOwner() != null){
            ownerName = dto.getOwner().getFirstname() + " " + dto.getOwner().getLastname();
        }
        return new RestaurantResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getPhonenumber(),
                dto.getEmail(),
                dto.getNuit(),
                dto.getOwner().getId(),
                ownerName
/*              dto.getAdress(),*/

        );
    }

}
