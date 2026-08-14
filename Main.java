package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        estudiantePersona estudiante1 = new estudiantePersona("20982706-9", "bastian", "VF",
                 12, "Inge. comercial", 160000);


        profesorPersona profesor1 = new profesorPersona("19891567-1", "Jaimeme", "Mowen",
                        "32", 900000, "Ing. comercial");

        System.out.println(estudiante1);

        System.out.println(profesor1);

    }
}