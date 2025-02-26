package main.java.programa_2.dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Esta clase es responsable de leer el tablero de un
 * fichero en forma de ceros y unos, ir transitando de
 * estados e ir mostrando dichos estados.
 */

public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente;

    public Tablero() {

        estadoActual = new int[DIMENSION][DIMENSION];
        estadoSiguiente = new int[DIMENSION][DIMENSION];
    }

    /********************************************************
     * Lee el estado inicial de un fichero llamado ‘matriz‘.
     ********************************************************/

    public void leerEstadoActual() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/programa_2/dominio/matriz.txt"))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null && fila < DIMENSION) {
                try {
                    for (int col = 0; col < DIMENSION; col++) {
                        if (col < linea.length() && (linea.charAt(col) == '0' || linea.charAt(col) == '1')) {
                            estadoActual[fila][col] = linea.charAt(col) - '0';
                        } else {
                            estadoActual[fila][col] = 0;
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Advertencia: línea más corta que la dimensión esperada en fila " + fila);
                }
                fila++;
            }

            while (fila < DIMENSION) {
                for (int col = 0; col < DIMENSION; col++) {
                    estadoActual[fila][col] = 0;
                }
                fila++;
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }

        generarEstadoSiguiente();
    }

    /********************************************************
     * Generar un estado inicial por Montecarlo
     ********************************************************/

    public void generarEstadoActualPorMontecarlo() {
        Random r = new Random();

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = r.nextDouble() < 0.5 ? 1 : 0;
            }
        }
        generarEstadoSiguiente();
    }

    /********************************************************
     * Transitar Al Estado Siguiente
     ********************************************************/

    public void transitarEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = estadoSiguiente[i][j];
            }
        }

        generarEstadoSiguiente();
    }

    /********************************************************
     * Generar el Estado siguiente
     ********************************************************/

    private void generarEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {

                int vivos = contarVecinosVivos(i, j);

                if (estadoActual[i][j] == 1) {
                    estadoSiguiente[i][j] = (vivos == 2 || vivos == 3) ? 1 : 0;
                } else {
                    estadoSiguiente[i][j] = (vivos == 3) ? 1 : 0;
                }
            }
        }
    }
    private int contarVecinosVivos(int x, int y) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int vx = x + i;
                    int vy = y + j;
                    if (vx >= 0 && vx < DIMENSION && vy >= 0 && vy < DIMENSION) {
                        contador += estadoActual[vx][vy];
                    }
                }
            }
        }
        return contador;
    }

    /*******************************************************
     * Devuelve, en modo texto, el estado actual.
     * return el estado actual.
     *******************************************************/

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                sb.append(estadoActual[i][j] == 1 ? "x" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
