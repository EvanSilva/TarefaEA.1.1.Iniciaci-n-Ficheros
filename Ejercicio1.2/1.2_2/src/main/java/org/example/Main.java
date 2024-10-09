package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Game juego1 = new Game("Dooom", "Es er doom", "Ingles, Español");
        Game juego2 = new Game("Sims", "Es er Sims", "Ingles, Español");
        Game juego3 = new Game("Rage", "Es er Rage", "Ingles, Español");
        Game juego4 = new Game("Maicraft", "Es er Maicraft", "Ingles, Español");
        Game juego5 = new Game("Callorduty", "Es er Callorduty", "Ingles, Español");

        ArrayList<Game> juegos = new ArrayList<>();
        juegos.add(juego1);
        juegos.add(juego2);
        juegos.add(juego3);
        juegos.add(juego4);
        juegos.add(juego5);

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("res/games.bin"));) {

            for (Game juego : juegos) {
                escritor.writeObject(juego);
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }

        ArrayList<Game> juegosLeidos = new ArrayList<>();

        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("res/games.bin"));) {
            while (true) {

                Object o = lector.readObject();
                if (o instanceof Game) {
                    juegosLeidos.add((Game) o);

                }
            }
        } catch (EOFException ex) {
            System.out.println("Hemos llegado al final del archivo.");
            for (Game juego : juegosLeidos) {
                System.out.println(juego);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

}
