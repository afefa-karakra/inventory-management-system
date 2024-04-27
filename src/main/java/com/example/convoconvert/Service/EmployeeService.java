package com.example.convoconvert.Service;

import com.example.convoconvert.DTO.EmployeeDTO;
import com.example.convoconvert.Entity.Employee;
import com.example.convoconvert.Exception.ResourceNotFoundException;
import com.example.convoconvert.Repository.EmployeeInterfaceRepository;
import com.example.convoconvert.Service.Interface.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeInterfaceRepository employeeInterfaceRepository;
    @Override
    public EmployeeDTO getEmployeeById(long id) {

        Employee employee = employeeInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return mapToDTO(employee);
    }
    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeInterfaceRepository.findAll();
        return employees.stream().map(employee -> mapToDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        // convert DTO to entity
        Employee employee = mapToEntity(employeeDTO);
        Employee newEmployee = employeeInterfaceRepository.save(employee);

        // convert entity to DTO
        EmployeeDTO emloyeeResponse = mapToDTO(newEmployee);
        return emloyeeResponse;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, long id) {
        Employee employee = employeeInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        employee.setFullName(employeeDTO.getFullName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());

        Employee updateEmployee = employeeInterfaceRepository.save(employee);
        return mapToDTO(updateEmployee);
    }


    @Override
    public void deleteEmployeeById(long id) {

        Employee employee = employeeInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeInterfaceRepository.delete(employee);

    }

    private Employee mapToEntity (EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setFullName(employeeDTO.getFullName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());

        return  employee;

    }

    private EmployeeDTO mapToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());

        return  employeeDTO;
    }

}