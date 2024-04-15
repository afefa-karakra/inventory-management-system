package com.example.convoconvert.Repository;

import com.example.convoconvert.Entity.Customer;
import com.example.convoconvert.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInterfaceRepository extends JpaRepository<Customer, Long> {
}
