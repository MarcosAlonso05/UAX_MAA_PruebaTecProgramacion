package main.java;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("1) Programa 1");
        System.out.println("2) Programa 2 ");
        System.out.println("3) Programa 3 ");
        System.out.println("0) Salir");
        System.out.println();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 1;

        System.out.println("UAX TECNICAS DE PROGRAMA");

        while (opcion != 0) {
            menu();
            System.out.print("||Seleccione opcion ---> ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando programa 1:");

                    System.out.println("== Generar pi con Montecarlo ==");

                    System.out.print("Introduce el numero de puntos a generar: ---> ");
                    String valor1 = sc.nextLine();
                    String[] argumentos = {valor1};
                    main.java.programa_1.aplicacion.Principal.main(argumentos);

                    break;

                case 2:
                    System.out.println("Ejecutando programa 2:");

                    System.out.println("== Juego de la Vida ==");

                    main.java.programa_2.aplicacion.Principal.main(new String[0]);

                    break;

                case 3:
                    System.out.println("Ejecutando programa 3:");

                    System.out.println("== Estructura de Datos de Grafo ==");

                    main.java.programa_3.aplicacion.Principal.main(new String[0]);

                    break;

                case 0:
                    System.out.println(">Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}