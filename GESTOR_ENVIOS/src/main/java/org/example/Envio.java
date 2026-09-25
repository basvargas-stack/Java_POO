package org.example;

public abstract class Envio {

    private String codigo; //ID PRIMARIO (identificador)
    private double distanciaKm;
    private double pesoKg;

    public Envio(String codigo, double distanciaKm, double pesoKg) {
        setCodigo(codigo);
        setDistanciaKm(distanciaKm);
        setPesoKg(pesoKg);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw  new IllegalArgumentException("El codigo del envio no puede estar vacio");
        }

        this.codigo = codigo;
    }

    public double getDistanciaKm() {

        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {

        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("Los kilometros deben superar los 0 km");
        }
        this.distanciaKm = distanciaKm;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Los kilometros deben superar los 0 kg");
        }

        this.pesoKg = pesoKg;
    }


    public double calcularCosto(){
        return 0;
    }







}
