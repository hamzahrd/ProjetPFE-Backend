package com.competence.Repositories;

import com.competence.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {


 @Query(value = "SELECT * FROM employee e WHERE e.employee_id IN ( SELECT nplusone FROM employee)", nativeQuery = true)
 List<Employee> findAllManagers();

 @Query (value = "SELECT * FROM employee e WHERE e.nplusone IS NULL",nativeQuery = true)
 List<Employee> findCEOS();

 @Query(value = "with RECURSIVE subordinates AS (\n" +
         "         SELECT * FROM employee WHERE Nplusone = :employee_id\n" +
         "         UNION ALL\n" +
         "         SELECT e.* FROM employee e\n" +
         "         JOIN subordinates s ON s.employee_id = e.Nplusone)\n" +
         "\t\t SELECT * FROM subordinates", nativeQuery = true)
 List<Employee> findAllSubordinates(String employee_id);
 Optional<Employee> findByUsername(String username);


 Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

 Optional<Employee> findByEmail(String email);



}
