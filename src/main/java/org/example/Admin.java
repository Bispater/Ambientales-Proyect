package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin extends PersonaVirtual {
    private String Contrasenia;
    Scanner entrada = new Scanner(System.in);
    ArrayList <Admin> administradores = new ArrayList<>();

    // Constructores
    public Admin() {
        super("",1,"");
        this.Contrasenia = "a0";
    }
    public Admin(String nombre , int id , String contrasenia) {
        super(nombre,id,""); //Solicitar rut al admin
        this.Contrasenia = contrasenia;
    }

    // Geters y setters
    public String getContrasenia() {
        return this.Contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.Contrasenia = contrasenia;
    }

    //Comportamientos
    public Admin CrearAdmin() {
        Admin NuevoAdmin;
        String contrasenia, nombre;
        int ID, flag=0;
        Scanner leer = new Scanner(System.in);

        //Valdiacion de formato de datos
        System.out.print("Inserte nombre de administrador:");
        nombre = leer.nextLine();
        while(!nombre.matches("([a-zA-Z]*[ ']+[a-zA-Z]*)*")){
            System.out.println("El dato es incorrecto, debe escribir solo letras (nombre y apellido separados)");
            System.out.print("Inserte nombre de administrador: ");
            nombre = leer.nextLine();
        }

        do{
            System.out.print("Ingrese ID:");
            ID = leer.nextInt();

            //Valdiacion de formato de datos
            if(ID>0){
                flag = 1;   //Formato del ID correcto
            }
            else {
                System.out.println("Formato del identificador incorrecto, debe escribir solo numeros");
            }
        }while(flag==0);

        System.out.print("Ingrese su contraseña:");
        contrasenia = leer.next();
        while(!contrasenia.matches("([a-zA-Z]*+[0-9]*+)*")){
            System.out.println("Formato incorrecto, debe recibir al menos una letra y un numero");
            System.out.print("Ingrese contraseña:");
            contrasenia = leer.next();
        }

        NuevoAdmin = new Admin(nombre,ID,contrasenia);
        return NuevoAdmin;
    }

    public boolean ValidarAdmin(){
        int ID, flag=0;
        String contra;
        Admin adminNuevo = new Admin();

        do{
            System.out.print("Ingrese ID: ");
            ID = entrada.nextInt();

            //Valdiacion de formato de datos
            if(ID>0){
                flag = 1;   //Formato del ID correcto
            }
            else {
                System.out.println("Formato del identificador incorrecto, ingrese solo numeros");
            }
        }while(flag==0);

        //Valdiacion de formato de datos
        System.out.print("Ingrese contraseña: ");
        contra = entrada.next();
        while(!contra.matches("([a-zA-Z]*+[0-9]*+)*")){ //Revisar
            System.out.println("El dato es incorrecto, debe recibir al menos una letra y numero");
            System.out.print("Ingrese contraseña: ");
            contra = entrada.next();
        }
        administradores.add(adminNuevo); //Usuario admin por defecto para poder ingresar y comparar en la coleccion.

        for(int i=0; i<administradores.size(); i++){
            if(administradores.get(i).getId() == ID && administradores.get(i).getContrasenia().equals(contra)){
                System.out.println("------------Acceso permitido--------------");
                return true;
            }
        }
        System.out.println("Acceso denegado - intente nuevamente");
        return false;
    }

    public void MenuAdministrador(){
        Noticias NoticiaNueva = new Noticias();
        PuntoReciclaje ptoNuevo = new PuntoReciclaje();

        if(ValidarAdmin()){
            do {
                System.out.println("================MENU ADMINISTRADOR====================");
                System.out.println("ELIJA UNA OPCION:");
                System.out.println("1) Mostrar puntos de reciclaje\n2) Agregar administrador\n3) Agregar punto de reciclaje\n4) Agregar noticia\n5) Eliminar punto de reciclaje\n6) Eliminar noticia");
                System.out.println("7) Presione 0 para salir");
                System.out.print("OPCION:");
                int opcion = entrada.nextInt();

                switch (opcion) {
                    case 0:
                        return;
                    case 1:
                        ptoNuevo.MostrarPtoReciclaje(); //Se manda a la clase PuntoReciclaje ya que necesita la lista
                        break;
                    case 2:
                        administradores.add(CrearAdmin());
                        System.out.println("Se agrego exitosamente...");
                        break;
                    case 3:
                        if (ptoNuevo.CrearPuntoReciclaje()){
                            System.out.println("Se agrego exitosamente...");
                        }
                        break;
                    case 4:
                        if(NoticiaNueva.CrearNoticia()){
                            System.out.println("Se agrego exitosamente...");
                        }
                        break;
                    case 5:
                        if(ptoNuevo.EliminarPtoReciclaje()){
                            System.out.println("Se elimino el punto de reciclaje exitosamente...");
                        }
                        else {
                            System.out.println("Punto de reciclaje inexistente, intente nuevamente...");
                        }
                        break;
                    case 6:
                        if(NoticiaNueva.EliminarNoticia()){
                            System.out.println("Se elimino la noticia exitosamente...");
                        }
                        else {
                            System.out.println("Noticia inexistente, intente nuevamente...");
                        }
                        break;
                    default:
                        System.out.println("No se seleciono ninguna opcion valida, vuelva intentarlo");
                        break;
                }
            }while(true);
        }
        else{
            return;
        }
    }
}