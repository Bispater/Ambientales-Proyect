
package Programa_Principal;
import Manejo_Csv.CSVFile;
import Manejo_Csv.CSVManage;
import Usuarios.Admin;
import Usuarios.UsuarioComun;

import java.util.Scanner;

public class Main {
    public static Scanner entrada;

    public static void main(String[] args){
        int opcion;

        // LECTURA ARCHIVO
        CSVFile archivo = new CSVFile();
        archivo.leerArchivo("\\..\\..\\main\\resources\\CSVTEST.csv");
        CSVManage ob = new CSVManage();
        String[] header = { "Nombre", "Apellido"};
        ob.writeCSV("\\..\\..\\main\\resources\\CSVTEST.csv", header);


        entrada = new Scanner(System.in);

        do{
            System.out.println("============================");
            System.out.println("1.- ADMINISTRADOR");
            System.out.println("2.- USUARIO NORMAL");
            System.out.println("0.- EXIT");
            System.out.println("============================");
            System.out.print("ESCOGA UNA OPCION: ");
            opcion=entrada.nextInt();

            //Prueba
            Admin adminDefecto = new Admin(); //Admin por defecto para poder ingresar
            UsuarioComun usuarioComunDefecto = new UsuarioComun();
            //administradores.add(adm1);
            //PuntoReciclaje pto1 = new PuntoReciclaje();
            //pto1.CrearPuntoReciclaje();
            //puntosReciclaje.add(pto1);
            //-----------------

            switch(opcion)
            {
                case 1 :
                    adminDefecto.MenuAdministrador();
                    break ;
                case 2 :
                    usuarioComunDefecto.MenuUsuario();
                    break;
                case 0 :
                    return;
            }
        }while(true);
    }
}