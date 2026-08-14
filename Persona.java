package org.example;

public abstract class Persona {


    String ID;
    String nombre;
    String apellido;
    String edad;

    public Persona(String ID, String nombre, String apellido, String edad) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
