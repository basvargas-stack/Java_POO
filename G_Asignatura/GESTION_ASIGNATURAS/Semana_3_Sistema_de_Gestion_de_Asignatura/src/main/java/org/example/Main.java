package org.example;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Alumno alumno = null;
        Profesor profesor = null;

        Asignatura asignatura1 = new Asignatura("DSY10010", "Programacion orientada a objetos", 6,
                null, null);

        int opcion = 99999;

        Scanner input = new Scanner(System.in);





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
            if (opcion >= 0 && opcion <= 9){
                switch (opcion){
                    case 1:
                        System.out.println();
                        System.out.println("Crear alumno");
                        System.out.println();

                        System.out.println("Ingrese el run del alumno: ");
                        String runAlumno = input.nextLine();
                        input.nextLine();
                        System.out.print("Ingrese el nombre del alumno: ");
                        String nombreAlumno = input.next();
                        input.nextLine();
                        System.out.print("Ingrese el apellido del alumno: ");
                        String apellidoAlumno = input.next();
                        input.nextLine();

                        System.out.print("Ingrese la fecha de nacimiento del alumno: ");
                        LocalDate fechaNacimientoAlumno = LocalDate.parse(input.nextLine());


                        System.out.print("Ingrese el numero de la matricula del alumno: ");
                        int numeroMatriculaAlumno = input.nextInt();
                        input.nextLine();

                        System.out.print("Ingrese el promedio del alumno: ");
                        double promedioAlumno = input.nextDouble();

                        System.out.print("Alumno creado exitosamente  ");
                        alumno = new Alumno(runAlumno, nombreAlumno, apellidoAlumno, fechaNacimientoAlumno, numeroMatriculaAlumno,
                        promedioAlumno, asignatura1);

                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Crear profesor");
                        System.out.println();

                        System.out.println("Ingrese el run del profesor: ");
                        String runProfesor = input.nextLine();
                        input.nextLine();
                        System.out.print("Ingrese el nombre del profesor: ");
                        String nombreProfesor = input.next();
                        input.nextLine();
                        System.out.print("Ingrese el apellido del profesor: ");
                        String apellidoProfesor = input.next();
                        input.nextLine();

                        System.out.print("Ingrese la fecha de nacimiento del profesor: ");
                        LocalDate fechaNacimientoProfesor = LocalDate.parse(input.nextLine());
                        input.nextLine();

                        System.out.print("Ingrese la especialidad del profesor ");
                        String especialidadProfesor = input.nextLine();
                        input.nextLine();

                        System.out.print("Ingrese las horas semanales del profesor: ");
                        int horasSemanales = input.nextInt();
                        input.nextLine();

                        System.out.println("Profesor creado exitosamente  ");

                        profesor = new Profesor(runProfesor, nombreProfesor,apellidoProfesor, fechaNacimientoProfesor, especialidadProfesor,
                                horasSemanales, asignatura1);


                        break;
                    case 3:
                        System.out.println();
                        if (alumno != null) {
                            alumno.mostrarDatosPersonales();
                        } else {
                            System.out.println("No existe el alumno");
                        }

                        break;
                    case 4:
                        System.out.println();
                        if (profesor != null) {
                            profesor.mostrarDatosPersonales();
                        } else {
                            System.out.println("No existe el profesor");
                        }


                        break;
                    case 5:
                        System.out.println();
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
