package com.menulink.custocoding.MenuLink.mappers;


import com.menulink.custocoding.MenuLink.dtos.CustomerCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.CustomerResponseDTO;
import com.menulink.custocoding.MenuLink.models.Customer;
import com.menulink.custocoding.MenuLink.repositories.MenuRepository;
import com.menulink.custocoding.MenuLink.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class CustomerMapper {

    public CustomerResponseDTO toCustomerResponseDTO(Customer dto){
        return new CustomerResponseDTO(
                dto.getId(),
                dto.getUsername(),
                dto.getPhonenumber(),
                dto.getGender()
        );
    }

    public Customer toCustomerDTO(CustomerCreateDTO dto){
        var customer = new Customer();

        customer.setUsername(dto.username());
        customer.setPhonenumber(dto.phonenumber());
        customer.setGender(dto.gender());
        return customer;

    }




}
