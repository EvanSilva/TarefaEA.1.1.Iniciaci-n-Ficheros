import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContadorCaracteres {


    public static void main(String[] args) {

        try (BufferedReader lector = new BufferedReader(new
                FileReader("res/LetrasAleatorias.txt"));) {

            String linea;

            HashMap<String, Integer> caracteres = new HashMap<>();

            while ((linea=lector.readLine()) != null) {

                for (char character : linea.toCharArray()) {
                    if (caracteres.containsKey(String.valueOf(character))) {
                        caracteres.put(String.valueOf(character), caracteres.get(String.valueOf(character))+1);
                    } else {
                        caracteres.put(String.valueOf(character), 1);
                    }
                }
            }

            int numeroRepeticiones = 1 ;
            String LetraMasRepetida = "" ;

            for (Map.Entry<String, Integer> entrada : caracteres.entrySet()) {

                if (entrada.getValue() > numeroRepeticiones) {
                    numeroRepeticiones = entrada.getValue();
                    LetraMasRepetida = entrada.getKey();
                }
            }

            System.out.println("La letra mas repetida es " + LetraMasRepetida + " con las repeticiones: " + numeroRepeticiones);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
