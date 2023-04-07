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
@Table(name = "Dossiercmpt")
public class Dossiercmpt {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "dossier_id",nullable = false, updatable = false)
   private Long dossier_id;
    private int niveau;


    @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="employee_id")
    private Employee employee;
//

    @OneToMany
    private List<Dictionnairecmpt> dictionnairecmpts;

////    @OneToMany(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
////    @JoinColumn(name="competence_id")
////    private Dictionnairecmpt dictionnairecmpt;
////    @OneToMany(mappedBy = "dossiercmpt")
////    private List<Dictionnairecmpt> dictionnairecmptts;
//
}
