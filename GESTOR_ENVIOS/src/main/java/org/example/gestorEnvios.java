package org.example;

import java.util.ArrayList;

import java.util.List;

public class gestorEnvios {


    List<Envio> envios = new ArrayList<>();

    public void registrarEnvio(Envio  envio){
        if (envios.isEmpty()){
            envios.add(envio);
        } else {
            for (Envio envio1 : envios) {
                if (envio1.getCodigo().equals(envio.getCodigo())){
                    System.out.println("El envio existe en la base de datos");
                } else  {
                    envios.add(envio1);
                }
            }
        }


    }

    public Envio buscarEnvio(String codigo){
       for (Envio envio : envios) {
           if (envio.getCodigo().equals(envio.getCodigo())){
               return envio;
           }

       } return null;
    }

    public int cantidadEnvios(Envio envio){

        return envios.size();
    }

    public void listarEnvios (){
        for (Envio envio1 : envios) {
            System.out.println(envio1);
        }

    }
}
