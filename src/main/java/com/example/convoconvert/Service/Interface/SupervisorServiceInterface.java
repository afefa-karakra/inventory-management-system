package com.example.convoconvert.Service.Interface;

import com.example.convoconvert.DTO.EmployeeDTO;
import com.example.convoconvert.DTO.SupervisorDTO;
import com.example.convoconvert.DTO.SupervisorDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SupervisorServiceInterface {

    SupervisorDTO getSupervisorById (long id);
    SupervisorDTO createSupervisor (SupervisorDTO supervisorDTO);
    SupervisorDTO updateSupervisor (SupervisorDTO supervisorDTO , long id);
    SupervisorDTO updateFieldsOfSupervisor (long id , Map<String , Optional> map);
    List<SupervisorDTO> getAllSupervisor();
    void deleteSupervisorById (long id);
}
