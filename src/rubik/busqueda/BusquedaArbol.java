package rubik.busqueda;

import java.util.LinkedList;
import java.util.Vector;

/** Clase abstracta que guarda las implementaciones genericas para una Busqueda en Arbol
 * Hereda de la clase RendimientoBusqueda, 
 * para calcular medidas de evaluacion de las estrategias de busqueda
 * Usa lista ABIERTOS (LinkedList)
 * implementa el metodo expandirNodo()
 * implementa el metodo encontrarCamino()
 */

public abstract class BusquedaArbol extends RendimientoBusqueda{
	LinkedList<NodoBusqueda> abierta;
	TrazaGenerica traza;

  protected LinkedList<NodoBusqueda> expandirNodo(NodoBusqueda nodoPadre) {
            LinkedList<NodoBusqueda> expandidos = new LinkedList<NodoBusqueda>();
            
     /*
     * ......
     */

 return expandidos;
  }

  protected Vector<Operador> encontrarCamino(NodoBusqueda nodoFinal) {
    Vector<Operador> camino = new Vector<Operador>();
            
     /*
     * ......
     */
    
    System.out.println("\n REPORTE DE BUSQUEDA");
    System.out.println("---------------------------------------");
    //Imprimo Reporte de busqueda antes de retornar el camino para llegar a la solucion
    return camino;
  }

}
