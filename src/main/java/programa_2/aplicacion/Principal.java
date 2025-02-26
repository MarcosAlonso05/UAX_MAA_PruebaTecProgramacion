package programa_2.aplicacion;

import programa_2.dominio.Tablero;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Principal {
    public static void main(String[] args) {

        Scanner opc = new Scanner(System.in);

        System.out.println("Elige una opción:");
        System.out.println("1. Simulación con Matriz personalizada");
        System.out.println("2. Simulación con Matriz generada mediante Montecarlo");
        System.out.print("Opción: ");
        int opcion1 = opc.nextInt();

        try{
            Tablero tablero = new Tablero();
            switch (opcion1) {
                case 1:
                    System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
                    tablero.leerEstadoActual();
                    System.out.println(tablero);
                    for (int i = 0; i < 5; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        tablero.transitarEstadoSiguiente();
                        System.out.println(tablero);
                    }
                    break;
                case 2:
                    System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
                    tablero.generarEstadoActualPorMontecarlo();
                    System.out.println(tablero);
                    for (int i = 0; i < 15; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        tablero.transitarEstadoSiguiente();
                        System.out.println(tablero);
                    }
                    break;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
