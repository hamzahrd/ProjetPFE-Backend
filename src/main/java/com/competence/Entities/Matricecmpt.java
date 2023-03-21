package com.competence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matricecmpt")
public class Matricecmpt {

        @Id
        //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "matrice_id",nullable = false, updatable = false)
        private Long idmatrice;
        @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
        @JoinColumn(name="departement_id")
        private Departement departement;
        @OneToMany
        private List<Dictionnairecmpt> dictionnairecmpts;
        @OneToMany
        private List<Dossiercmpt> dossiercmpts;
        @OneToMany
        private List<FichePost> fichePosts;
        @OneToMany
        private List<Employee> employees;


//        @Embedded
//        @AttributeOverride(name = "competence_id", column = @Column(name = "competence_id"))
//        @AttributeOverride(name = "nomcompetence", column = @Column(name = "nomcompetence"))
//        private Dictionnairecmpt dictionnairecmpt;
//        @Embedded
//        @AttributeOverride(name = "categorie_id", column = @Column(name = "categorie_id"))
//        @AttributeOverride(name = "nomcategorie", column = @Column(name = "nomcategorie"))
//        private Categorie categorie;
//        @Embedded
//        private FichePost fichePost;
//        @AttributeOverride(name = "dossier_id", column = @Column(name = "dossier_id"))
//        @AttributeOverride(name = "username", column = @Column(name = "username"))
//        @Embedded
//        private Dossiercmpt dossiercmpt;
//
//        @Embedded
//        @AttributeOverride(name = "Nmatricule", column = @Column(name = "Nmatricule"))
//        @AttributeOverride(name = "niveau", column = @Column(name = "niveau"))
//
//        private Employee employee;
//
//        @Embedded
//        @AttributeOverride(name = "departement_id", column = @Column(name = "departement_id"))
//        @AttributeOverride(name = "Nomdep", column = @Column(name = "Nomdep"))
//        private Departement departement;





}