package com.example.mutant_detector;

import com.example.mutant_detector.Service.Service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
La clase 'ServiceTests' se utiliza para realizar pruebas unitarias sobre la lógica de negocio del servicio que determina
si una secuencia de ADN es mutante o no, así como para validar la estructura de las secuencias de ADN.
*/

public class ServiceTests {
    private final Service service = new Service();

    @Test
    public void testIsMutant_withMutantDna() {
        String[] mutantDna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(service.isMutant(mutantDna), "El ADN debería ser identificado como muntante");
    }

    @Test
    public void testIsMutant_withHumanDna() {
        String[] humanDna = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };
        assertFalse(service.isMutant(humanDna), "El ADN debería ser identificado como no mutante");
    }

    @Test
    public void testIsValid_withValidDna(){
        String[] validDna = {
                "CTTGAT",
                "GATTCA",
                "TAAACG",
                "GCAATC",
                "GGGACT",
                "CCTCAC"
        };
        assertTrue(service.isValid(validDna),"El ADN derbería ser válido");
    }

    @Test
    public void testIsValid_withInvalidDna(){
        String[] invalidDna = {
                "EEETCA",
                "CTTGAT",
                "AACTAC",
                "TAAACG",
                "GCAATC",
                "GGGACT"
        };
        assertFalse(service.isValid(invalidDna),"El ADN debería no ser válido");
    }
}
