package com.example.convoconvert.Repository;

import com.example.convoconvert.Entity.Calls;
import com.example.convoconvert.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallsInterfaceRepository extends JpaRepository<Calls, Long> {
}
