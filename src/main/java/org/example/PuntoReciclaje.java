package org.example;
import java.util.Scanner;
import java.util.ArrayList;
public class PuntoReciclaje {
    Scanner leer = new Scanner(System.in);
    ArrayList <PuntoReciclaje> puntosReciclaje = new ArrayList<>();


    //Atributos
    private String Direccion;
    private boolean Habilitado;
    private String TipoReciclaje;
    // LA CAPACIDAD SERÁ EN KILOS
    private int Capacidad;
    // PERÍODO DE VACIADO (LIMPIEZA DEL PUNTO DE RECICLAJE) EN DÍAS
    private int PeriodoVaciado;
    private String Ciudad;
    private int Id;

    //Constructor
    public PuntoReciclaje()
    {
        this.Direccion="";
        this.Habilitado=false;
        this.TipoReciclaje="";
        this.Capacidad=0;
        this.PeriodoVaciado=0;
        this.Ciudad="";
        this.Id=-1;
    }
    public PuntoReciclaje(String direccion , String tipoReciclaje , int capacidad , int periodoVaciado ,String ciudad , int id )
    {
        this.Direccion=direccion;
        this.Habilitado=true;
        this.TipoReciclaje=tipoReciclaje;
        this.Capacidad=capacidad;
        this.PeriodoVaciado=periodoVaciado;
        this.Ciudad=ciudad;
        this.Id= id ;
    }

    //Getters & Setters
    public String getDireccion() {
        return this.Direccion;
    }
    public boolean getHabilitado() {
        return this.Habilitado;
    }
    public String getTipoReciclaje() {
        return this.TipoReciclaje;
    }
    public int getCapacidad() {
        return this.Capacidad;
    }
    public int getPeriodoVaciado(){
        return this.PeriodoVaciado;
    }
    public String getCiudad(){
        return this.Ciudad;
    }

    public int getId() {
        return Id;
    }

    public void setDireccion(String Direccion){
        this.Direccion = Direccion;
    }

    public void setHabilitado(boolean Habilitado){
        this.Habilitado = Habilitado;
    }
    public void setTipoReciclaje(String TipoReciclaje){
        this.TipoReciclaje = TipoReciclaje;
    }
    public void setCapacidad(int Capacidad){
        this.Capacidad = Capacidad;
    }
    public void setPeriodoVaciado(int PeriodoVaciado){
        this.PeriodoVaciado = PeriodoVaciado;
    }
    public void setCiudad(String ciudad){
        this.Ciudad = ciudad;
    }
    public void setId(int id) {
        Id = id;
    }

    //Comportamientos y metodos
    public boolean CrearPuntoReciclaje() {
        int flag=0;
        String direccion,ciudad;
        PuntoReciclaje ptoNuevo = new PuntoReciclaje();

        System.out.println("Ingrese nombre de la calle y numero");
        System.out.print("Direccion: ");
        direccion = leer.nextLine();

        while(!direccion.matches("([A-z]+[ '][A-z]+[-'][0-9]+)*")){ //Revisar
            System.out.println("- Formato incorrecto.\n-Se acepta letras y numeros\n");
            System.out.println("Ingrese nombre de la calle y el numero separado por guion");
            System.out.print("Direccion: ");
            direccion = leer.nextLine();
        }
        ptoNuevo.setDireccion(direccion);

        System.out.print("Tipo Reciclaje: ");
        ptoNuevo.setTipoReciclaje(leer.nextLine());

        System.out.print("Ciudad donde se encuentra: ");
        ciudad = leer.nextLine();
        while(!ciudad.matches("[A-Z][a-zA-Z]*")){
            System.out.println("- Formato incorrecto. Ingrese solo letras, con la primera mayuscula\n");
            System.out.print("Ciudad donde se encuentra: ");
            ciudad = leer.nextLine();
        }
        ptoNuevo.setCiudad(ciudad);

        System.out.print("Capacidad en kilogramos: ");
        ptoNuevo.setCapacidad(leer.nextInt());
        System.out.print("Periodo de vaciado en dias: ");
        ptoNuevo.setCapacidad(leer.nextInt());

        do{
            System.out.print("Ingrese el numero identificador:");
            ptoNuevo.setId(leer.nextInt());
            if(ptoNuevo.getId()>0){
                flag=1;
            }else{
                System.out.println("Formato del identificador incorrecto, ingrese solo numeros");
            }
        }while(flag==0);
        ptoNuevo.Habilitado = true; //Se habilita el punto de reciclaje creado por el admin
        puntosReciclaje.add(ptoNuevo); //Se agrega el punto de reciclaje creado a la lista
        if(ptoNuevo.Habilitado){
            return true;
        }
        else
            return false;
    }

