package programa_3.grafo;

import java.util.*;

public class Graph<V>{

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /********************************************************
     * Añade el vértice ‘v‘ al grafo.
     ********************************************************/

    public boolean addVertex(V v){
        if(adjacencyList.containsKey(v)){
            return false;
        }
        adjacencyList.put(v, new HashSet<>());
        return true;
    }

    /********************************************************
     * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo.
     ********************************************************/

    public boolean addEdge(V v1, V v2){
        addVertex(v1);
        addVertex(v2);

        Set<V> set = adjacencyList.get(v1);
        if (set.contains(v2)){
            return false;
        }

        set.add(v2);
        return true;
    }

    /********************************************************
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
     ********************************************************/

    public Set<V> obtainAdjacents(V v) throws Exception{
        if(!adjacencyList.containsKey(v)){
            throw new Exception("El vertice no existe");
        }
        return adjacencyList.get(v);
    }

    /********************************************************
     * Comprueba si el grafo contiene el vértice dado.
     ********************************************************/

    public boolean containsVertex(V v){
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    /********************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y
     *  ‘v2‘. En caso contrario, devuelve ‘null‘.
     ********************************************************/

    public List<V> onePath(V v1, V v2){
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return null;
        }

        Map<V,V> traza = new HashMap<>();
        Stack<V> abierta = new Stack<>();

        abierta.push(v1);
        traza.put(v1, null);

        boolean encontrado = false;

        while (!abierta.isEmpty() && !encontrado) {
            V u = abierta.pop();

            if (u.equals(v2)) {
                encontrado = true;
            } else {
                for (V s : adjacencyList.get(u)) {
                    if (!traza.containsKey(s)) {
                        abierta.push(s);
                        traza.put(s, u);
                    }
                }
            }
        }

        if (encontrado) {
            List<V> res = new ArrayList<>();
            V u = v2;
            while (u != null) {
                res.add(u);
                u = traza.get(u);
            }

            Collections.reverse(res);
            return res;
        } else {
            return null;
        }
    }
}