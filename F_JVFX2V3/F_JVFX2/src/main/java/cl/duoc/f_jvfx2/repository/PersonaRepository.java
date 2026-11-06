package cl.duoc.f_jvfx2.repository;

import cl.duoc.f_jvfx2.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private final List<Persona> personas = new ArrayList<>();



    private static final  PersonaRepository instance = new PersonaRepository();

    public  PersonaRepository() {


    }

    public static PersonaRepository getInstance() {
        return instance;
    }

    public void agregar(Persona persona) {
        if (persona == null){
            throw new IllegalArgumentException("La persona no puede ser nulo.");
        }
        if (existeRut(persona.getRut())){
            throw new IllegalArgumentException("El rut ya existe");
        }
        if (persona.getRut() == null || persona.getRut().isEmpty()){
            throw new IllegalArgumentException("El rut no puede ser nulo.");
        }

        personas.add(persona);

    }

    public List<Persona> ListarTodos() {

        return new ArrayList<>(personas);
    }

    private boolean existeRut(String rut){
        for (Persona p : personas){
            if (p.getRut().equalsIgnoreCase(rut.trim())){ //IgnoreCase: Ignorar mayusculas - trim: Eliminar espacios
                return true;
            }

        }
        return false;
    }

    public Persona buscarPorRut(String rut){
        if (rut==null || rut.isBlank()){
            throw new IllegalArgumentException("El rut no puede ser nulo.");
        }
        for (Persona p : personas){
            if (p.getRut().equalsIgnoreCase(rut.trim())){
                return p;
            }
        } return null;
    }

    public void Actualizar(Persona persona){
        if (persona == null){
            throw new IllegalArgumentException("La persona no puede ser nulo.");
        }

        for (Persona p : personas){
            if (p.getRut().equalsIgnoreCase(persona.getRut())){
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
                p.setRut(persona.getRut());
                p.setFechaNacimiento(persona.getFechaNacimiento());
                return;
            }
        }
        throw new IllegalArgumentException("No existe una persona con ese rut");

    }



}
