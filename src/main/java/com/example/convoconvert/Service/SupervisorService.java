package com.example.convoconvert.Service;


import com.example.convoconvert.DTO.EmployeeDTO;
import com.example.convoconvert.DTO.SupervisorDTO;
import com.example.convoconvert.Entity.Employee;
import com.example.convoconvert.Entity.Supervisor;
import com.example.convoconvert.Exception.ResourceNotFoundException;
import com.example.convoconvert.Repository.EmployeeInterfaceRepository;
import com.example.convoconvert.Repository.SupervisorInterfaceRepository;
import com.example.convoconvert.Service.Interface.SupervisorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupervisorService implements SupervisorServiceInterface {
    @Autowired
    private SupervisorInterfaceRepository supervisorInterfaceRepository;

    @Override
    public SupervisorDTO getSupervisorById(long id) {
        Supervisor employee = supervisorInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supervisor", "id", id));
        return mapToDTO(employee);
    }

    @Override
    public List<SupervisorDTO> getAllSupervisor() {
        List<Supervisor> supervisors = supervisorInterfaceRepository.findAll();
        return supervisors.stream().map(supervisor -> mapToDTO(supervisor))
                .collect(Collectors.toList());
    }

    @Override
    public SupervisorDTO createSupervisor(SupervisorDTO supervisorDTO) {
        Supervisor supervisores = mapToEntity(supervisorDTO);
        Supervisor newSupervisor = supervisorInterfaceRepository.save(supervisores);

        SupervisorDTO supervisorResponse = mapToDTO(newSupervisor);
        return supervisorResponse;
    }

    @Override
    public SupervisorDTO updateSupervisor(SupervisorDTO supervisorDTO, long id) {
        Supervisor supervisor = supervisorInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supervisor", "id", id));

        supervisor.setName(supervisorDTO.getName());
        supervisor.setPhoneNumber(supervisorDTO.getPhoneNumber());

        Supervisor updateSupervisor = supervisorInterfaceRepository.save(supervisor);
        return mapToDTO(updateSupervisor);
    }

    @Override
    public SupervisorDTO updateFieldsOfSupervisor(long id, Map<String, Optional> map) {
        Supervisor supervisor = supervisorInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supervisor", "id", id));


        for (Map.Entry<String , Optional> hm : map.entrySet()){
            String keyFromMap = hm.getKey();

            if(keyFromMap.equals("name")){
                String obj = hm.getValue().toString();

                supervisor.setName(obj);
            }
            if(keyFromMap.equals("PhoneNumber")){
                Integer obj = Integer.valueOf(String.valueOf(hm.getValue()));

                supervisor.setPhoneNumber(obj);
            }
        }
        Supervisor updateSupervisor = supervisorInterfaceRepository.save(supervisor);
        return mapToDTO(updateSupervisor);
    }

    @Override
    public void deleteSupervisorById(long id) {
        Supervisor supervisor = supervisorInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supervisor", "id", id));
        supervisorInterfaceRepository.delete(supervisor);
    }
    private Supervisor mapToEntity (SupervisorDTO supervisorDTO){
        Supervisor supervisor = new Supervisor();
        supervisor.setName(supervisorDTO.getName());
        supervisor.setPhoneNumber(supervisorDTO.getPhoneNumber());

        return supervisor;
    }
    private SupervisorDTO mapToDTO(Supervisor supervisor){
        SupervisorDTO supervisorDTO = new SupervisorDTO();
        supervisorDTO.setId(supervisor.getId());
        supervisorDTO.setName(supervisor.getName());
        supervisorDTO.setPhoneNumber(supervisor.getPhoneNumber());

        return  supervisorDTO;
    }
}
