package com.competence.Entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FicheEmployee")
public class FicheEmployee {
    @Id
    //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ficheemployee_id",nullable = false, updatable = false)
    private Long idficheemployee;
//    @Embedded
//    private FichePost fichePost;
//    @Embedded
//    private  Dossiercmpt dossiercmpt;

    @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="fichepost_id")
    private FichePost fichePost;
    @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="dossier_id")
    private Dossiercmpt dossiercmpt;
    @OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="employee_id")
    private Employee employee;


}
