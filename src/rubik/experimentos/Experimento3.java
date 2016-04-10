/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.experimentos;

import java.io.IOException;
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
public class Experimento3 extends Experimento{
    public static void main(String[] args){
        
        // se crea una semilla
         
        //coloca la seminlla en el cubo
               
        int totalExperimentos = 15;
        
        List<ResultadoExperimento> resultadosGrafoProfInteractiva = new ArrayList<ResultadoExperimento>(totalExperimentos);
        List<ResultadoExperimento> resultadosGrafoAnchura = new ArrayList<ResultadoExperimento>(totalExperimentos);
        
        for (int i = 2; i < 5; i = i+2) {
            int nroExperimento = 1;
            long semilla = 35675;
            while (nroExperimento <= totalExperimentos){
                //se muestra la semilla ingresada
                semilla++;
                System.out.println("\nSEMILLA:"+semilla); 
                
                
                //creo instancias de busqueda
                Busqueda busquedaGrafoProfInteractiva = FactoriaEstrategias.getEstrategia(FactoriaEstrategias.PROFUNDIDAD_INTE_GRAFO);
                BusquedaGrafo busquedaGrafoAnchura = (BusquedaGrafo)FactoriaEstrategias.getEstrategia(FactoriaEstrategias.ANCHURA_GRAFO);
                //configuramos la busqueda en grafo para que solo controle la lista cerrada
                busquedaGrafoAnchura.setTipo(TipoBusquedaGrafo.CONTROL_LC);

                //realizo busquedas
                realizarBusqueda(semilla, busquedaGrafoProfInteractiva, i);
                realizarBusqueda(semilla, busquedaGrafoAnchura, i);

                //creo los resultados de experimentos
                resultadosGrafoProfInteractiva.add(new ResultadoExperimento(busquedaGrafoProfInteractiva));
                resultadosGrafoAnchura.add(new ResultadoExperimento(busquedaGrafoAnchura));

                System.out.println("Experimento " + nroExperimento + " completado.");
                nroExperimento++;
            }
            System.out.println("Número de pasos: " + i);
            System.out.println("Los resultados de busqueda en prof interactiva en grafo son:");
            imprimirListaResultados(resultadosGrafoProfInteractiva);
            System.out.println("Los resultados de busqueda en anchura en grafo son:");
            imprimirListaResultados(resultadosGrafoAnchura);
        }
        System.out.println("Todos los experimentos han finalizado.");
        
        
    }
}
