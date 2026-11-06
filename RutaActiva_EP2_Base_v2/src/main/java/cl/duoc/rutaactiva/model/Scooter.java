package cl.duoc.rutaactiva.model;

/**
 * Scooter disponible en RutaActiva.
 * Tarifa base: $1.800 por hora; las ediciones premiumes tienen recargo del 15 %.
 */
public class Scooter extends Vehiculo implements Arrendable {

    private static final double TARIFA_HORA = 1800;
    private static final double RECARGO_PREMIUM = 0.15;

    private boolean premium;

    /** Constructor sin parámetros, necesario para reconstruir objetos desde JSON. */
    public Scooter() {
    }

    public Scooter(String codigo, String nombre, int horas, boolean premium) {
        super(codigo, nombre, horas);
        setPremium(premium);
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public double calcularTarifa() {
        double base = getHoras() * TARIFA_HORA;
        if (premium) {
            return base + base * RECARGO_PREMIUM;
        }
        return base;
    }

    @Override
    public String getTipo() {
        return "Scooter";
    }

    @Override
    public boolean permiteArriendo() {
        return true;
    }
}
