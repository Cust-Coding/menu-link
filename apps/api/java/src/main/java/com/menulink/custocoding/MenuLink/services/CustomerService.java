package com.menulink.custocoding.MenuLink.services;


import com.menulink.custocoding.MenuLink.dtos.CustomerCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.CustomerResponseDTO;
import com.menulink.custocoding.MenuLink.mappers.CustomerMapper;
import com.menulink.custocoding.MenuLink.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;


    public CustomerResponseDTO saveCustomer(
            CustomerCreateDTO request
    ){
        var customer = customerMapper.toCustomerDTO(request);
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerResponseDTO(savedCustomer);
    }


}
