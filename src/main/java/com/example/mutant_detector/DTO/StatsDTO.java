package com.example.mutant_detector.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
La clase StatsDTO se utiliza para encapsular y devolver las estadísticas relacionadas con el análisis de ADN, incluyendo
el conteo de secuencias de ADN mutante, no mutante, y la proporción entre ambos. Esta clase organiza los datos de manera
estructurada para ser enviados al cliente como respuesta.
*/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatsDTO {
    private long countMutantDna;
    private long countHumanDna;
    private double ratio;
}