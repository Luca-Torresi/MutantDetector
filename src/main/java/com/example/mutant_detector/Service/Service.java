package com.example.mutant_detector.Service;

import java.util.Random;

@org.springframework.stereotype.Service
public class Service {
    public static String nitrogenousBases[] = {"A","T","G","C"};
    public int dim = 6;

    //Lógica para verificar si el ADN enviado como argumento, corresponde a un mutante
    public boolean isMutant(String[] dna) {
        String[][] matrix = new String[dim][dim];

        //Pasamos la información del arreglo que contiene las secuencias de ADN a una matriz
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                matrix[i][j] = String.valueOf(dna[i].charAt(j));
            }
        }

        //Iniciamos un contador para los genes mutantes
        int mutantGenes = 0;

        //Se revisan las filas y las diagonales principales de la matriz, luego se rota 90° hacia la derecha y se repite el proceso
        //De este modo, se revisan también las columnas y diagonales opuestas
        for(int rotation=0; rotation<=1; rotation++){

            //Buscamos genes mutantes en todas las filas de la matriz
            for(int i=0; i<dim; i++){
                String valor1 = matrix[i][2];
                int counter=1;
                for(int j=3; j<=5; j++){
                    if(matrix[i][j].equals(valor1)){
                        counter++;
                    } else{
                        break;
                    }
                }
                switch(counter){
                    case 2:
                        if(matrix[i][1].equals(valor1) && matrix[i][0].equals(valor1)){
                            mutantGenes++;
                        }
                        break;
                    case 3:
                        if(matrix[i][1].equals(valor1)){
                            mutantGenes++;
                        }
                        break;
                    case 4:
                        mutantGenes++;
                        break;
                }
            }

            //Buscamos genes mutantes en las diagonales principales
            for(int k=-2; k<3; k++){
                int counter=1;
                for (int i=0; i<dim-1; i++) {
                    for (int j=0; j<dim-1; j++) {
                        if(i-j==k){
                            if(matrix[i][j].equals(matrix[i+1][j+1])){
                                counter++;
                            } else{
                                counter=1;
                            }
                            if(counter == 4){
                                mutantGenes++;
                            }
                        }
                    }
                }
            }

            //Si el bucle 'for' se encuentra en su primera iteración, llamamos al método que rota la matriz
            if(rotation==0){
                rotateMatrix(matrix);
            }
        }
        //Por último, el método devuelve 'true' si el ADN contiene más de un gen mutante
        return mutantGenes>1;
    }

    //Rotamos la matriz 90° hacia la derecha
    public void rotateMatrix(String[][] matrix) {
        for(int i=0; i<dim; i++) {
            for(int j=i; j<dim; j++) {
                String temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<dim; i++) {
            for(int j=0; j<dim/2; j++) {
                String temp = matrix[i][j];
                matrix[i][j] = matrix[i][dim-1-j];
                matrix[i][dim-1-j] = temp;
            }
        }
    }

    //El siguiente método completa de manera aleatoria el arreglo correspondiente al ADN
    public String[] generateRandomDna(){
        String[][] matrix = new String[dim][dim];

        int index;
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){

                index = new Random().nextInt(nitrogenousBases.length);
                matrix[i][j] = nitrogenousBases[index];
            }
        }

        String[] dna = new String[6];
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                dna[i] = String.join("", matrix[i]);
            }
        }
        return dna;
    }

    //Verifica si la secuencia de ADN es válida
    public boolean isValid(String[] dna) {
        if(dna[0].length() != dim){
            return false;
        }
        for(String strand : dna){
            if (strand.length() != dim || !strand.matches("[ATCG]+")) {
                return false;
            }
        }
        return true;
    }
}
