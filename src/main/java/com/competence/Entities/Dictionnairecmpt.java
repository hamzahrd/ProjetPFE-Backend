package com.competence.Entities;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Dictionnairecmpt")

public class Dictionnairecmpt {
    @Id
    //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "competence_id",nullable = false, updatable = false)
    private Long idcompetence;
    private String nomcompetence;
    private String nomcategorie;
    private String defcomptience;



//    @OneToMany(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
//    private List<Dossiercmpt> dossiercmpts;


////    @OneToMany(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
////    private List<FichePost> fichePosts;



}
