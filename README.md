<h1>MutantDetector</h1>
<p>Programación3 - 1er Parcial</p>

<p>Esta API tiene como objetivo determinar si un humano es mutante o no basándose en su secuencia de ADN.</p>

<h2>CÓMO PROBAR ENDPOINTS</h2>

<h3>1. EN RENDER (solo se podrá verificar el endpoint "/stats")</h3>
<p>Ingresando al siguiente URL, se puede ver cuantos ADN en la base de datos corresponden a mutantes, cuantos a humanos y la relación entre estas cantidades.<br />
<a href="https://mutantdetector-ryoi.onrender.com/mutant/stats">https://mutantdetector-ryoi.onrender.com/mutant/stats</a></p>

<h3>2. EN POSTMAN</h3>

<h4>→ Endpoint "/stats"</h4>
<p>Crear una request de tipo 'GET', colocar el siguiente URL y luego presionar 'SEND'.<br />
<a href="https://mutantdetector-ryoi.onrender.com/mutant/stats">https://mutantdetector-ryoi.onrender.com/mutant/stats</a></p>

<h4>→ Endpoint "/mutant"</h4>
<p>Crear una request de tipo 'POST' y colocar el siguiente URL. En el apartado 'Body', seleccionar la opción RAW y colocar un JSON de prueba. Por último, presionar "SEND".<br />
<a href="https://mutantdetector-ryoi.onrender.com/mutant/">https://mutantdetector-ryoi.onrender.com/mutant/</a>. </p>

<h4>→ Endpoint "/generateRandomDna"</h4>
<p>Mediante la siguiente request, se generan de manera aleatoria las secuencias del ADN, luego se verifica si corresponde a un mutante o no, y se guarda en la base de datos. Para ello se debe crear una request de tipo 'POST' y colocar el siguiente URL.<br />    
<a href="https://mutantdetector-ryoi.onrender.com/mutant/generateRandomDna">https://mutantdetector-ryoi.onrender.com/mutant/generateRandomDna</a>.</p>

<h3>---- JSONs DE PRUEBA ----</h3>

<h4>NO MUTANTE:</h4>
<pre>
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
</pre>

<h4>MUTANTE:</h4>
<pre>
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
</pre>
