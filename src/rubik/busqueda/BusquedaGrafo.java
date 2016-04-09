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

public abstract class BusquedaGrafo  extends Busqueda{
        HashMap<Estado, NodoBusqueda> listaCerrada; 
        LinkedList<NodoBusqueda>      listaAbierta;
	TrazaGenerica traza;
        char tipo = TipoBusquedaGrafo.CONTROL_LC;
    /**
     Genera los nodos hijos dado un nodo 
     */
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
    /**
     Devuelve el listado de acciones que llegan a la solución encontrada
     */
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
    /**
     Verifica si un nodo está presente en lista abierta
     */
    protected boolean isEnAbierta(NodoBusqueda nodo){
                
        for (NodoBusqueda nodoListaAbierta: listaAbierta){
            if (nodoListaAbierta.getEstado().equals(nodo.getEstado())){
                return true;
            }
        }
        return false;
    }
    /**
     Verifica si el estado asociado a un nodo está en lista cerrada
    */
    protected boolean isEnCerrada(NodoBusqueda nodo){
        return listaCerrada.containsKey(nodo.getEstado());
    }
    /**
     De acuerdo al valor de la variable tipo se decide que busqueda ejecutar
     */
    @Override
    public Vector<Operador> buscarSolucion(Estado inicial){
        switch (tipo)
        {
           case TipoBusquedaGrafo.CONTROL_LC:
               return this.busquedaGrafoA(inicial); 
           case TipoBusquedaGrafo.CONTROL_LA_LC:
               return this.busquedaGrafoB(inicial);  
           default: return null;
        }
    }
    
    /**
     Busca la solución controlando estados repetidos en lista cerrada al quitar un nodo de lista abierta
     */
    public abstract Vector<Operador> busquedaGrafoA(Estado inicial);
    /**
     Busca la solución controlando estados repetidos en lista cerrada y abierta al generar hijos
     */
    public abstract Vector<Operador> busquedaGrafoB(Estado inicial);
}
