package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Persona personaSola = new Persona("Alberto", 10);

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/main/res/persona.bin", false))) {

                escritor.writeObject(personaSola);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alberto", 10));
        personas.add(new Persona("Sergio", 12));
        personas.add(new Persona("Alba", 13));
        personas.add(new Persona("Lydia", 14));

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/main/res/personas.bin", false))) {

            for (Persona persona : personas) {
                escritor.writeObject(persona);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}