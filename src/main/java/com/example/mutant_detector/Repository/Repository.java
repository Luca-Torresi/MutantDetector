package com.example.mutant_detector.Repository;

import com.example.mutant_detector.Entities.DnaRecord;
import org.springframework.data.jpa.repository.JpaRepository;

//Clase que permite realizar operaciones CRUD sobre la entidad 'DnaRecord' en la base de datos
public interface Repository extends JpaRepository<DnaRecord, Long> {
    long countByIsMutant(boolean isMutant);
}

