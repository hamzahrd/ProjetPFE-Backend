package com.competence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(	name = "employee"//        uniqueConstraints = {
////                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
    )
    public class Employee implements Serializable {
        @Id
        //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "employee_id",nullable = false, updatable = false)
        private Long IdEmployee;
        private String nmatricule;
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

        @Column(name = "N+1")
        private String Nplusone;
        @Column(name = "N+2")
        private String Nplustwo;

        private String password;

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
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(	name = "employee_roles",
                joinColumns = @JoinColumn(name = "employee_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();
        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

    }


