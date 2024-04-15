package com.example.convoconvert.Service.Interface;

import com.example.convoconvert.DTO.SupervisorDTO;
import com.example.convoconvert.DTO.SupervisorDTO;

import java.util.List;

public interface SupervisorServiceInterface {

    SupervisorDTO getSupervisorById (long id);
    SupervisorDTO createSupervisor (SupervisorDTO supervisorDTO);
    SupervisorDTO updateSupervisor (SupervisorDTO supervisorDTO , long id);
    List<SupervisorDTO> getAllSupervisor();
    void deleteSupervisorById (long id);
}
