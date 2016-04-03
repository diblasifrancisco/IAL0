package rubik.busqueda;

import java.util.Vector;

/** Estrategia de Busqueda en grafo en Profundidad Interactiva, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaGrafo (generica independiente de la estrategia)
 * Implementa el metodo buscarSolucion() y devuelve un vector de operadores (solucion)
 */

public class BusquedaProfundidadIterativaG extends BusquedaGrafo {

    BusquedaProfundidadLimitadaG busquedapl = new BusquedaProfundidadLimitadaG();
    int profundidadLimite = 0;

    @Override
    public Vector<Operador> busquedaGrafoA(Estado inicial){
    
        Vector<Operador> caminoSolucion = null;
        this.reporteInicioBusqueda();
        while(true){
            busquedapl.setProfundidadLimite(profundidadLimite);
            caminoSolucion = busquedapl.busquedaGrafoA(inicial);
            if (!caminoSolucion.isEmpty())break;
            profundidadLimite++;
        }
        this.reporteFinBusqueda();
        System.out.println(this.getReporteCompleto());
        return caminoSolucion;
    }

    @Override
    public Vector<Operador> busquedaGrafoB(Estado inicial){
    
        Vector<Operador> caminoSolucion = null;

        while(true){
            busquedapl.setProfundidadLimite(profundidadLimite);
            caminoSolucion = busquedapl.busquedaGrafoB(inicial);
            if (!caminoSolucion.isEmpty())break;
            profundidadLimite++;
        }

        return caminoSolucion;
    }
}
