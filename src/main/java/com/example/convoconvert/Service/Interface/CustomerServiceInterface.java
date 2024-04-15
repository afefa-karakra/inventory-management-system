package com.example.convoconvert.Service.Interface;

import com.example.convoconvert.DTO.CustomerDTO;
import com.example.convoconvert.DTO.CustomerDTO;

import java.util.List;

public interface CustomerServiceInterface {

    CustomerDTO getCustomerById (long id);
    CustomerDTO createCustomer (CustomerDTO customerDTO);
    CustomerDTO updateCustomer (CustomerDTO customerDTO , long id);
    List<CustomerDTO> getAllCustomer();
    void deleteCustomerById (long id);
}
