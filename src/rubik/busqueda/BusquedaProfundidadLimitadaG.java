package rubik.busqueda;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/** Estrategia de Busqueda en grafo en Profundidad Limitada, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaGrafo (generica independiente de la estrategia)
 * Implementa el metodo buscarSolucion() y devuelve un vector de operadores (solucion)
 */

public class BusquedaProfundidadLimitadaG extends BusquedaGrafo {

    int profundidadLimite = 2;
    int profundidadActual = 0;

    public void setProfundidadLimite(int profundidadLimite) {
      this.profundidadLimite = profundidadLimite;
    }
    public int getProfundidadLimite() {
      return profundidadLimite;
    }

    /**
     Busca la solución controlando estados repetidos en lista cerrada al quitar un nodo de lista abierta
     */
    @Override
    public Vector<Operador> busquedaGrafoA(Estado inicial){
        //Antes de comenzar la busqueda se contabiliza tiempo llamando metodo de la clase RendimientoBusqueda
        this.reporteInicioBusqueda();

        profundidadActual = 0;
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
            nodoActual = listaAbierta.pollFirst();
           //Antes de evaluar si el nodo es solución contabilizo nodos explorados con la clase RendimientoBusqueda
           this.reporteNodosExplorados();

            //if(!listaCerrada.containsKey(nodoActual.getEstado())) {
            if(!this.isEnCerrada(nodoActual)) {  
                if(nodoActual.getEstado().esFinal()) {
                solucionEncontrada = true;
                nodoSolucion = nodoActual;
              }
              // si el estado actual no es objetivo lo expando (genero y pongo hijos)
              else {
                listaCerrada.put(nodoActual.getEstado(), nodoActual);
                //si el nodo supera el limite voy a la siguiente iteracion
                if (nodoActual.getProfundidad()== profundidadLimite)continue;
                
                listaAbierta.addAll(0,expandirNodo(nodoActual));

                profundidadActual++;

                traza.imprimirFinalIteracion(nodoActual, listaAbierta);
              }
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

    /**
     Busca la solución controlando estados repetidos en lista cerrada al quitar un nodo de lista abierta
     */
    @Override
    public Vector<Operador> busquedaGrafoB(Estado inicial){
        //Antes de comenzar la busqueda se contabiliza tiempo llamando metodo de la clase RendimientoBusqueda
        this.reporteInicioBusqueda();

        profundidadActual = 0;
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
                listaCerrada.put(nodoActual.getEstado(), nodoActual);
                //si el nodo supera el limite voy a la siguiente iteracion
                if (nodoActual.getProfundidad()== profundidadLimite)continue;
                
                LinkedList<NodoBusqueda> listaAbiertaAux = expandirNodo(nodoActual);
                for(NodoBusqueda nodo : listaAbiertaAux){
                  if(this.isEnAbierta(nodo)||this.isEnCerrada(nodo)){
                         listaAbiertaAux.remove(nodo);
                  }
                }

                listaAbierta.addAll(0,listaAbiertaAux);
                
                profundidadActual++;
                
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
