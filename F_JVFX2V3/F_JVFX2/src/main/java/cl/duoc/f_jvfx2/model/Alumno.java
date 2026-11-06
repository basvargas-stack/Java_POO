package cl.duoc.f_jvfx2.model;

import java.time.LocalDate;

public class Alumno extends Persona {

    public Alumno(String rut, String nombre, String apellido, LocalDate fechaNacimiento) {
        super(rut, nombre, apellido, fechaNacimiento);
    }


    @Override
    public String getTipo() {

        return "Alumno";
    }


}
