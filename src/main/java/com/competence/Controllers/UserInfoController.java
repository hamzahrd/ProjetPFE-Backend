package com.competence.Controllers;

import com.competence.Entities.Employee;
import com.competence.Entities.Role;
import com.competence.Repositories.EmployeeRepository;
import com.competence.Services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserInfoController
{
    @Autowired
    ServletContext context;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepo;
    @GetMapping(path = "/users")
    public List<Employee> getEmployee() {
        employeeService.assignRolesToEmployees();
        return employeeRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Employee findById(@PathVariable("id") String id) {
        return employeeRepo.findById(id).get();
    }



    @GetMapping(path = "/users/manager")
    public List<Employee> getManager() {
        return employeeRepo.findAllManagers();
    }
    @GetMapping(path = "/users/ceo")
    public List<Employee> getCEO() {
        return employeeRepo.findCEOS();
    }

    @GetMapping("/{id}/subordinates")

    public List<Employee> getSubordinates(@PathVariable String id) {
        return employeeService.findSubordinates(id);
    }
    @GetMapping("/users/roles")
    public List<String> getAllUserRoles() {
        List<Employee> employees = employeeRepo.findAll();
        List<String> roles = new ArrayList<>();
        for (Employee employee : employees) {
            for (Role role : employee.getRoles()) {
                roles.add(role.getName().name());
            }
        }
        return roles;
    }

    @PostMapping(path="/updatePassword")
    public ResponseEntity<Boolean> updatePassword(@RequestBody ObjectNode json
    ){
        String email;
        String oldPass;
        String newPass;


        try {
            email = new ObjectMapper().treeToValue(json.get("email"), String.class);
            oldPass = new ObjectMapper().treeToValue(json.get("oldPass"), String.class);
            newPass = new ObjectMapper().treeToValue(json.get("newPass"), String.class);

            boolean test = this.employeeService.updatePassword(email, oldPass, newPass);
            if(test)
                return new ResponseEntity<Boolean>(test, HttpStatus.OK);

        } catch (JsonProcessingException e) {
            System.out.println("Parsing Exception!!");
            e.printStackTrace();
            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);

        }
        return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);


    }




}
