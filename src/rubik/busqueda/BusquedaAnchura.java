package rubik.busqueda;

import java.util.LinkedList;
import java.util.Vector;

/* Estrategia de Busqueda en arbol en Anchura, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaArbol (generica independiente de la estrategia)
 * Implementa el metodo buscarSolucion() y devuelve un vector de operadores (solución)
 */


public class BusquedaAnchura extends BusquedaArbol implements Busqueda {

    @Override
    
  public Vector<Operador> buscarSolucion(Estado inicial){
     // Usa lista ABIERTOS (LinkedList)
    abierta = new LinkedList<NodoBusqueda>(); 
    NodoBusqueda nodoSolucion = null;       
    
    /*
     * ......
     */

    if(nodoSolucion == null) {
      return new Vector<Operador>();
    }
    else {
      return encontrarCamino(nodoSolucion); 
    }
  }	

}
