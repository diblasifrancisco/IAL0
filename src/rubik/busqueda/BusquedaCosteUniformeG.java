package rubik.busqueda;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/** Estrategia de Busqueda en grafo Costo Uniforme, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaGrafo (generica independiente de la estrategia)
 * Implementa el metodo buscarSolucion() y devuelve un vector de operadores (solucion)
 */

public class BusquedaCosteUniformeG extends BusquedaGrafo {
    
    /**
     Busca la solución controlando estados repetidos en lista cerrada al quitar un nodo de lista abierta
    */
    @Override
    public Vector<Operador> busquedaGrafoA(Estado inicial){
        //Antes de comenzar la busqueda se contabiliza tiempo llamando metodo de la clase RendimientoBusqueda
        this.rendimiento.reporteInicioBusqueda();

        listaCerrada = new HashMap<Estado, NodoBusqueda>();
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
            //nodoActual = this.getNodoMenorCostoListaAbierta();
            nodoActual = listaAbierta.pollFirst();
            //Antes de evaluar si el nodo es solución contabilizo nodos explorados con la clase RendimientoBusqueda
            this.rendimiento.reporteNodosExplorados();

            //if(!listaCerrada.containsKey(nodoActual.getEstado())) {
            if(!this.isEnCerrada(nodoActual)) {  
                if(nodoActual.getEstado().esFinal()) {
                    solucionEncontrada = true;
                    nodoSolucion = nodoActual;
                  }
                // si el estado actual no es objetivo lo expando (genero y pongo hijos)
                else {
                  listaCerrada.put(nodoActual.getEstado(), nodoActual);
                  //listaAbierta.addAll(expandirNodo(nodoActual));
                  this.ordenarListaAbierta(expandirNodo(nodoActual));
                  traza.imprimirFinalIteracion(nodoActual, listaAbierta);
                }
            }
          }
        }
        // al terminar contabilizo nodos sobrantes con la clase RendimientoBusqueda
        this.rendimiento.reporteNodosSobrantes(listaAbierta.size());
        // Contabilizo tiempo al finalizar busqueda con la clase RendimientoBusqueda
        this.rendimiento.reporteFinBusqueda();
        System.out.println(this.rendimiento.getReporteCompleto());

        if(nodoSolucion == null) {
          return new Vector<Operador>();
        }
        else {
          return encontrarCamino(nodoSolucion);
        }
    }
    
    /**
     Busca la solución controlando estados repetidos en lista cerrada y abierta al generar hijos
    */
    @Override
    public Vector<Operador> busquedaGrafoB(Estado inicial){
        //Antes de comenzar la busqueda se contabiliza tiempo llamando metodo de la clase RendimientoBusqueda
        this.rendimiento.reporteInicioBusqueda();

        listaCerrada = new HashMap<Estado, NodoBusqueda>();
        listaAbierta = new LinkedList<NodoBusqueda>();
        Boolean solucionEncontrada = false; 
        NodoBusqueda nodoSolucion = null;
        NodoBusqueda nodoActual = new NodoBusqueda(inicial,null,null);
                    nodoActual.setProfundidad(0);   
                    nodoActual.setCosto(0); 
        traza = new TrazaGenerica(nodoActual);
        listaAbierta.add(nodoActual);
        while(!solucionEncontrada) {
          if(listaAbierta.size() == 0) {
            break;  
          }
          else {
            //muestro estado de lista abierta al coienzo de cada interación
            traza.imprimirInicioIteracion(listaAbierta);
            //nodoActual = this.getNodoMenorCostoListaAbierta();
            nodoActual = listaAbierta.pollFirst();
            //Antes de evaluar si el nodo es solución contabilizo nodos explorados con la clase RendimientoBusqueda
            this.rendimiento.reporteNodosExplorados();

            //if(!listaCerrada.containsKey(nodoActual.getEstado())) {

            if(nodoActual.getEstado().esFinal()) {
                solucionEncontrada = true;
                nodoSolucion = nodoActual;
              }
              // si el estado actual no es objetivo lo expando (genero y pongo hijos)
            else {
              listaCerrada.put(nodoActual.getEstado(), nodoActual);

              LinkedList<NodoBusqueda> listaAbiertaAux = expandirNodo(nodoActual);
              for(NodoBusqueda nodo : listaAbiertaAux){
                if(this.isEnAbierta(nodo)||this.isEnCerrada(nodo)){
                       listaAbiertaAux.remove(nodo);
                }
              }
              this.ordenarListaAbierta(listaAbiertaAux);
              //listaAbierta.addAll(listaAbiertaAux);

              traza.imprimirFinalIteracion(nodoActual, listaAbierta);
            }
          }
    }
    // al terminar contabilizo nodos sobrantes con la clase RendimientoBusqueda
    this.rendimiento.reporteNodosSobrantes(listaAbierta.size());
    // Contabilizo tiempo al finalizar busqueda con la clase RendimientoBusqueda
    this.rendimiento.reporteFinBusqueda();
    System.out.println(this.rendimiento.getReporteCompleto());
    
    if(nodoSolucion == null) {
      return new Vector<Operador>();
    }
    else {
      return encontrarCamino(nodoSolucion);
    }
    }
    
    /**
     * Devuelve el nodo con menor costo de la lista abierta
    */
    private NodoBusqueda getNodoMenorCostoListaAbierta() {
        NodoBusqueda nodomenor = listaAbierta.getFirst();
        int costo = nodomenor.getCosto();
        for(NodoBusqueda nodo : listaAbierta){
           if(nodo.getCosto()<nodomenor.getCosto()){
            nodomenor = nodo;
            costo = nodo.getCosto();
           }
         }
        return nodomenor;
    }
    
    /**
     * Agrega hijos a lista abierta y  la ordena. <br>
     * Aqui es posible agregar lógica para desempates
     */
    private void ordenarListaAbierta(LinkedList<NodoBusqueda> listaHijos){
        listaAbierta.addAll(listaHijos);
        Collections.sort(listaAbierta);
    }
}
