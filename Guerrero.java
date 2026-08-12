package org.example;

public class Guerrero {

    private String nombre;
    private int vida;
    private int fuerza;
    private int agilidad;


    public Guerrero(String nombre, int vida, int fuerza, int agilidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        }
        else {
            this.vida = vida;;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            this.fuerza = 0;
        }
        else {
            this.fuerza = fuerza;;
        }
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        if (agilidad < 0) {
            this.agilidad = 0;
        } else {
            this.agilidad = agilidad;
            ;
        }
    }

    @Override
    public String toString() {
        return "Guerrero{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", fuerza=" + fuerza +
                ", agilidad=" + agilidad +
                '}';
    }
}
