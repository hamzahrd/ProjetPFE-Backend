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

@Table(name = "FichePost")
public class FichePost {
    @Id
    //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fichepost_id",nullable = false, updatable = false)

    private Long idfichepost;
    private String nomfichepost;
    private int niveaurequis;

    @OneToMany
    private List<Dictionnairecmpt> dictionnairecmpts;
    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="departement_id")
    private Departement departement;
}
