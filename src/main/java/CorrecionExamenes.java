import java.io.*;
import java.util.*;

public class CorrecionExamenes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta");
        String ruta = sc.nextLine();

        System.out.println("Introduce la respuesta correcta");
        String respuestaCorrecta = sc.nextLine();

        String linea;
        String lineaActual;
        String alumnoActual;
        Map<String, String> correciones = new HashMap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

            String respuestaMasPuntuacion;

            while ((linea = lector.readLine()) != null) {
                if (linea.contains(" ")) {
                    String[] partes = linea.split(" ", 2);

                    if (partes.length == 2) {
                        alumnoActual = partes[0].trim();
                        lineaActual = partes[1].trim();

                        respuestaMasPuntuacion = lineaActual + " = " + calcularPuntuacion(lineaActual, respuestaCorrecta).toString();

                        correciones.put(alumnoActual, respuestaMasPuntuacion);
                    } else {
                        System.err.println("Línea mal formada: " + linea);
                    }
                } else {
                    System.err.println("Línea sin espacio entre alumno y respuesta: " + linea);
                }
            }

        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, false))) {

            for (Map.Entry<String, String> alumno : correciones.entrySet()) {
                escritor.write(alumno.getKey() + " " + alumno.getValue());
                escritor.newLine();
            }

            System.out.println("Escritura realizada.");
        } catch (IOException e) {
            System.err.println("No se puede crear el archivo en el lugar indicado: " + e.getMessage());
        }

    }

    static Double calcularPuntuacion(String texto, String respuestaCorrecta) {

        Double puntuacion = 0.0;

        for (int i = 0; i < texto.length(); i++) {
            if (i < respuestaCorrecta.length()) {
                if (texto.charAt(i) == respuestaCorrecta.charAt(i)) {
                    puntuacion += 0.5;
                } else if (texto.charAt(i) == ' ') {
                    puntuacion += 0.0;
                } else {
                    puntuacion -= 0.15;
                }
            }
        }
        return puntuacion;
    }
}