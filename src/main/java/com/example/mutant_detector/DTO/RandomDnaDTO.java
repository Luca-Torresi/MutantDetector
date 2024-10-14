package com.example.mutant_detector.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
La clase 'RandomDnaDTO' se utiliza para encapsular y devolver la información relacionada con una secuencia de ADN generada aleatoriamente.
Este DTO es enviado al cliente como respuesta, proporcionando tanto la secuencia de ADN como el resultado de la evaluación mutante.
*/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RandomDnaDTO {
    private String[] dna;
    private boolean isMutant;
}