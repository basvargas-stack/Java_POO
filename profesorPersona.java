package org.example;

public class profesorPersona extends Persona {

    private int sueldo;
    private String titulo;

    public profesorPersona(String ID, String nombre, String apellido, String edad, int sueldo, String titulo) {
        super(ID, nombre, apellido, edad);
        this.sueldo = sueldo;
        this.titulo = titulo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "profesorPersona{" +
                "sueldo=" + sueldo +
                ", titulo='" + titulo + '\'' +
                ", ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
