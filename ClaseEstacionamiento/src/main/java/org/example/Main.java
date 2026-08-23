package org.example;



import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.jar.JarException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        //Variable de las opciones
        int opcion = 0;

        autoVehiculo auto = null;


        //Menu

        while (opcion != 5) {
            try {
                System.out.println("===== ARRIENDO DE VEHÍCULOS =====\n" +
                        "\n" +
                        "1. Ingresar datos del auto\n" +
                        "\n" +
                        "2. Mostrar datos del auto\n" +
                        "\n" +
                        "3. Calcular valor de arriendo\n" +
                        "\n" +
                        "4. Calcular arriendo con descuento\n" +
                        "\n" +
                        "5. Salir\n");
                System.out.println(("Ingrese una opción: "));
                opcion = input.nextInt();
                input.nextLine();

                if (opcion >= 1 && opcion <= 5) {

                    switch (opcion) {
                        case 1:
                            System.out.println("== Ingrese los datos del auto ==");
                            System.out.println("Ingrese la patente del auto: ");
                            String patente = input.nextLine();
                            System.out.println("Ingrese la marca del auto");
                            String marca = input.nextLine();
                            System.out.println("Ingrese el valor de arriendo del auto: ");
                            int precioPorDia = input.nextInt();
                            input.nextLine();
                            System.out.println("Ingrese el color del auto: ");
                            String color = input.nextLine();

                            auto = new autoVehiculo(patente, marca, precioPorDia, color);

                            System.out.println("¡¡Datos del auto ingresados correctamente!!");


                            break;

                        case 2:
                            if (auto != null) {
                                auto.imprimirDatos();
                            } else {
                                System.out.println("No hay datos de ningún auto");
                            }

                            break;


                        case 3:
                            if (auto != null) {
                                System.out.println("Ingrese los días de arriendo del auto: ");
                                int dias = input.nextInt();
                                input.nextLine();

                                System.out.println("El valor del arriendo total es: " + auto.calcularTotalArriendo(dias));


                            } else {
                                System.out.println("No hay datos del auto");
                            }
                            break;
                        case 4:
                            if (auto != null) {
                                System.out.println("Ingrese los días de arriendo del auto: ");
                                int dias = input.nextInt();
                                input.nextLine();
                                System.out.println("Ingrese el valor del descuento del auto: ");
                                int descuento = input.nextInt();
                                input.nextLine();
                                System.out.println("El valor total del arriendo con descuento es: " + auto.calcularTotalArriendo(dias, descuento));

                            } else {
                                System.out.println("No hay datos del auto");
                            }


                            break;
                        case 5:
                            System.out.println("Gracias por utilizar nuestra APP, !!Que tenga un buen día!!");
                            break;
                        default:
                            System.out.println("¡La Opción ingresada no existe!");
                            break;
                        //Esta opción, por lo que entendí, no debería porqué ejecutarse, a no ser que se cambie la primera validación que esta antes de entrar al switch

                    }
                } else {
                    System.out.println();
                    System.out.println("ERROR");
                    System.out.println("Opción no encontrada");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR \nSolo puede ingresar números enteros");
                input.nextLine();
            }
        }





        }
    }
