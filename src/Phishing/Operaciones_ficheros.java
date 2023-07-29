package Phishing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Operaciones_ficheros {
    public Map<String, Integer> cargarfichero() {
        Map<String, Integer> keywords = new HashMap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader("Archivos textos/lista_palabras.txt"))) {
            String linea_texto;
            while ((linea_texto = lector.readLine()) != null) {
                String[] parts = linea_texto.split(":");
                if (parts.length == 2) {
                    String keyword = parts[0].trim();
                    int probability = Integer.parseInt(parts[1].trim());
                    keywords.put(keyword, probability);
                }
            }
        } catch (IOException e) {
            System.out.print("No se encontro el Archivo con la lista de palabras");
        }
        return keywords;
    }


     public String cargarMensaje(){
         String mensaje = "";
         try {
             mensaje = new String(Files.readAllBytes(Paths.get("Archivos textos/mensajeComprobar.txt")));
         } catch (IOException e) {
             System.out.print("No se encontro el archivo con el mensaje");
         }
         return mensaje;
     }
}

