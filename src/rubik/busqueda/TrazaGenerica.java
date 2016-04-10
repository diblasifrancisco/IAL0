package rubik.busqueda;

import java.util.LinkedList;

/** Permite visualizar cada estado de la forma: 
 * Accion: <estado,(costo),profundidad>
 * Se imprime por pantalla el estado inicial 
 * y en cada interacción, al inicio, lista de estados de la frontera, 
 * y al final de la interacción el estado evaluado y sus hijos
 * Inteligencia Artificial 2016
 */
public class TrazaGenerica {
     public TrazaGenerica (NodoBusqueda nodo){}
    //Este metodo debe llamarse despues de la expansion del nodo actual evaluado.

    public void imprimirFinalIteracion(NodoBusqueda actual, LinkedList<NodoBusqueda> sucesores){}
    //Este metodo debe llamarse antes de extraer un nodo de la lista abierta

    public void imprimirInicioIteracion(LinkedList<NodoBusqueda> abierta){}
    
    private String toStringListaNodos(LinkedList<NodoBusqueda> a){
        return "";
    }
}