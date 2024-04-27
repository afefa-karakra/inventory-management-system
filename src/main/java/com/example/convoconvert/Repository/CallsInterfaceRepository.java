package com.example.convoconvert.Repository;

import com.example.convoconvert.Entity.Calls;
import com.example.convoconvert.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CallsInterfaceRepository extends JpaRepository<Calls, Long> {

    @Query("SELECT c FROM Calls c WHERE c.id = :id AND c.date = :date")
    List<Calls> findByDate (@Param("id") long id, @Param("date") Date date);
}
