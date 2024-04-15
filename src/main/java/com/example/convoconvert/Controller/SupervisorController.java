package com.example.convoconvert.Controller;


import com.example.convoconvert.DTO.EmployeeDTO;
import com.example.convoconvert.DTO.SupervisorDTO;
import com.example.convoconvert.Exception.BadRequestException;
import com.example.convoconvert.Service.Interface.EmployeeServiceInterface;
import com.example.convoconvert.Service.Interface.SupervisorServiceInterface;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorServiceInterface supervisorServiceInterface;
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/get")
    public ResponseEntity<SupervisorDTO> getSupervisorById(@RequestParam long id){
        return ResponseEntity.ok(supervisorServiceInterface.getSupervisorById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupervisorDTO>> getAllSupervisor (){

        return ResponseEntity.ok().body(supervisorServiceInterface.getAllSupervisor());
    }

    @PostMapping
    public ResponseEntity<SupervisorDTO> createSupervisor (@Valid @RequestBody SupervisorDTO supervisorDTO) {

        if (supervisorDTO.getName() ==null) {
            log.error("Cannot have an name {}", supervisorDTO);
            throw new BadRequestException(EmployeeController.class.getSimpleName(),
                    "Name");
        }
        return ResponseEntity.ok().body(supervisorServiceInterface.createSupervisor(supervisorDTO));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<SupervisorDTO> updateSupervisor
            (@Valid @RequestBody SupervisorDTO supervisorDTO
                    , @PathVariable(name = "id") long id) {

        return new ResponseEntity<>(supervisorServiceInterface.updateSupervisor(supervisorDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupervisor (@PathVariable(name = "id") long id){
        supervisorServiceInterface.deleteSupervisorById(id);
        return new ResponseEntity<>("Delete Supervisor was successfully!", HttpStatus.OK);
    }
}
