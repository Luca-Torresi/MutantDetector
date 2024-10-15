# MutantDetector
Programación3 - 1er Parcial

Esta API tiene como objetivo determinar si un humano es mutante o no basándose en su secuencia de ADN.

CÓMO PROBAR ENDPOINTS
1. EN RENDER (solo se podrá verificar el endpoint "/stats")
Ingresar a la URL: https://mutantdetector-ryoi.onrender.com/mutant/stats

2. EN POSTMAN
→ Endpoint "/stats"
Crear una request de tipo "GET" y colocar como URL: https://mutantdetector-ryoi.onrender.com/mutant/stats. Presionar "SEND".

→ Endpoint "/mutant"
Crear una request de tipo "POST" y colocar como URL: https://mutantdetector-ryoi.onrender.com/mutant/. En el apartado de "Body", ir a la opción RAW y colocar un JSON. Presionar "SEND".

→ Endpoint "/generateRandomDna"
Crear una request de tipo "POST" y colocar como URL: https://mutantdetector-ryoi.onrender.com/mutant/generateRandomDna.

---- JSONs DE PRUEBA ----
NO MUTANTE:
{
    "dna": [
        "CCCTGC",
        "ACTACT",
        "ATACTT",
        "CGAACG",
        "ACTTTT",
        "GTGCCT"
    ],
    "mutant": false
}

MUTANTE:
{
    "dna": [
        "CTAATT",
        "TGCAGA",
        "GGGTCC",
        "ATTGTT",
        "ATACGC",
        "TTATTC"
    ],
    "mutant": true
}

