# UAX_MAA_PruebaTecProgramacion

## Descripción
Este repositorio trata de tres programas creados como practicas de programacion.
A ellos se pueden acceder como usuario desde un Main principal que tiene acesso a cada uno.
Ademas, en el repositorio se encuentra una carpeta con los diagramas con los que se planificaron cada programa
A continuación se detallan las prácticas implementadas, su funcionamiento, y las notas para usuarios y desarrolladores.

## Práctica 1: Aproximación al número Pi mediante Montecarlo

### Descripción
Esta práctica implementa un algoritmo para aproximar el valor de Pi utilizando el método de Montecarlo. 
El algoritmo genera puntos aleatorios dentro de un cuadrado y cuenta cuántos caen dentro de un círculo inscrito para estimar Pi.

## Práctica 2: El Juego de la Vida

### Descripción
Esta práctica implementa una versión del **Juego de la Vida** de Conway. El programa simula la evolución de un tablero de células basado en reglas simples que determinan si una célula vive, muere o nace en cada iteración. El tablero inicial puede leerse desde un archivo o generarse aleatoriamente utilizando el método de Montecarlo.

### Reglas del Juego
1. **Supervivencia**: Una célula viva con 2 o 3 células vecinas vivas permanece viva.
2. **Muerte**: Una célula viva con menos de 2 o más de 3 células vecinas vivas muere.
3. **Nacimiento**: Una célula muerta con exactamente 3 células vecinas vivas nace.

## Práctica 3: Búsqueda de un Camino en un Grafo

### Descripción
Esta práctica implementa una estructura de datos de grafo y un algoritmo para encontrar un camino entre dos vértices utilizando una **búsqueda en profundidad (DFS)**. El grafo se representa mediante una lista de adyacencia, lo que permite manejar relaciones entre vértices de manera eficiente.

### Funcionalidades
- **Añadir vértices**: Permite añadir nuevos vértices al grafo.
- **Añadir aristas**: Permite añadir aristas entre vértices existentes o nuevos.
- **Obtener vértices adyacentes**: Devuelve los vértices adyacentes a un vértice dado.
- **Búsqueda de camino**: Encuentra un camino entre dos vértices utilizando DFS.

# Uso del Programa

El programa principal (`Main`) proporciona un menú interactivo para ejecutar las tres prácticas implementadas. 
A continuación se detalla cómo usarlo.

### Ejecucion
1. Clona el repositorio.
2. Navega a la carpeta del proyecto.
3. Compila y ejecuta el programa principal

## Requisitos
- **Java JDK 8 o superior**: Asegúrate de tener instalado Java en tu sistema.
- **Compilador de Java**: Para compilar y ejecutar el programa.

# LINK AL REPOSITORIO 
https://github.com/MarcosAlonso05/UAX_MAA_PruebaTecProgramacion