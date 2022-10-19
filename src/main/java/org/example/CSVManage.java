package org.example;

import java.io.*;

public class CSVManage {

    //void writeCSV(String file, String index, String number)
    void writeCSV(String file, String[] header ){
        try {
            /*
            This function write into CSV file. Receive a string with name file, an index and a number that will be saved.
             */
            System.out.println(file);
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

    int [] readCSV(String file, int n) throws IOException{
        int [] array = new int[n];
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null){
            String [] parts = line.split(",");
            int total_parts = parts.length;

            for (int i = 0; i < total_parts; i++) {
                //this line save the 2nd column
                int aux = 0;
                if (i % 2 != 0) {
                    array[count] = Integer.parseInt(parts[i]);
                    count++;
                }
            }
        }
        return array;
    }

}