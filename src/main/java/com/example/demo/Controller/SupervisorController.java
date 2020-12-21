package com.example.demo.Controller;

import com.example.demo.Model.Supervisor;
import com.example.demo.Repository.SupervisorRepository;
import com.example.demo.Service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupervisorController {
    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    SupervisorService supervisorService;


    //list of all supervisors
    @GetMapping("/supervisors")
    public ResponseEntity<List<Supervisor>> getAllAuthors(){
        return supervisorService.getAll();
    }

    //create supervisor
    @PostMapping("/supervisors")
    public ResponseEntity<Supervisor> createSupervisor(@RequestBody Supervisor supervisor){
        return supervisorService.createNewSupervisor(supervisor);
    }

    //delete supervisor by id
    @DeleteMapping("/supervisors/{supervisorId}")
    public ResponseEntity<HttpStatus> deleteSupervisor(@PathVariable("supervisorId") int supervisorId){
        return supervisorService.deleteSupervisor(supervisorId);
    }
}


