package com.ejercicio.estructuras;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




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
        res.append("<head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + //
                        "</head><body><ul class='list-group'>");

        for (int i = 1; i <= 10; i++) {
            res.append("<li class='list-group-item'>" + numero + " x " + i + " = " + (i * numero) + "</l1>");
        }

        res.append("</ul></body>");

        return res.toString();
    }
    
    @PostMapping("/promedioCalificaciones")
    public String ejercicio3(@RequestParam String calificaciones) {
        List<String> notaStrings = Arrays.asList(calificaciones.split(","));
        double notaTotal = notaStrings.stream().map(nota -> Double.parseDouble(nota)).reduce(0.0, (nota1, nota2) -> nota1 + nota2);
        double promedio = notaTotal / notaStrings.size();

        return "Has sacado un " + promedio + (promedio >= 5 ? ", has aprobado" : ", has suspendido");
    }
    
    @PostMapping("/calcularIMC")
    public String ejercicio4(@RequestParam double peso, @RequestParam double altura) {
        double imc = peso / (altura * altura);
        String res = "Tu IMC es " + String.format("%,.2f", imc) + ": "; // Formatea el double con dos decimales
        if (imc < 18.5) {
            res += "bajo peso";
        } else if (imc >= 18.5 && imc < 25) {
            res += "normal";
        } else if (imc >= 25 && imc < 30) {
            res += "sobrepeso";
        } else {
            res += "obesidad";
        }

        return res;
    }
}
