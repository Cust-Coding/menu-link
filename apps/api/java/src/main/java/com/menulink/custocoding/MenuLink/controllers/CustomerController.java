package com.menulink.custocoding.MenuLink.controllers;

import com.menulink.custocoding.MenuLink.dtos.CustomerCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.CustomerResponseDTO;
import com.menulink.custocoding.MenuLink.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/api/customers")
    public CustomerResponseDTO saveCustomer(
            @RequestBody CustomerCreateDTO customer
    ){
        return  customerService.saveCustomer(customer);
    }



}
