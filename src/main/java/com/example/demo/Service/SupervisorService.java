package com.example.demo.Service;

import com.example.demo.Model.Supervisor;
import com.example.demo.Repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

// list of all supervisors
    public ResponseEntity<List<Supervisor>> getAll() {
        try {
            List<Supervisor> supervisors = supervisorRepository.findAll();
            if (supervisors.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(supervisors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //create new supervisor
    public ResponseEntity<Supervisor> createNewSupervisor(@RequestBody Supervisor supervisor) {
        try {
            Supervisor supervisor1= supervisorRepository.save(supervisor);
            return new ResponseEntity<>(supervisor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //delete supervisor
    public ResponseEntity<HttpStatus> deleteSupervisor(@PathVariable("supervisorId") int supervisorId){
        try{
            supervisorRepository.deleteById(supervisorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


