package com.example.mutant_detector.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//La clase 'DnaRecord' representa una entidad en la base de datos que almacena información sobre secuencias de ADN

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table
public class DnaRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dna;
    private boolean isMutant;
}

