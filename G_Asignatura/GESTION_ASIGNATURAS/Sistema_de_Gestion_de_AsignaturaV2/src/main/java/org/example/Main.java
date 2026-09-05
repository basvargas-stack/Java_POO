package org.example;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int opcion = 99999;
        Alumno alumno1 =  null;
        Profesor profesor1 = null;

        Scanner input = new Scanner(System.in);

        Asignatura asignatura = new Asignatura("DSY1102", "Desarrollo Orientado a Objetos", 6,null, null
                );





        while (opcion != 0){
            System.out.print("""
                    ========================================
                     SISTEMA DE GESTIÓN DE ASIGNATURA
                    ========================================
                    1. Crear Alumno
                    2. Crear Profesor
                    3. Mostrar Alumno
                    4. Mostrar Profesor
                    5. Mostrar Asignatura
                    6. Realizar actividad del Alumno
                    7. Realizar actividad del Profesor
                    8. Demostrar polimorfismo con Alumno
                    9. Demostrar polimorfismo con Profesor
                    0. Salir
                    ========================================
                    Seleccione una opción:
                    
                    """);
            try{
            System.out.print("Ingrese una opcion: ");
            opcion = input.nextInt();
            }   catch(Exception e){
                System.out.println("Error: debe ingresar un número entero.");

            }
            if (opcion >= 0 && opcion <= 9) {
                switch (opcion) {
                    case 1:
                        System.out.println();
                        System.out.print("CREAR ALUMNO");
                        System.out.println();

                        System.out.print("Ingrese el run: ");
                        String runAlumno = input.nextLine();
                        input.nextLine();

                        System.out.println("Ingrese nombre:");
                        String nombreAlumno = input.next();
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese apellido:");
                        String apellidoAlumno = input.next();
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese la fecha de nacimiento:");
                        LocalDate fechaNacimientoAlumno = LocalDate.parse(input.next());
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese el numero de matricula:");
                        int numeroMatriculaAlumno = input.nextInt();
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese el promedio:");
                        double promedio = input.nextDouble();

                        alumno1 = new Alumno(runAlumno, nombreAlumno, apellidoAlumno, fechaNacimientoAlumno, numeroMatriculaAlumno, promedio,
                                asignatura);


                        break;
                    case 2:
                        System.out.println();
                        System.out.println("CREAR PROFESOR");
                        System.out.print("Ingrese el run: ");
                        String run = input.nextLine();
                        input.nextLine();

                        System.out.println("Ingrese nombre:");
                        String nombre = input.next();
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese apellido:");
                        String apellido = input.next();
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese la fecha de nacimiento:");
                        LocalDate fechaNacimiento = LocalDate.parse(input.next());
                        input.nextLine();

                        System.out.println();
                        System.out.println("Ingrese la especialidad:");
                        String especialidad = input.next();

                        System.out.println();
                        System.out.println("Ingrese las horas semanales");
                        int horasSemanales = input.nextInt();
                        input.nextLine();

                        profesor1 = new Profesor(run, nombre, apellido, fechaNacimiento, especialidad, horasSemanales, asignatura);


                        break;
                    case 3:
                        System.out.println();
                        System.out.println("MOSTRAR ALUMNO");
                        if (alumno1 == null) {
                            System.out.println("Error: No existe ningún alumno.");
                        } else {
                            alumno1.mostrarDatosPersonales();
                        }


                        break;
                    case 4:
                        System.out.println();
                        System.out.println("MOSTRAR PROFESOR");
                        if (profesor1 == null) {
                            System.out.println("Error: no existe ningún profesor.");

                        } else {
                            profesor1.mostrarDatosPersonales();
                        }
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("ASIGNATURA");
                        asignatura.mostrarAsignatura();
                        break;
                    case 6:
                        System.out.println();
                        break;
                    case 7:
                        System.out.println();
                        break;
                    case 8:
                        System.out.println();
                        break;
                    case 9:
                        System.out.println();
                        break;
                    case 0:
                        System.out.println();
                        System.out.println("Gracias por utilizar nuestra APP");
                        break;
                    default:
                        System.out.println("Opción fuera de rango");
                        break;
                }
            }







            }

        }

    }
