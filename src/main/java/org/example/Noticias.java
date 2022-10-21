package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Noticias {
    Scanner leer = new Scanner(System.in);
    ArrayList <Noticias> ListaNoticias = new ArrayList<>();

    //Atributos
    private String fecha;
    private String URL;
    private String TipoNoticia;
    private String Descripcion;
    private int idNoticia;

    public Noticias(){
        //Date fecha = new Date();
        this.URL="";
        this.TipoNoticia="";
        this.Descripcion="";
        this.idNoticia=-1;
    }
    public Noticias(String fecha  , String url , String tipoNoticia , String descripcion , int idNoticia ){
        this.fecha = fecha ;
        this.URL=url;
        this.TipoNoticia=tipoNoticia;
        this.Descripcion=descripcion;
        this.idNoticia=idNoticia ;
    }

    //Getters & Setters
    public int getIdNoticia() {
        return this.idNoticia;
    }
    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }
    public String getDescripcion() {
        return this.Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
    public String getFecha() {
        return this.fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getURL() {
        return this.URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    public String getTipoNoticia() {
        return this.TipoNoticia;
    }
    public void setTipoNoticia(String tipoNoticia) {
        this.TipoNoticia = tipoNoticia;
    }

    //Comportamientos
    public boolean CrearNoticia(){
        int ID, flag=0;
        String tipoN;
        Noticias NoticiaNueva = new Noticias();

        System.out.print("Tipo de noticia: ");
        tipoN = leer.nextLine();
        while(!tipoN.matches("[a-zA-Z]*")){
            System.out.println("Dato incorrecto, ingrese solo letras");
            System.out.print("Tipo de noticia: ");
            tipoN = leer.nextLine();
        }
        NoticiaNueva.setTipoNoticia(tipoN);

        System.out.print("Descripcion de la noticia: "); //Diseñar formato de valides
        NoticiaNueva.setDescripcion(leer.nextLine());
        System.out.print("Ingresar URL de la noticia");
        NoticiaNueva.setURL(leer.nextLine());

        do{
            System.out.print("Ingrese el numero identificador de la noticia:");
            NoticiaNueva.setIdNoticia(leer.nextInt());
            if(NoticiaNueva.getIdNoticia()>0){
                flag=1;
            }else{
                System.out.println("Formato del identificador incorrecto, ingrese solo numeros");
            }
        }while(flag==0);

        //System.out.print("Fecha de publicacion de la noticia "); -- revisar como pasar de fecha a string
        //this.setFecha(leer.next());

        ListaNoticias.add(NoticiaNueva);//Se agrega la noticia a la lista
        return true;
    }
    public void PresentarNoticia(){
        for(int i=0; i<ListaNoticias.size(); i++){
            System.out.println("============NOTICIA "+(i+1)+"=============");
            System.out.println("Titular:"+this.Descripcion);
            System.out.println("Tipo de noticia: "+this.TipoNoticia);
            System.out.println("URL: "+this.URL);
            //Colocar tambien la fecha de la noticia
        }
    }

    public boolean EliminarNoticia(){
        int id;
        System.out.println("===========================================");
        System.out.print("Ingrese identificador de la noticia a eliminar:");
        id = leer.nextInt();

        for(int i=0; i<ListaNoticias.size(); i++){
            if(ListaNoticias.get(i).getIdNoticia() == id){
                ListaNoticias.remove(ListaNoticias.get(i));
                return true;
            }
        }
        return false;
    }
}
