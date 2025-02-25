import programa_1.aplicacion.Principal;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ejecutar programa 1:");

        String[] argumentos = {"200000"};
        programa_1.aplicacion.Principal.main(argumentos);

        System.out.println("Ejecutar programa 2:");
        programa_2.aplicacion.Principal.main(new String[0]);
    }
}