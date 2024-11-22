package com.ejercicio.estructuras;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ControladorEjercicios {
    
    @PostMapping("/parImpar")
    public String ejercicio1(@RequestParam int numero) {
        boolean esPar = numero % 2 == 0;
        return esPar ? "<h2>Es par</h2>" : "<h2>Es impar</h2>";
    }

    @PostMapping("/tablaMultiplicar")
    public String ejercicio2(@RequestParam int numero) {
        StringBuilder res = new StringBuilder();
        res.append("<ul>");

        for (int i = 1; i <= 10; i++) {
            res.append("<li>" + numero + " x " + i + " = " + (i * numero) + "</l1>");
        }

        res.append("</ul>");

        return res.toString();
    }
    
    @PostMapping("/promedioCalificaciones")
    public String ejercicio3(@RequestParam String calificaciones) {
        List<String> notaStrings = Arrays.asList(calificaciones.split(","));
        double notaTotal = notaStrings.stream().map(nota -> Double.parseDouble(nota)).reduce(0.0, (nota1, nota2) -> nota1 + nota2);
        double promedio = notaTotal / notaStrings.size();

        return promedio >= 5 ? "Has aprobado" : "Has suspendido";
    }
    
}
