import java.io.*;
import java.util.*;

public class OrdenarVehiculos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta");
        String ruta = sc.nextLine();

        Map<String, List<String>> listaCoches = new HashMap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

            String linea;
            String marca;
            String nombreCoche;


            while ((linea = lector.readLine()) != null) {
                marca = linea.split(" ")[0];
                nombreCoche = linea.split(" ")[1];


                if (!listaCoches.containsKey(marca)) {
                    List<String> conjuntoCoches = new ArrayList<>();
                    conjuntoCoches.add(nombreCoche);
                    listaCoches.put(marca, conjuntoCoches);
                } else {
                    listaCoches.get(marca).add(nombreCoche);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, true))) {

            for (Map.Entry<String, List<String>> marcasYCoches : listaCoches.entrySet()) {
                escritor.newLine();
                escritor.write(marcasYCoches.getKey() + " " + marcasYCoches.getValue().toString().replace("[", " ").replace("]", " "));
                escritor.newLine();
            }

            System.out.println("Escritura realizada.");
        } catch (IOException e) {
            System.err.println("No se puede crear el archivo en el lugar indicado: " + e.getMessage());
        }
    }
}
