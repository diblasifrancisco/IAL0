/*
 * Esta clase es una factoria de estrategias de busqueda que implementen la interface Busqueda.java.
 * ...
 *
 *
 */

package rubik.busqueda;

public class FactoriaEstrategias {
    
    //    variables que determinan las propiedades de la estrategia (anchura, profundida, costo) tanto para un arbol como para un grafo.
//    se inicializa con la estrategia "busqueda costo uniforme arbol"
    public static final int ANCHURA_ARBOL = 0;
    public static final int COSTO_UNIFORME_ARBOL = 1;
    public static final int PROFUNDIDAD_ARBOL = 2;
    public static final int ANCHURA_GRAFO = 3;
    public static final int COSTO_UNIFORME_GRAFO = 4; 
    public static final int PROFUNDIDAD_GRAFO = 5; 
    public static final int PROFUNDIDAD_INTE_GRAFO = 6;    
    private static int estrategia = 1; 

    //    metodo que dado un numero representativo de la estrategia, devuelve la estrategia misma.
    public static Busqueda getEstrategia(int estrategia){ 
        FactoriaEstrategias.estrategia = estrategia;  
        switch(estrategia) {
          case 0:
            System.out.println("BUSQUEDA ANCHURA EN ARBOL");
            return new BusquedaAnchura();
          case 1:
            System.out.println("BUSQUEDA COSTO UNIFORME EN ARBOL");
            return new BusquedaCosteUniforme();
          case 2:
            System.out.println("BUSQUEDA PROFUNDIDAD EN ARBOL");
            return new BusquedaProfundidad();
          case 3:
            System.out.println("BUSQUEDA ANCHURA EN GRAFO");
            return new BusquedaAnchuraG();          
          case 4:
            System.out.println("BUSQUEDA COSTO UNIFORME EN GRAFO");
            return new BusquedaCosteUniformeG();
          case 5:
            System.out.println("BUSQUEDA PROFUNDIDAD EN GRAFO");
            return new BusquedaProfundidadG();
          case 6:
            System.out.println("BUSQUEDA PROFUNDIDAD INTERACTIVA EN GRAFO");
            return new BusquedaProfundidadIterativaG();
          default:  return null;
        }
    } 
}
