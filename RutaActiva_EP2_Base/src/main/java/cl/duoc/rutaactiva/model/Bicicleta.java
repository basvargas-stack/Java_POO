package cl.duoc.rutaactiva.model;

/**
 * Bicicleta disponible en RutaActiva.
 * Tarifa base: $2.500 por hora; las bicicletas eléctricas tienen un recargo del 20 %.
 */
public class Bicicleta extends Vehiculo implements Arrendable {

    private static final double TARIFA_HORA = 2500;
    private static final double RECARGO_ELECTRICA = 0.20;

    private String marca;
    private boolean electrica;

    /** Constructor sin parámetros, necesario para reconstruir objetos desde JSON. */
    public Bicicleta() {
    }

    public Bicicleta(String codigo, String nombre, int horas, String marca, boolean electrica) {
        super(codigo, nombre, horas);
        setMarca(marca);
        setElectrica(electrica);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula ni vacía.");
        }
        this.marca = marca.trim();
    }

    public boolean isElectrica() {
        return electrica;
    }

    public void setElectrica(boolean electrica) {
        this.electrica = electrica;
    }

    @Override
    public double calcularTarifa() {
        double base = getHoras() * TARIFA_HORA;
        if (electrica) {
            return base + base * RECARGO_ELECTRICA;
        }
        return base;
    }

    @Override
    public String getTipo() {
        return "Bicicleta";
    }

    @Override
    public boolean permiteArriendo() {
        return true;
    }
}
