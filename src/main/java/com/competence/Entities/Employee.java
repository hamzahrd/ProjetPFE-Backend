package com.competence.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DiscriminatorFormula;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
//    @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "clazz_"})
    @Table(	name = "employee"//        uniqueConstraints = {
////                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
    )
//    @DiscriminatorFormula("CASE "
//            + "WHEN Nplusone IS NULL THEN 'Ceo' "
//            + "ELSE 'NormalEmployee' "
//            + "END"
//    )
    public  class Employee implements Serializable {
        @Id
        //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "employee_id",nullable = false, updatable = false)
        private String IdEmployee;
//        private String nmatricule;
        private String username;
        private String prenom;
        private String nom;
        @Column(name="email")
        private String email;

        private char sexe;


        @Column(name = "date_naissance")
        private LocalDate datenaissance;
        @Column(name = "date_embauche")
        private LocalDate dateembauche;
        private String function;
        private String domaine;
        private String Nplusone;

        private String Nplustwo;

        private String password;
//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "N+1")
//        private Employee superior;
//          @ManyToOne(fetch = FetchType.LAZY)
//          @JoinColumn(name = "N+1", referencedColumnName = "employee_id", insertable = false, updatable = false)
//          private Employee superior;
        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "Nplusone", insertable = false, updatable = false)
        private Employee manager;

        @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Employee> subordinates=new ArrayList<>();
        @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
        @JoinColumn(name="dossier_id")
        private Dossiercmpt dossiercmpt;
        @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
        @JoinColumn(name="ficheemployee_id")
        private FicheEmployee ficheEmployee;
        @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
        @JoinColumn(name="matrice_id")
        private Matricecmpt matricecmpt;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id")
        private Departement departement;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(	name = "employee_roles",
                joinColumns = @JoinColumn(name = "employee_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles=new HashSet<>();
        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

//        @PostLoad
//        public void setRole() {
//            if (this.Nplusone == null) {
//                roles.clear();
//                roles.add(new Role(ERole.ROLE_CEO));
//            } else if (this instanceof Manager) {
//                roles.clear();
//                roles.add(new Role(ERole.ROLE_MANAGER));
//            } else if (this instanceof NormalEmployee){
//                roles.clear();
//                roles.add(new Role(ERole.ROLE_NORMALEMPLOYEE));
//            }
//        }


    }


