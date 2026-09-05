package org.example;

public class Asignatura {

    //ATRIBUTOS

    String codigo;
    String nombre;
    int Creditos;
    Alumno alumno;
    Profesor profesor;

    public Asignatura(String codigo, String nombre, int creditos, Alumno alumno, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        Creditos = creditos;
        this.alumno = alumno;
        this.profesor = profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int creditos) {
        Creditos = creditos;
    }

    public Alumno getAlumno() {
        if (alumno == null) {
            return null;
        } else {

            return alumno;
        }
    }

    public void setAlumno(Alumno alumno) {
        if (alumno == null) {
            this.alumno = null;
        } else {
            this.alumno = alumno;
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void mostrarAsignatura(){
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Creditos: " + this.Creditos);
        System.out.println("Alumno: " + this.alumno);
        System.out.println("Profesor: " + this.profesor);
    }
}
