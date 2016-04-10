package rubik.busqueda;

import java.util.Vector;

/** Estrategia de Busqueda en grafo en Profundidad Interactiva, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaGrafo (generica independiente de la estrategia)
 * Implementa el metodo buscarSolucion() y devuelve un vector de operadores (solucion)
 */

public class BusquedaProfundidadIterativaG extends BusquedaGrafo {
    
    /**
     crea una instancia de busqueda en profundidad limitada para usarla en la busqueda
     */
    BusquedaProfundidadLimitadaG busquedapl = new BusquedaProfundidadLimitadaG();
    int profundidadLimite = 0;

    /**
     * Busca la solución controlando estados repetidos en lista cerrada al quitar un nodo de lista abierta </br>
     * Con la profundidad inicializada en cero ejecuta repetidamente la busqueda en profundidad limitada,
     * aumentando el limite en cada iteracion
     */
    @Override
    public Vector<Operador> busquedaGrafoA(Estado inicial){
    
        Vector<Operador> caminoSolucion = null;
        while(true){
            busquedapl.setProfundidadLimite(profundidadLimite);
            System.out.println("Iteracion actual: " + this.profundidadLimite);
            caminoSolucion = busquedapl.busquedaGrafoA(inicial);
            
            this.agregarRendimientoIteracion(busquedapl.rendimiento);
            if(!caminoSolucion.isEmpty()){
                return caminoSolucion;
            }
            this.profundidadLimite++;
        }
    }

    /**
     Busca la solución controlando estados repetidos en lista cerrada al quitar un nodo de lista abierta </br>
     * Con la profundidad inicializada en cero ejecuta repetidamente la busqueda en profundidad limitada,
     * aumentando el limite en cada iteracion
     */
    @Override
    public Vector<Operador> busquedaGrafoB(Estado inicial){
    
        Vector<Operador> caminoSolucion = null;
        while(true){
            busquedapl.setProfundidadLimite(profundidadLimite);
            System.out.println("Iteracion actual: " + this.profundidadLimite);
            caminoSolucion = busquedapl.busquedaGrafoB(inicial);
            
            this.agregarRendimientoIteracion(busquedapl.rendimiento);
            if(!caminoSolucion.isEmpty()){
                return caminoSolucion;
            }
            this.profundidadLimite++;
        }
    }
    
    private void agregarRendimientoIteracion(RendimientoBusqueda rendimiento){
        this.rendimiento.cantidadNodosExplorados += rendimiento.cantidadNodosExplorados;
        this.rendimiento.cantidadNodosSobrantes += rendimiento.cantidadNodosSobrantes;
        if(this.rendimiento.maxListaAbierta <= rendimiento.maxListaAbierta){
            this.rendimiento.maxListaAbierta = rendimiento.maxListaAbierta;   
        }        
        this.rendimiento.resultadoEncontrado = rendimiento.resultadoEncontrado;
        this.rendimiento.tiempoBusquedaMili += rendimiento.tiempoBusquedaMili;
        this.rendimiento.tiempoBusquedaSeg += rendimiento.tiempoBusquedaSeg;
        
        
        
    }
}
