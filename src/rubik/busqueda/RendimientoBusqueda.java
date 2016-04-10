package rubik.busqueda;

/** Clase abstracta que guarda los metodos requeridos para
 * calular las medidas de rendimiento para evaluar los algoritmos de busqueda
 * Inteligencia Artificial 2016
 */

public class RendimientoBusqueda {

    
    //    propiedades para indicar el tiempo que tardo la busqueda, como asi tambien los nodos explorados y los sobrantes.
    long tiempoBusquedaSeg;  
    long tiempoBusquedaMili; 
    long cantidadNodosExplorados; 
    long cantidadNodosSobrantes;
    long maxListaAbierta = 0;
    boolean resultadoEncontrado = false;
    
    /**
     debe llamarse al finalzar la busqueda antes de retornar el camino solucion  <br>
      devuelve un String con el tiempo de busqueda (en milisegundos y segundos), 
      los nodos generados y los nodos explorados <br>
      utiliza los metodos reporteInicioBusqueda, reporteFinBusqueda, reporteNodosExplorados, reporteNodosExplorados y reporteNodosSobrantes
      para realizar los calculos de las propiedades a mostrar.
      */
    public String getReporteCompleto(){
        System.out.println("\n REPORTE DE BUSQUEDA");
        System.out.println("---------------------------------------");
           return ("Tiempo de busqueda: " + tiempoBusquedaMili + " milisegundos (" + tiempoBusquedaSeg + " segundos)" +
          "\n"+"Nodos Generados: " + (cantidadNodosExplorados + cantidadNodosSobrantes) +
          "\n"+"Nodos Explorados: " + cantidadNodosExplorados) ;
     }

   /**
    * se toma el tiempo inicial al comienzo de la busqueda
    */
    protected void reporteInicioBusqueda() {
      cantidadNodosExplorados = 0;
      cantidadNodosSobrantes = 0;
      tiempoBusquedaMili = System.currentTimeMillis();
      tiempoBusquedaSeg = (System.currentTimeMillis()/ 1000L);
    }

    /**
     * se llama cuando se evalua un nodo extraido de la lista abirta  
     */
    protected void reporteNodosExplorados() {
      cantidadNodosExplorados++;
    }
    protected void reporteNodosExplorados(long cantidad) {
      cantidadNodosExplorados += cantidad;
    }
     /**
     * Se llama desde los métodos de búsqueda para contabilizar los nodos sobrantes (hojas)
     * Lleva la cuenta de las hojas generadas
     * @param cantidad 
     */
    protected void reporteNodosSobrantes(long cantidad){
        cantidadNodosSobrantes += cantidad;
        cantidad++;
        if (maxListaAbierta < cantidad) maxListaAbierta = cantidad;

    }
    /**
    y se toma el tiempo final al finalizar la busqueda
    se calcula diferencia de inicio y fina para determinar tiempo en seg y miliseg
    */
    protected void reporteFinBusqueda() {
      tiempoBusquedaMili = System.currentTimeMillis() - tiempoBusquedaMili;
      tiempoBusquedaSeg = (System.currentTimeMillis()/ 1000L) - tiempoBusquedaSeg;
    }

    public long getNroNodosGenerados() {
      return cantidadNodosExplorados + cantidadNodosSobrantes;
    }
    public long getNroNodosExplorados() {
      return cantidadNodosExplorados;
    }
    public long getNroNodosSobrantes() {
      return cantidadNodosSobrantes;
    }
    public long getTiempoBusquedaMili() {
      return tiempoBusquedaMili;
    }
    public long getTiempoBusquedaMinu() {
      return tiempoBusquedaSeg;
    }
      /**
     * Get the value of maxListaAbierta
     *
     * @return the value of maxListaAbierta
     */
    public long getMaxListaAbierta() {
        return maxListaAbierta;
    }

    public boolean isResultadoEncontrado() {
        return resultadoEncontrado;
    }
    
    public void setResultadoEncontrado(boolean resultadoEncontrado) {
        this.resultadoEncontrado = resultadoEncontrado;
    }
    
    
}
