package org.example;

import java.util.ArrayList;
import java.util.Scanner;
public class Usuario extends PersonaVirtual {
    private String Ciudad;

    Scanner entrada = new Scanner(System.in);
    //Constructor
    public Usuario(){
        super("",0,"");
        this.Ciudad="";
    }

    //Getters & Setters
    public String getCiudad() {
        return this.Ciudad;
    }
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    //Comportamientos y metodos
    public void MenuUsuario(){
        int opcion;
        String ciudad;
        Usuario UsuarioActual = new Usuario();
        PuntoReciclaje ptoReciclaje = new PuntoReciclaje();
        Noticias noticias = new Noticias();

        System.out.print("Ingrese su nombre: ");
        UsuarioActual.setNombre(entrada.nextLine());

        System.out.print("Ingrese la ciudad donde se encuentra: ");
        ciudad = entrada.nextLine();
        while(!ciudad.matches("[A-Z][a-zA-Z]*")){
            System.out.println("- Formato incorrecto. Ingrese solo letras, con la primera mayuscula\n");
            System.out.print("Ingrese la ciudad donde se encuentra: ");
            ciudad = entrada.nextLine();
        }
        UsuarioActual.setCiudad(ciudad);

        System.out.println("ELIJA UNA OPCION:");
        System.out.println("1) Puntos de reciclaje cercanos\n2) Presentar noticias\n3) Consultar puntos de reciclaje por ciudad\n4) Presione 0 para salir");
        System.out.print("OPCION:");
        opcion = entrada.nextInt();

        switch (opcion){
            case 0 :
                return;
            case 1 :
                ptoReciclaje.PtoReciclajeCercano(ciudad); //Busca puntosR de acuerdo a la ciudad ingresada
                break;
            case 2 :
                noticias.PresentarNoticia();
                break;
            case 3 :
                System.out.print("Ingrese la ciudad donde desea buscar: ");
                ciudad = entrada.nextLine();
                while(!ciudad.matches("[A-Z][a-zA-Z]*")){
                    System.out.println("- Formato incorrecto. Ingrese solo letras, con la primera mayuscula\n");
                    System.out.print("Ingrese la ciudad donde desea buscar: ");
                    ciudad = entrada.nextLine();
                }
                ptoReciclaje.PtoReciclajeCercano(ciudad); //Busca puntosR de acuerdo a la ciudad ingresada
                break;
        }
    }
}
