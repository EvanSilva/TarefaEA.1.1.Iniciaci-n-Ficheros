/**
 *  1. Versión simple de ls
 *  Haz un programa que reciba el nombre de un directorio y muestre todo su contenido, indicando en cada caso si se trata de un fichero o directorio y los permisos que tenemos sobre él.
 *  La salida tendrá un aspecto similar a este:
 *
 *  -rw- archivo
 *
 *  drwx directorio
 *
 *  Evan:
 *
 *  El programa pide una ruta (Ej: c:\), al dársela, desglosa todos los archivos y te entrega sus permisos y su tipo.
 *
 */

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;


public class SimpleLs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre = sc.nextLine();

        Path dir = Path.of(nombre);

        System.out.println("Ficheros del directorio " + dir);

        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);) {
                for (Path fichero : stream) {

                    StringBuilder string = new StringBuilder("Permisos de " + fichero.getFileName() + " = ");

                    if (fichero.toFile().isDirectory()) {
                        string.append("d");
                    } else {
                        string.append("-");
                    }

                    if (fichero.toFile().canRead()) {
                        string.append("r");
                    } else {
                        string.append("-");
                    }

                    if (fichero.toFile().canWrite()) {
                        string.append("w");
                    } else {
                        string.append("-");
                    }

                    if (fichero.toFile().canExecute()) {
                        string.append("x");
                    } else {
                        string.append("-");
                    }

                    System.out.println(string);
                }

            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        } else {
            System.err.println(dir.toString() + " no es un directorio");
        }
    }
}
