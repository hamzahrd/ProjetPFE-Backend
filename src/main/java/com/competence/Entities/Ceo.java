package com.competence.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Table
//@Entity
//
//@DiscriminatorValue("Ceo")
public class Ceo {

    public Ceo(){
        super();
    }
//    private List<Employee> subordinateList;
//
//    public List<Employee> getSubordinateList() {
//        return subordinateList;
//    }

//    private Set<Role> roles = new HashSet<>();
//    @Override
//    public void setRoles(Set<Role> roles) {
//        roles.add(new Role(ERole.ROLE_CEO));
//    }
}
