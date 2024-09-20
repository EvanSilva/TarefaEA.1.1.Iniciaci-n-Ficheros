
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 3. Ordenaciones
 *
 *  Haz un programa que sea capaz de ordenar alfabéticamente las líneas contenidas en un fichero de texto. El nombre del fichero que contiene se debe pasar como argumento en la línea de comandos, así como el tipo de ordenación (ascendente case-sensitive, ascendente-case-insensitive, descendente case-sensitive, descendente case-insensitive). El nombre del fichero resultado debe ser el mismo que el original añadiendo el tipo de ordenación, por ejemplo, palabras_asc_non_case.txt
 *
 */

public class Ordenaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Provee la ruta al archivo para ordenar");
        String ruta = sc.nextLine();
        System.out.println("Selecciona el tipo de ordenacion: \na: ascendente case-sensitive: \nb: ascendente case-insensitive \nc: descendente case-sensitive \nd: descendente case-insensitive ");
        String tipoOrdenacion = sc.nextLine();

        List<String> lineas = new ArrayList<>();

        List<String> lineasOrdenadas = new ArrayList<>();
        String apendiceFinal = "";

        String nuevaRuta = ruta.substring(0, ruta.length() - 4) ;

        try (BufferedReader lector = new BufferedReader(new

                FileReader(ruta));) {

            String linea = "";

            while ((linea = lector.readLine()) != null)

                lineas.add(linea);

        } catch (IOException e) {
            System.err.println("No se encuentra el archivo");
        }


        if (tipoOrdenacion.equals("a")) {
            lineasOrdenadas = lineas.stream()
                    .sorted()
                    .collect(Collectors.toList());

            nuevaRuta += "_asc_case.txt";
        }

        if (tipoOrdenacion.equals("b")) {
            lineasOrdenadas = lineas.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());

            nuevaRuta += "_asc_non_case.txt";
        }

        if (tipoOrdenacion.equals("c")) {
            lineasOrdenadas = lineas.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            nuevaRuta += "_desc_case.txt";
        }

        if (tipoOrdenacion.equals("d")) {
            lineasOrdenadas = lineas.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                    .collect(Collectors.toList());
            nuevaRuta += "_desc_non_case.txt";
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nuevaRuta,false));) {

            for(String linea : lineasOrdenadas) {
                escritor.write(linea);
                escritor.newLine();
            }

            System.out.println("Escritura realizada.");
        } catch (IOException e) {
            System.err.println("No se puede crear el archivo en el lugar indicado");
        }

    }
}
