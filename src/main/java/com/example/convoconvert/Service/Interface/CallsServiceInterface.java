package com.example.convoconvert.Service.Interface;

import com.example.convoconvert.DTO.CallsDTO;
import com.example.convoconvert.DTO.EmployeeDTO;

import java.util.List;

public interface CallsServiceInterface {

    CallsDTO getCallById (long id);
    CallsDTO createCall (CallsDTO callsDTO);
    CallsDTO updateCall (CallsDTO callsDTO , long id);
    List<CallsDTO> getAllCalls();
    void deleteCallById (long id);
}
