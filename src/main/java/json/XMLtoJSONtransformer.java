package json;

import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class XMLtoJSONtransformer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta a un archivo XML:");
        String ruta = sc.nextLine();

        System.out.println("Introduce la ruta donde guardar el archivo JSON (Acabado en .json)");
        String rutaJson = sc.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();

            String xmlContent = stringBuilder.toString();
            JSONObject json = XML.toJSONObject(xmlContent);

            try (FileWriter fileWriter = new FileWriter(rutaJson)) {
                fileWriter.write(json.toString(4));
                System.out.println("Archivo JSON guardado en: " + rutaJson);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Archivo XML no encontrado: " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}