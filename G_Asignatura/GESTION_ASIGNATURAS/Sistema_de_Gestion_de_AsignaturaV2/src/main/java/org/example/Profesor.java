package org.example;

import java.time.LocalDate;

public class Profesor extends Persona implements ParticipanteAcademico {

    String especialidad;
    int horasSemanales;
    Asignatura asignatura;

    public Profesor(String run, String nombre, String apellido, LocalDate fechaNacimiento, String especialidad, int horasSemanales, Asignatura asignatura) {
        super(run, nombre, apellido, fechaNacimiento);
        this.especialidad = especialidad;
        this.horasSemanales = horasSemanales;
        this.asignatura = asignatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public void mostrarDatosPersonales(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Especialidad: " + getEspecialidad());
        System.out.println("Horas Semanales: " + getHorasSemanales());
        System.out.println("Asignatura: " + getAsignatura().getNombre());


    }

    public void mostrarInformacion(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Fecha nacimiento: " + getFechaNacimiento());
        System.out.println("Especialidad: " + getEspecialidad());
        System.out.println("Horas Semanales: " + getHorasSemanales());
        System.out.println("Asignatura: " + getAsignatura());

    }

    @Override
    public void realizarActividad() {
        System.out.println("El profesor está impartiendo "+asignatura.getNombre());
    }
}
