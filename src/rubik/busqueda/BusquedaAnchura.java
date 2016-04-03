package rubik.busqueda;

import java.util.LinkedList;
import java.util.Vector;

/* Estrategia de Busqueda en arbol en Anchura, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaArbol (generica independiente de la estrategia)
 * Implementa el metodo buscarSolucion() y devuelve un vector de operadores (solución)
 */


public class BusquedaAnchura extends BusquedaArbol {

    
      /**
      * busca la solucion, es decir el listado de acciones para resolver el problema de busqueda  
      * por busqueda primero en anchu obteniendo el primer elemento de la cola y colocando 
      * los nodos expandidos al final
    */
    @Override
    public Vector<Operador> buscarSolucion(Estado inicial){
        //Antes de comenzar la busqueda se contabiliza tiempo llamando metodo de la clase RendimientoBusqueda
        this.reporteInicioBusqueda();

        listaAbierta = new LinkedList<NodoBusqueda>();
        Boolean solucionEncontrada = false; 
        NodoBusqueda nodoSolucion = null;
        NodoBusqueda nodoActual = new NodoBusqueda(inicial,null,null);
                    nodoActual.setProfundidad(0);   
                    nodoActual.setCosto(0); 
        //creo una Traza con el nodo raiz(actual)
        traza = new TrazaGenerica(nodoActual);
        listaAbierta.add(nodoActual);
        while(!solucionEncontrada) {
          if(listaAbierta.size() == 0) {
            break;  
          }
          else {
            //muestro estado de lista abierta al coienzo de cada interación
            traza.imprimirInicioIteracion(listaAbierta);
            nodoActual = listaAbierta.pollFirst();
           //Antes de evaluar si el nodo es solución contabilizo nodos explorados con la clase RendimientoBusqueda
           this.reporteNodosExplorados();

            //if(!listaCerrada.containsKey(nodoActual.getEstado())) {

            if(nodoActual.getEstado().esFinal()) {
                solucionEncontrada = true;
                nodoSolucion = nodoActual;
            }
              // si el estado actual no es objetivo lo expando (genero y pongo hijos)
            else {

              listaAbierta.addAll(expandirNodo(nodoActual));

              traza.imprimirFinalIteracion(nodoActual, listaAbierta);
            }    
          }
        }
        // al terminar contabilizo nodos sobrantes con la clase RendimientoBusqueda
        this.reporteNodosSobrantes(listaAbierta.size());
        // Contabilizo tiempo al finalizar busqueda con la clase RendimientoBusqueda
        this.reporteFinBusqueda();
        System.out.println(this.getReporteCompleto());

        if(nodoSolucion == null) {
          return new Vector<Operador>();
        }
        else {
          return encontrarCamino(nodoSolucion);
        }
    }

}
