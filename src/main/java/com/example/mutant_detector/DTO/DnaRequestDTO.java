package com.example.mutant_detector.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
La clase 'DnaRequestDTO' se utiliza para recibir y representar las secuencias de ADN que se envían desde el cliente
en el cuerpo de una solicitud HTTP en el método 'detectMutant'. Esta clase encapsula el arreglo de secuencias de ADN (String[] dna),
para su posterior procesamiento
*/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnaRequestDTO {
    private String[] dna;
}
