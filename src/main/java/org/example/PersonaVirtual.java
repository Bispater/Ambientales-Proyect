package org.example;

public class PersonaVirtual { //Clase padre - superClase
    private String Nombre;
    private int Id;
    private String Rut;

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


}
