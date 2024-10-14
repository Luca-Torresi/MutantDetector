package com.example.mutant_detector.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
La clase 'ErrorResponseDTO' se utiliza para estructurar y devolver mensajes de error de manera consistente cuando ocurre una excepción en la API.
Ayudando a los clientes a entender mejor el problema ocurrido.
*/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private String message;
}
