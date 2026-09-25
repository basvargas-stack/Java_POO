package org.example;

public class envioNacional extends Envio{

    String regionDestino;
    boolean Urgente;

    public envioNacional(String codigo, double distanciaKm, double pesoKg, String regionDestino, boolean urgente) {
        super(codigo, distanciaKm, pesoKg);
        setRegionDestino(regionDestino);
        Urgente = urgente;
    }

    public String getRegionDestino() {
        return regionDestino;
    }

    public void setRegionDestino(String regionDestino) {
        if (regionDestino == null || regionDestino.isBlank()) {
            throw new IllegalArgumentException("La region no puede estar vacia");
        }

        this.regionDestino = regionDestino;
    }

    public boolean isUrgente() {
        return Urgente;
    }

    public void setUrgente(boolean urgente) {
        Urgente = urgente;
    }


    @Override
    public double calcularCosto() {
        double costo = 8000 * (getDistanciaKm() * 60) + (getPesoKg() * 500);

        if (Urgente) {
            costo = ((costo*25)/100) + costo;
            return  costo;
        }
        return costo;
    }

    @Override
    public String toString() {
        return "envioNacional{" +
                "codigo='" + getCodigo() + '\'' +
                "distancia en km ='" + getDistanciaKm() + '\'' +
                "peso en kg='" + getPesoKg() + '\'' +
                "regionDestino='" + regionDestino + '\'' +
                ", Urgente=" + Urgente +
                '}';
    }
}
