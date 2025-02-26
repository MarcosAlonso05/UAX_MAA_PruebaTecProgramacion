package programa_3.aplicacion;

import programa_3.grafo.Graph;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        Graph<String> grafo = new Graph<>();

        System.out.print("Ingrese vertices del grafo (separados por espacios): ");
        String[] vertices = entrada.nextLine().split(" ");

        for (String vertex : vertices) {
            grafo.addVertex(vertex);
        }

        System.out.println("Ingrese las aristas del grafo (origen destino). Escriba 'fin' para terminar:");
        while (true) {
            System.out.print("Arista: ");
            String input = entrada.nextLine();

            if (input.equalsIgnoreCase("fin")) {
                break;
            }

            String[] edge = input.split(" ");
            if (edge.length != 2) {
                System.out.println("Formato incorrecto");
                continue;
            }

            grafo.addEdge(edge[0], edge[1]);
        }

        System.out.println("Ingresa los vertices para buscar un puente (origen destino): ");

        String[] pathInput = entrada.nextLine().split(" ");
        if (pathInput.length != 2) {
            System.out.println("Formato incorrecto. Debe ingresar dos vértices.");
        } else {
            List<String> puente = grafo.onePath(pathInput[0], pathInput[1]);

            if (puente != null) {
                System.out.println("Camino encontrado: " + puente);
            } else {
                System.out.println("No se encontró un camino.");
            }
        }
    }
}
