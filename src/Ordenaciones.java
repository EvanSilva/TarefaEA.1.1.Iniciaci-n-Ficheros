import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

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
        System.out.println("Selecciona el tipo de ordenacion: \nA: ascendente case-sensitive: \nB: ascendente case-insensitive \nC: descendente case-sensitive \nD: descendente case-insensitive ");
        String tipoOrdenacion = sc.nextLine();

    }
}
