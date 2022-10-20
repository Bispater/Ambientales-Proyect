package org.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class CSVFile {

    private BufferedReader lector;
    private String linea;
    private String partes[] = null;

    public void leerArchivo(String nombreArchivo){
        try{
            lector = new BufferedReader(new FileReader(nombreArchivo));

            while ((linea = lector.readLine()) != null){
                partes = linea.split(",");
            }
            lector.close();
            System.out.println("Se leyó el archivo correctamente ...");
            linea = null;
            partes = null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