    public void MostrarPtoReciclaje(){
        for(int i= 0 ; i< puntosReciclaje.size() ; i ++) {
            System.out.println("================PUNTO DE RECICLAJE "+(i+1)+"==================");
            System.out.println("Tipo de reciclaje: "+puntosReciclaje.get(i).getTipoReciclaje());
            System.out.println("Direccion: "+puntosReciclaje.get(i).getDireccion());
            System.out.println("Capacidad del punto de reciclaje: "+puntosReciclaje.get(i).getCapacidad()+" kilogramos.");
            System.out.println("Identificador del punto de reciclaje: "+puntosReciclaje.get(i).getId());
            if(puntosReciclaje.get(i).getHabilitado()){
                System.out.println("Punto de reciclaje DISPONIBLE");
            }
            else{
                System.out.println("Punto de reciclaje NO DISPONIBLE");
            }
        }
    }
    public void PtoReciclajeCercano(String ciudad){
        for(int i=0; i<puntosReciclaje.size(); i++){
            if(puntosReciclaje.get(i).getCiudad().equals(ciudad)){
                MostrarPtoReciclaje(i);
            }
        }
    }
    public void MostrarPtoReciclaje(int indice){
        System.out.println("================PUNTO DE RECICLAJE "+(indice+1)+"==================");
        System.out.println("Tipo de reciclaje: "+puntosReciclaje.get(indice).getTipoReciclaje());
        System.out.println("Direccion: "+puntosReciclaje.get(indice).getDireccion());
        System.out.println("Capacidad del punto de reciclaje: "+puntosReciclaje.get(indice).getCapacidad()+" kilogramos.");
        System.out.println("Identificador del punto de reciclaje: "+puntosReciclaje.get(indice).getId());
        if(puntosReciclaje.get(indice).getHabilitado()){
            System.out.println("Punto de reciclaje DISPONIBLE");
        }
        else{
            System.out.println("Punto de reciclaje NO DISPONIBLE");
        }
    }
    public boolean EliminarPtoReciclaje(){
        int id;
        System.out.println("===========================================");
        System.out.print("Ingrese identificador del punto de reciclaje:");
        id = leer.nextInt();

        for(int i=0; i<puntosReciclaje.size(); i++){
            if(puntosReciclaje.get(i).getId() == id){
                puntosReciclaje.remove(puntosReciclaje.get(i));
                return true;
            }
        }
        return false;
    }

    public void ActualizarPtoReciclaje(){
        int Id,flag=0;
        do{
            System.out.println("Numero identificador del punto de reciclaje a actualizar");
            System.out.print("Ingrese ID:");
            Id = leer.nextInt();
            if(Id>0){
                flag=1;
            }else{
                System.out.println("Formato del identificador incorrecto, ingrese solo numeros");
            }
        }while(flag==0);

        for(int i=0; i<puntosReciclaje.size(); i++){
            if(puntosReciclaje.get(i).getId() == Id){
                System.out.println("¡¡Punto de reciclaje encontrado!! - Ingrese nuevos datos.....");
                CrearPuntoReciclaje();
            }
        }
    }
}
