package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonaVirtual { //Clase padre - superClase
    private String Nombre;
    private int Id;
    private String Rut;

    Scanner entrada = new Scanner(System.in);

    public PersonaVirtual (String nombre, int identificador, String run){
        this.Nombre = nombre;
        this.Id = identificador;
        this.Rut = run;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getId() {
        return Id;
    }

    public String getRut() {
        return Rut;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setRut(String rut) {
        this.Rut = rut;
    }

    public boolean ValidarPersonaVirtual(ArrayList<Admin> Admins){
        int flag = 0;

        //-----------VALIDACION DE FORMATOS-------------//
        System.out.print("Inserte nombre natural:");
        Nombre = entrada.nextLine();
        while(!Nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*")){
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            Nombre = entrada.nextLine();
        }

        System.out.print("Inserte su Rut:");
        Rut = entrada.nextLine();
        while(!Rut.matches("[0-9]*[-'][0-9]")){
            System.out.println("Dato incorrecto, debe escribir numeros con guion y digito verificador");
            System.out.print("Inserte su Rut:");
            Rut = entrada.nextLine();
        }

        do{
            System.out.print("Ingrese ID:");
            Id = entrada.nextInt();
            //Valdiacion de formato de datos
            if(Id>0){
                flag = 1;   //Formato del ID correcto
            }
            else {
                System.out.println("Formato del identificador incorrecto, debe escribir solo numeros");
            }
        }while(flag==0);

        for(int i = 0; i<Admins.size(); i++){
            if(Admins.get(i).getId() == Id && Admins.get(i).getRut().equals(Rut)){
                return true;
            }
        }
        return false;
    }

    public void CrearPersonaVirtual(String Nombre, int Id, String Rut){
        int flag=0;

        //Valdiacion de formato de datos
        System.out.print("Inserte nombre natural:");
        Nombre = entrada.nextLine();
        while(!Nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*")){
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            Nombre = entrada.nextLine();
        }

        do{
            System.out.print("Ingrese ID:");
            Id = entrada.nextInt();

            //Valdiacion de formato de datos
            if(Id>0){
                flag = 1;   //Formato del ID correcto
            }
            else {
                System.out.println("Formato del identificador incorrecto, debe escribir solo numeros");
            }
        }while(flag==0);

        System.out.print("Inserte su Rut:");
        Rut = entrada.nextLine();
        while(!Rut.matches("[0-9]*[-'][0-9]")){
            System.out.println("Dato incorrecto, debe escribir numeros con guion y digito verificador");
            System.out.print("Inserte su Rut:");
            Rut = entrada.nextLine();
        }
    }

}
