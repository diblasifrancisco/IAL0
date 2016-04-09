package rubik.busqueda;

import java.util.Vector;
  
/**
 * Interfaz generico para algorimtos de busqueda
 * Inteligencia Artificial 2016
 */
public abstract class Busqueda {
    /**
     * Interfaz generico para algorimtos de busqueda
     * @param   inicial Estado inicial
     * @return  null o Vector con la lista de Operadores
     */
    protected RendimientoBusqueda rendimiento = new RendimientoBusqueda();
    
    public abstract Vector<Operador> buscarSolucion(Estado inicial);
    
    public RendimientoBusqueda getRendimiento(){
        return this.rendimiento;
    }
}
