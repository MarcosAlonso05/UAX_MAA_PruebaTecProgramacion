package main.java.programa_1.mates;

import java.util.Random;

public class Matematicas {

    /**
     * Genera una aproximación al número pi mediante Montecarlo
     * El parámetro ‘pasos‘ indica el número de puntos
     * generados.
     */

    private Matematicas() {}

    public static double generarNumeroPi(long pasos){
        long aciertos = 0;
        Random random = new Random();

        for (int i = 0; i < pasos; i++) {
            double x = -1 + 2 * random.nextDouble();
            double y = -1 + 2 * random.nextDouble();

            if (x * x + y * y <= 1){
                aciertos++;
            }
        }
        return 4.0 * aciertos / pasos;
    }


}
