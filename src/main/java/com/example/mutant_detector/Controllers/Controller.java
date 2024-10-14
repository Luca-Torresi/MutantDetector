package com.example.mutant_detector.Controllers;

import com.example.mutant_detector.DTO.DnaRequestDTO;
import com.example.mutant_detector.DTO.RandomDnaDTO;
import com.example.mutant_detector.DTO.StatsDTO;
import com.example.mutant_detector.Entities.DnaRecord;
import com.example.mutant_detector.Exceptions.InvalidDnaException;
import com.example.mutant_detector.Repository.Repository;
import com.example.mutant_detector.Service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/mutant")
public class Controller {
    private final Repository repository;
    private final Service service;

    @Autowired
    public Controller(Repository repository, Service service) {
        this.repository = repository;
        this.service = service;
    }

    //El método 'detectMutant' recibe una solicitud con una secuencia de ADN en formato JSON y verifica si esta secuencia corresponde a un mutante
    @PostMapping("/")
    public ResponseEntity<String> detectMutant(@RequestBody DnaRequestDTO request) {
        String[] dna = request.getDna();

        //Verificamos que la secuencia de AND recibida sea válida
        if(!service.isValid(dna)){
            throw new InvalidDnaException("El ADN ingresado es inválido");
        }

        //Llamamos al método 'isMutant()' de la clase Service, y guardamos el valor devuelto por el método en la variable 'value'
        boolean value = service.isMutant(dna);

        //Convertimos el arreglo con las secuencias de ADN en un String para poder guardar la información en la base de datos
        ObjectMapper objectMapper = new ObjectMapper();
        String dnaSequence;
        try {
            dnaSequence = objectMapper.writeValueAsString(dna);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Creamos una instancia de la clase 'DnaRecord' con los valores obtenidos
        DnaRecord dnaRecord = DnaRecord.builder()
                .dna(dnaSequence)
                .isMutant(value)
                .build();
        //Persistimos en la base de datos el objeto creado
        repository.save(dnaRecord);

        //Finalmente, devolvemos una respuesta HTTP 200  o un HTTP 403 con un mensaje indicando si el ADN corresponde a un mutante
        if(value){
            return ResponseEntity.ok("Mutant detected");
        } else{
            return new ResponseEntity<>("Not a mutant", HttpStatus.FORBIDDEN);
        }
    }

    //El método 'getStats' se encarga de recuperar y calcular las estadísticas de las secuencias de ADN almacenadas en la base de datos
    @GetMapping("/stats")
    public ResponseEntity<StatsDTO> getStats() {
        long countMutantDna = repository.countByIsMutant(true);
        long countHumanDna = repository.countByIsMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;

        //Creamos una instancia de la clase 'StatsDTO' la cual incluye el conteo de ADN mutante y no mutante, así como también la proporción
        StatsDTO statsDTO = StatsDTO.builder()
                .countMutantDna(countMutantDna)
                .countHumanDna(countHumanDna)
                .ratio(ratio)
                .build();

        //Dicho objeto es devuelto como respuesta al cliente
        return ResponseEntity.ok(statsDTO);
    }

    //El método 'generateRandomDna' genera un ADN de manera aleatoria para luego guardarlo en la base de datos y por último es envíado al cliente
    @PostMapping("/generateRandomDna")
    public ResponseEntity<RandomDnaDTO> generateRandomDna() {
        //El siguiente método genera de manera aleatoria un ADN el cual es guardado en la variable 'dna'
        String[] dna = service.generateRandomDna();
        //Evaluamos si el ADN es mutante o no
        boolean value = service.isMutant(dna);

        //Creamos un objeto de tipo RandomDnaDTO el cual contiene la información que se le envía al cliente sobre el ADN generado
        RandomDnaDTO randomDnaDTO = RandomDnaDTO.builder()
                .dna(dna)
                .isMutant(value)
                .build();

        //Convertimos el arreglo con las secuencias de ADN en un String para poder guardar la información en la base de datos
        ObjectMapper objectMapper = new ObjectMapper();
        String dnaSequence;
        try {
            dnaSequence = objectMapper.writeValueAsString(dna);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Creamos una instancia de DnaRecord con los valores correspondientes
        DnaRecord dnaRecord = DnaRecord.builder()
                .dna(dnaSequence)
                .isMutant(value)
                .build();
        //Persistimos en la base de datos el objeto creado anteriormente
        repository.save(dnaRecord);

        //Por último, enviamos el objeto creado anteriormente al cliente
        return ResponseEntity.ok(randomDnaDTO);
    }
}

