package org.example;

public class envioInternacional extends Envio implements Asegurable {

    String paisDestino;
    boolean documentacionAduaneraAlDia;

    public envioInternacional(String codigo, double distanciaKm, double pesoKg, String paisDestino, boolean documentacionAduaneraAlDia) {
        super(codigo, distanciaKm, pesoKg);
        setPaisDestino(paisDestino);
        this.documentacionAduaneraAlDia = documentacionAduaneraAlDia;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        if (paisDestino == null || paisDestino.isBlank()) {
            throw  new IllegalArgumentException("El pais no puede estar vacio");
        }

        this.paisDestino = paisDestino;
    }

    public boolean isDocumentacionAduaneraAlDia() {
        return documentacionAduaneraAlDia;
    }

    public void setDocumentacionAduaneraAlDia(boolean documentacionAduaneraAlDia) {

        this.documentacionAduaneraAlDia = documentacionAduaneraAlDia;
    }


    @Override
    public String toString() {
        return "envioInternacional{" +
                "Codigo='" + getCodigo() + '\'' +
                "distancia en km='" + getDistanciaKm() + '\'' +
                "peso en kg='" + getPesoKg() + '\'' +
                "paisDestino='" + paisDestino + '\'' +
                ", documentacionAduaneraAlDia=" + documentacionAduaneraAlDia +
                '}';
    }

    @Override
    public double calcularCosto() {
        double costo = 20000 + (getDistanciaKm() * 90) + (getPesoKg() * 1200);

        if(!documentacionAduaneraAlDia) {
            costo = (costo*15)/100 + costo;
            return  costo;
        } else {
            return costo;
        }
    }



    @Override
    public double calcularSeguro() {
        double Seguro = calcularCosto() *0.08;
        return Seguro;
    }


}
