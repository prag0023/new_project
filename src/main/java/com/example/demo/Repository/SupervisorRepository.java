package com.example.demo.Repository;

import com.example.demo.Model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Supervisor findSupervisorBySupervisorId(Integer supervisorId);
}
