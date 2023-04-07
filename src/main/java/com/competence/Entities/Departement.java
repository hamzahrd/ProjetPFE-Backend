package com.competence.Entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departement_id",nullable = false, updatable = false)
    private Long iddepartement;
    private String Nomdep;
    private String CBU;
    private String TeamLeader;
    private String NombreEmloyee;
    private Long idfichepost;
    private long idmatrice;

    @OneToMany
    private List<Employee> employees;

    @OneToMany
    private List<FichePost> fichePosts;
    @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="matricecmpt_id")
    private Matricecmpt matricecmpt;
}
