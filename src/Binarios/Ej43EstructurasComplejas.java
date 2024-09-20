package Binarios;

import java.io.*;

public class Ej43EstructurasComplejas {

    public static void main(String[] args) {
        Persona maria = new Persona("María");
        maria.addMascota(new Mascota("Rudy", 4));
        maria.addMascota(new Mascota("Piolin", 2, false));

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("prueba.bin"));) {
            escritor.writeObject(maria);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        Persona p = null;
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("prueba.bin"));) {
            p = (Persona) lector.readObject();
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

        if (p != null) {
            System.out.println(p);
            for (Mascota mascota : p.getMascotas()) {
                System.out.println(mascota);
            }
        }
    }
}