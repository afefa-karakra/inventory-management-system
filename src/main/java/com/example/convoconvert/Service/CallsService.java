package com.example.convoconvert.Service;

import com.example.convoconvert.DTO.CallsDTO;
import com.example.convoconvert.Entity.Calls;
import com.example.convoconvert.Exception.ResourceNotFoundException;
import com.example.convoconvert.Repository.CallsInterfaceRepository;
import com.example.convoconvert.Service.Interface.CallsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CallsService implements CallsServiceInterface {

    @Autowired
    private CallsInterfaceRepository callsInterfaceRepository;

    @Override
    public CallsDTO getCallById(long id) {

        Calls calls = callsInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calls", "id", id));
        return mapToDTO(calls);
    }

    @Override
    public List<CallsDTO> getAllCalls() {

        List<Calls> callsList = callsInterfaceRepository.findAll();
        return callsList.stream().map(calls -> mapToDTO(calls))
                .collect(Collectors.toList());
    }

    @Override
    public CallsDTO createCall(CallsDTO callsDTO) {
        // convert DTO to entity
        Calls calls = mapToEntity(callsDTO);
        Calls newCall = callsInterfaceRepository.save(calls);

        // convert entity to DTO
        CallsDTO callResponse = mapToDTO(newCall);
        return callResponse;
    }

    @Override
    public CallsDTO updateCall(CallsDTO callsDTO, long id) {
        Calls calls = callsInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calls", "id", id));

        calls.setAudioText(callsDTO.getAudioText());
        calls.setDate(callsDTO.getDate());

        Calls updateCalls = callsInterfaceRepository.save(calls);
        return mapToDTO(updateCalls);
    }

    @Override
    public void deleteCallById(long id) {

        Calls calls = callsInterfaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calls", "id", id));
        callsInterfaceRepository.delete(calls);

    }

    @Override
    public List<CallsDTO> getListOfCalls(long id, Date date) {

        List<Calls> callsList = callsInterfaceRepository.findByDate(id, date);

        return callsList.stream().map(calls -> mapToDTO(calls))
                .collect(Collectors.toList());
    }

    private CallsDTO mapToDTO(Calls calls) {
        CallsDTO callsDTO = new CallsDTO();
        callsDTO.setId(calls.getId());
        callsDTO.setAudioText(calls.getAudioText());
        callsDTO.setDate(calls.getDate());

        return callsDTO;
    }

    private Calls mapToEntity(CallsDTO callsDTO) {
        Calls calls = new Calls();
        calls.setAudioText(callsDTO.getAudioText());
        calls.setDate(callsDTO.getDate());

        return calls;

    }
}