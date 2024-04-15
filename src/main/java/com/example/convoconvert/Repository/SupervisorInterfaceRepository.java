package com.example.convoconvert.Repository;

import com.example.convoconvert.Entity.Employee;
import com.example.convoconvert.Entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorInterfaceRepository extends JpaRepository<Supervisor, Long> {
}
