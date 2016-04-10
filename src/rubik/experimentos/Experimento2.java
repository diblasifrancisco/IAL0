/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.experimentos;

import java.util.ArrayList;
import java.util.List;
import rubik.busqueda.Busqueda;
import rubik.busqueda.BusquedaGrafo;
import rubik.busqueda.FactoriaEstrategias;
import rubik.busqueda.TipoBusquedaGrafo;
import static rubik.experimentos.Experimento.realizarBusqueda;

/**
 *
 * @author gasmu_000
 */
public class Experimento2 extends Experimento{
    public static void main(String[] args) {
        
        // se crea una semilla
        long semilla = 35675; 
        //coloca la seminlla en el cubo
               
        int nroExperimento = 1;
        int totalExperimentos = 15;
        
        List<ResultadoExperimento> resultadosAnchura = new ArrayList<ResultadoExperimento>();
        List<ResultadoExperimento> resultadosGrafoAnchura = new ArrayList<ResultadoExperimento>();
        
        for (int i = 1; i < 3; i++) {
            while (nroExperimento <= totalExperimentos){
                //se muestra la semilla ingresada
                semilla++;
                System.out.println("\nSEMILLA:"+semilla); 
                
                
                //creo instancias de busqueda
                Busqueda busquedaArbolAnchura = FactoriaEstrategias.getEstrategia(FactoriaEstrategias.ANCHURA_ARBOL);
                BusquedaGrafo busquedaGrafoAnchura = (BusquedaGrafo)FactoriaEstrategias.getEstrategia(FactoriaEstrategias.ANCHURA_GRAFO);
                //configuramos la busqueda en grafo para que solo controle la lista cerrada
                busquedaGrafoAnchura.setTipo(TipoBusquedaGrafo.CONTROL_LC);

                //realizo busquedas
                realizarBusqueda(semilla, busquedaArbolAnchura, i);
                realizarBusqueda(semilla, busquedaGrafoAnchura, i);

                //creo los resultados de experimentos
                resultadosAnchura.add(new ResultadoExperimento(busquedaArbolAnchura));
                resultadosGrafoAnchura.add(new ResultadoExperimento(busquedaGrafoAnchura));

                System.out.println("Experimento " + nroExperimento + " completado.");
                nroExperimento++;
            }
            System.out.println("Número de pasos: " + i);
            System.out.println("Los resultados de busqueda en anchura en arbol son:");
            imprimirListaResultados(resultadosAnchura);
            System.out.println("Los resultados de busqueda en anchura en grafo son:");
            imprimirListaResultados(resultadosGrafoAnchura);
        }
        System.out.println("Todos los experimentos han finalizado.");
        
        
    }
}
