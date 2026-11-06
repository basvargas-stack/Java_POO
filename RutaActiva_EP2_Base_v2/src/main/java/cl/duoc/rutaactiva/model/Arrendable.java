package cl.duoc.rutaactiva.model;

/** Contrato para vehículos disponibles para arriendo. */
public interface Arrendable {

    /** Retorna true si el vehículo puede ser arrendado. */
    boolean permiteArriendo();
}
