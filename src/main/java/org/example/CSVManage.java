package org.example;

import java.io.*;

public class CSVManage {

    //void writeCSV(String file, String index, String number)
    void writeCSV(String file, String[] header ){
        try {
            /*
            Esta función escribe dentro del archivo CSV. Recibe un String con el nombre del archivo, y
            el dato que será guardado.
             */
            System.out.println("Leyendo archivo : " + file);
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(header[0] + ";" + header[1]);
            System.out.println(header);
            printWriter.flush();
            printWriter.close();

            //JOptionPane.showMessageDialog(null, "File Saved");
        }catch (IOException e){
            System.out.println(e);
        }
    }

}