package com.menulink.custocoding.MenuLink.auth.mappers;


import com.menulink.custocoding.MenuLink.auth.dtos.RestaurantCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.RestaurantResponseDTO;
import com.menulink.custocoding.MenuLink.auth.models.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantMapper {

  /*  private final OwnerRepository ownerRepository;
    private final RestaurantAdressRepository restaurantAdressRepository;
*/

    public Restaurant toRestaurantDTO(RestaurantCreateDTO dto){

  /*      Owner owner = ownerRepository.findById(dto.ownerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Owner not found"
                ));

        RestaurantAdress restaurantAdress = restaurantAdressRepository.findById(dto.adressId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Adress not found"
                ));
*/
        var restaurant = new Restaurant();
        restaurant.setName(dto.name());
        restaurant.setPhonenumber(dto.phonenumber());
        restaurant.setEmail(dto.email());
        restaurant.setNuit(dto.nuit());
/*        restaurant.setOwner(owner);
        restaurant.setAdress(restaurantAdress);*/

        return restaurant;

    }

    public RestaurantResponseDTO toRestaurantResponseDTO(Restaurant dto){
        return new RestaurantResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getPhonenumber(),
                dto.getEmail(),
                dto.getNuit()
  /*              dto.getAdress(),
                dto.getOwner()*/
        );
    }

}
