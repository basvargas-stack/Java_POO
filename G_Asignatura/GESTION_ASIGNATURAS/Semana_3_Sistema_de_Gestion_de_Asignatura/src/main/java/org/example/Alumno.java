package org.example;

import java.time.LocalDate;

public class Alumno extends Persona implements ParticipanteAcademico{

    int numeroMatricula;
    double Promedio;
    Asignatura asignatura;

    public Alumno(String run, String nombre, String apellido, LocalDate fechaNacimiento, int numeroMatricula, double promedio, Asignatura asignatura) {
        super(run, nombre, apellido, fechaNacimiento);
        this.numeroMatricula = numeroMatricula;
        Promedio = promedio;
        this.asignatura = asignatura;
    }

    public int getNumeroMatricula() {

        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {

        this.numeroMatricula = numeroMatricula;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setPromedio(double promedio) {
        Promedio = promedio;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public void mostrarDatosPersonales() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Fecha nacimiento: " + getFechaNacimiento());
        System.out.println("Numero de matricula: " + getNumeroMatricula());
        System.out.println("Promedio: " + getPromedio());
        System.out.println("Asignatura: " + asignatura.nombre);

    }

    @Override
    public void mostrarInformacion(){
        mostrarDatosPersonales();
        System.out.println("numero de matricula: " + getNumeroMatricula());
        System.out.println("Promedio: " + getPromedio());
        System.out.println("Asignatura: " + getAsignatura());

    }



    @Override
    public void realizarActividad() {
        System.out.println("El alumno está estudiando "+ asignatura);
    }

}
