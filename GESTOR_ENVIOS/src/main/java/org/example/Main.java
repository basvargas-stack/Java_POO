package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        gestorEnvios gestor = new gestorEnvios();

        Scanner input = new Scanner(System.in);

        int opc = 99999;


        while (opc != 5) {

            mostrarMenu();
            try {
                opc = Integer.parseInt(input.nextLine());
                if (opc < 1) {
                    throw new IllegalArgumentException("La opción no puede ser 0 o un numero negativo");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: solo puede ingresar numeros enteros positivos.");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
            switch (opc) {
                case 1:
                    CrearEnvio(input, gestor);
                    break;
                case 2:
                    BuscarCodigo(input, gestor);
                    break;
                case 3:
                    calcularCosto(input, gestor);
                    break;
                case 4:
                    calculoDeSeguro(input, gestor);
                    break;
                case 5:
                    System.out.println("Gracias por usar nuestra APP");
                    break;
                case 6:
                    gestor.listarEnvios();
                    break;
                default:
                    System.out.println("La opción esta fuera del rango");
                    break;

            }
        }

    }


    public static double procesarCalculoSeguro(Asegurable objeto) {

        return objeto.calcularSeguro();
    }


    public static void mostrarMenu() {

        System.out.println("""
                ========================================
                 SISTEMA DE GESTION DE ENVIOS
                ========================================
                1. Crear envio
                2. Buscar por codigo
                3. Calcular costo del envio
                4. Calcular seguro internacional
                5. Salir
                ========================================
                Seleccione una opcion:
                
                """);
    }

    public static void CrearEnvio(Scanner input, gestorEnvios gestor) {

        System.out.println();
        System.out.println("===== Crear Envio =====");
        System.out.println("1.- Envio internacional\n2.- Envio nacional");
        try {
            int opc = Integer.parseInt(input.nextLine());
            if (opc == 1 || opc == 2) {
                switch (opc) {
                    case 1:
                        System.out.println();
                        System.out.println("Ingrese el codigo del envio");
                        String codigoIn = input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese la distancia del envio");
                        double distanciaIn = Double.parseDouble(input.nextLine());

                        System.out.println();
                        System.out.println("Ingrese el peso del envio");
                        double pesoIn = Double.parseDouble(input.nextLine());

                        System.out.println();
                        System.out.println("Ingrese el pais de destino del envio");
                        String pais = input.nextLine();

                        System.out.println();
                        System.out.println("¿La documentacion esta al dia?\n1.-Si\n2.-No");
                        int op2 = Integer.parseInt(input.nextLine());

                        if (op2 == 1) {
                            boolean Documentacion = true;
                            Envio internacional = new envioInternacional(codigoIn, distanciaIn, pesoIn, pais, Documentacion);
                            gestor.registrarEnvio(internacional);
                        } else if (op2 == 2) {
                            boolean Documentacion = false;
                            Envio internacional = new envioInternacional(codigoIn, distanciaIn, pesoIn, pais, Documentacion);
                            gestor.registrarEnvio(internacional);
                        } else {
                            throw new IllegalArgumentException("Solo puede ingresar 1 o 2 en la documentacion.");
                        }
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Ingrese el codigo del envio");
                        String codigoNa = input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese la distancia del envio");
                        double distanciaNa = Double.parseDouble(input.nextLine());

                        System.out.println();
                        System.out.println("Ingrese el peso del envio");
                        double pesoNa = Double.parseDouble(input.nextLine());

                        System.out.println();
                        System.out.println("Ingrese la región de destino del envio");
                        String region = input.nextLine();

                        System.out.println();
                        System.out.println("¿El envio es urgente?\n1.-Si\n2.-No");
                        int op3 = Integer.parseInt(input.nextLine());
                        if (op3 == 1) {
                            boolean Urgente = true;
                            Envio Nacional = new envioNacional(codigoNa, distanciaNa, pesoNa, region, Urgente);
                            gestor.registrarEnvio(Nacional);
                            break;
                        } else if (op3 == 2) {
                            boolean Urgente = false;
                            Envio Nacional = new envioNacional(codigoNa, distanciaNa, pesoNa, region, Urgente);
                            gestor.registrarEnvio(Nacional);
                            break;
                        } else {
                            throw new IllegalArgumentException("Solo puede ingresar 1 o 2 en la urgencia.");
                        }

                }
            } else {
                System.out.println("Solo puede ingresar 1 o 2 como opción");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: solo puede ingresar numeros");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }


    public static void BuscarCodigo(Scanner input, gestorEnvios gestor) {
        System.out.println("Ingrese el codigo del envio a buscar");
        String codigoEnvio = input.nextLine();

        Envio envio = gestor.buscarEnvio(codigoEnvio);
        if (envio != null) {
            System.out.println("Producto encontrado");
            System.out.println(envio);
        } else {
            System.out.println("El codigo ingresado no existe");
        }


    }


    public static void calcularCosto(Scanner input, gestorEnvios gestor) {
        System.out.println();
        System.out.println("Ingrese el codigo del envio");
        String codigoEnvio = input.nextLine();

        Envio envio = gestor.buscarEnvio(codigoEnvio);

        if (envio != null) {
            System.out.println("El costo de este envio es de $" + envio.calcularCosto());
        } else {
            System.out.println("El codigo ingresado no existe");
        }

    }


    public static void calculoDeSeguro(Scanner input, gestorEnvios gestor) {

        System.out.println("Ingrese el codigo del envio");
        String codigoEnvio = input.nextLine();

        Envio envio = gestor.buscarEnvio(codigoEnvio);
        try {
            if (envio != null) {

                System.out.println(procesarCalculoSeguro((Asegurable) envio));

            }

            }catch (ClassCastException e) {
            System.out.println("El envio debe ser internacional");
        }

    }

    }
