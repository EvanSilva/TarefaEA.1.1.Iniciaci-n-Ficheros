import java.io.*;
import java.util.*;

public class CorrecionExamenes {

    // TTTFFFTTTFTFTFTFTFTF

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta");
        String ruta = sc.nextLine();

        System.out.println("Introduce la respuesta correcta");
        String respuestaCorrecta = sc.nextLine();

        String linea = "";
        String lineaActual = "";
        String alumnoActual = "";
        Map<String, String> correciones = new HashMap<>();

        try (BufferedReader lector = new BufferedReader(new
                FileReader("lineas.txt"));) {

            String respuestaMasPuntuacion = "";


            while ((linea=lector.readLine()) != null)

                lineaActual = linea.split(" ", 2)[1];
                alumnoActual = lineaActual.split(" ", 2)[0];
                respuestaMasPuntuacion = lineaActual + " = " + calcularPuntuacion(lineaActual, respuestaCorrecta).toString();
                correciones.put(alumnoActual, respuestaMasPuntuacion);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta,false));) {

            for(Map.Entry<String, String> alumno: ) {
                escritor.write(linea);
                escritor.newLine();
            }

            System.out.println("Escritura realizada.");
        } catch (IOException e) {
            System.err.println("No se puede crear el archivo en el lugar indicado");
        }

        
    } 
    
    static Double calcularPuntuacion(String texto, String respuestaCorrecta) {
        
        Double puntuacion = 0.0;
        
        for (int i = 0; i < texto.length(); i++) {
            
            if (texto.charAt(i) == respuestaCorrecta.charAt(i)) {
                
                puntuacion += 0.5;
                
            } else if (texto.charAt(i) == ' ') {

                puntuacion += 0.0;

            } else {

                puntuacion -= 0.15;

            }
        }
        return puntuacion;
    }
   

}
