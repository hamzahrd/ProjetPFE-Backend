package com.competence.Services;

import com.competence.Entities.*;
import com.competence.Repositories.EmployeeRepository;
import com.competence.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.PostLoad;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean updatePassword(String email, String oldPass, String newPass) {
        Optional<Employee> opt = this.employeeRepo.findByEmail(email);
        Employee employee;
        if (opt.isPresent()) {
            employee = opt.get();

            if (passwordEncoder.matches(oldPass, employee.getPassword())) {
                employee.setPassword(passwordEncoder.encode(newPass));
                this.employeeRepo.save(employee);
                return true;
            }

        }
        return false;
    }

//    public void assignRolesToEmployees() {
//        List<Employee> employees = employeeRepo.findAll();
//        for (Employee employee : employees) {
//            Role role = new Role();
//            if (employee instanceof Ceo) {
//                role = roleRepository.findByName(ERole.ROLE_CEO);
//                employee.getRoles().add(role);
//            } else if (employee instanceof Manager) {
//                role = roleRepository.findByName(ERole.ROLE_MANAGER);
//                employee.getRoles().add(role);
//            } else if (employee instanceof NormalEmployee) {
//                role = roleRepository.findByName(ERole.ROLE_NORMALEMPLOYEE);
//                employee.getRoles().add(role);
//            }
////            if (role != null) {
////                employee.getRoles().add(role);
//                employeeRepo.save(employee);
//            }
//        }
//    }

//    public boolean updatePassword(String email, String oldPass, String newPass) {
//        Optional<Employee> opt = this.employeeRepo.findByEmail(email);
//        Employee employee;
//        if (opt.isPresent()) {
//            employee = opt.get();
//            if (passwordEncoder.matches(oldPass, employee.getPassword())) {
//                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//                String hashedPassword = bCryptPasswordEncoder.encode(newPass);
//                employee.setPassword(hashedPassword);
//                this.employeeRepo.save(employee);
//                return true;
//            }
//        }
//        return false;
//    }
    public void assignRolesToEmployees() {
        List<Employee> ceos = employeeRepo.findCEOS();
        List<Employee> managers = employeeRepo.findAllManagers();
        List <Employee> employees=employeeRepo.findAll();
//        Role ceoRole= new Role(ERole.ROLE_CEO);
//        Role managerRole=new Role(ERole.ROLE_MANAGER);
//        Role normalEmployeeRole=new Role(ERole.ROLE_NORMALEMPLOYEE);
        Role ceoRole = roleRepository.findByName(ERole.ROLE_CEO);
        Role managerRole = roleRepository.findByName(ERole.ROLE_MANAGER);
        Role normalEmployeerole=roleRepository.findByName(ERole.ROLE_NORMALEMPLOYEE);

        for (Employee employee : employees) {
            employee.getRoles().add(normalEmployeerole);
            employeeRepo.save(employee);
        }

        for (Employee ceo : ceos) {
            ceo.getRoles().add(ceoRole);
            employeeRepo.save(ceo);
        }

        for (Employee manager : managers) {

                manager.getRoles().add(managerRole);
                employeeRepo.save(manager);
            }


//        for (Employee normalEmployee : normalEmployees) {
//            normalEmployee.getRoles().add(normalEmployeeRole);
//            employeeRepository.save(normalEmployee);
//        }
    }

    public List<Employee> findSubordinates(String Nplusone){
        return employeeRepo.findAllSubordinates(Nplusone);
    }


 }
