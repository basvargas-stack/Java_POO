package org.example;

public class estudiantePersona extends Persona {

    private String carrera;
    private int mensualidad;

    public estudiantePersona(String ID, String nombre, String apellido, int edad, String carrera, int mensualidad) {
        super(ID, nombre, apellido, String.valueOf(edad));
        this.carrera = carrera;
        this.mensualidad = mensualidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    @Override
    public String toString() {
        return "estudiantePersona{" +
                "carrera='" + carrera + '\'' +
                ", mensualidad=" + mensualidad +
                ", ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
