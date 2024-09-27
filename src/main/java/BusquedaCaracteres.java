import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

/**
 *  2. Búsqueda de carácteres
 *
 *  Haz un programa que dado un fichero y un carácter cuente el número de ocurrencias de ese carácter en el fichero. Variante: dado un fichero encuentre el carácter más usado.
 *
 *
 */

public class BusquedaCaracteres {

    public static void main(String[] args) throws IOException {

        try (BufferedReader lector = new BufferedReader(new
                FileReader("res/BusquedaCaracteres.txt"));) {

            String linea = "";

            Scanner sc = new Scanner(System.in);

            System.out.print("Introduce el caracter a buscar: ");

            char letraControl = sc.next().charAt(0);

            int contador = 0;

            while ((linea = lector.readLine()) != null)

                for (char character : linea.toCharArray()) {
                    if (character == letraControl) {
                        contador++;
                    }
                }

            System.out.println("El numero de veces que sale el caracter es: " + contador);

        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}

