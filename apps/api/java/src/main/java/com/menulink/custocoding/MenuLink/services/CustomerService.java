package com.menulink.custocoding.MenuLink.services;


import com.menulink.custocoding.MenuLink.dtos.CustomerCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.CustomerResponseDTO;
import com.menulink.custocoding.MenuLink.mappers.CustomerMapper;
import com.menulink.custocoding.MenuLink.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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


    public CustomerResponseDTO getCustomerById(
            String id
    ){
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer not found"
                ));
    }

    public List<CustomerResponseDTO> getAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponseDTO)
                .collect(Collectors.toList())
                ;
    }

    public void deleteCustomer(
            String id
    ){
        customerRepository.deleteById(id);
    }


}
