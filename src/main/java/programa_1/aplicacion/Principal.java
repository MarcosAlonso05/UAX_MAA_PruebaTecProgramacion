package main.java.programa_1.aplicacion;

import main.java.programa_1.mates.Matematicas;

public class Principal {
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("No se ha encontrado argumentos");
            return;
        }

        long pasos = Long.parseLong(args[0]);
        double pi_aprox = Matematicas.generarNumeroPi(pasos);

        System.out.println("El número PI es " + pi_aprox);
        System.out.println("Con un error porcentual de: " + (Math.abs((Math.PI - pi_aprox) / Math.PI) * 100) + "%");

    }
}
