package rubik.busqueda;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/** Clase abstracta que guarda las implementaciones genericas para una Busqueda en Grafo
 * Hereda de la clase RendimientoBusqueda, 
 * para calcular medidas de evaluacion de las estrategias de busqueda
 * Usa lista ABIERTOS (LinkedList) y lista CERRADOS (Hastable) usando Estado como clave
 * implementa el metodo expandirNodo()
 * implementa el metodo encontrarCamino()
 */

public abstract class BusquedaGrafo  extends RendimientoBusqueda{
        HashMap<Estado, NodoBusqueda> listaCerrada; 
        LinkedList<NodoBusqueda>      listaAbierta;
	TrazaGenerica traza;

 protected LinkedList<NodoBusqueda> expandirNodo(NodoBusqueda nodoPadre) {
        LinkedList<NodoBusqueda> expandidos = new LinkedList<NodoBusqueda>(); 
        for(Operador oper : nodoPadre.getEstado().operadoresAplicables()) {
          NodoBusqueda n = new NodoBusqueda(nodoPadre.getEstado().aplicarOperador(oper),nodoPadre,oper);
                            n.setProfundidad(nodoPadre.getProfundidad() + 1); 
                            n.setCosto(nodoPadre.getCosto() + 1);             
          if(!listaCerrada.containsKey(n.getEstado())) {
            expandidos.add(n); 
          }
        }
	 //TRAZA muestro la lista de hijos del nodo padre expandido
         return expandidos;
  }

  protected Vector<Operador> encontrarCamino(NodoBusqueda nodoFinal) {
    Vector<Operador> camino = new Vector<Operador>(); 
    NodoBusqueda nodoPaso = nodoFinal;
    while(nodoPaso.getPadre() != null) {
      camino.insertElementAt(nodoPaso.getOperador(), 0); 
      nodoPaso = (NodoBusqueda)nodoPaso.getPadre(); 
    }
    
    System.out.println("\n REPORTE DE BUSQUEDA");
    System.out.println("---------------------------------------");
    //Imprimo Reporte de busqueda antes de retornar el camino para llegar a la solucion
    
    return camino;
  }

}
