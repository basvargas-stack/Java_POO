package cl.duoc.rutaactiva.model;

/**
 * Representa un vehículo de la RutaActiva.
 * Define los datos comunes y delega en las subclases el cálculo de tarifa.
 */
public abstract class Vehiculo {

    private String codigo;
    private String nombre;
    private int horas;

    /** Constructor sin parámetros, necesario para reconstruir objetos desde JSON. */
    protected Vehiculo() {
    }

    public Vehiculo(String codigo, String nombre, int horas) {
        setCodigo(codigo);
        setNombre(nombre);
        setHoras(horas);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo ni vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas < 1 || horas > 60) {
            throw new IllegalArgumentException("Las horas deben estar entre 1 y 60.");
        }
        this.horas = horas;
    }

    /** Calcula la tarifa de arriendo según las reglas del tipo de vehículo. */
    public abstract double calcularTarifa();

    /** Entrega el tipo de vehículo para mostrarlo en la tabla. */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}
