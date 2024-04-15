package com.example.convoconvert.Service.Interface;

import com.example.convoconvert.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeServiceInterface {
    EmployeeDTO getEmployeeById (long id);
    EmployeeDTO createEmployee (EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee (EmployeeDTO employeeDTO , long id);
    List<EmployeeDTO> getAllEmployee();
    void deleteEmployeeById (long id);

}
