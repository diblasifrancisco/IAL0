/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.experimentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import rubik.busqueda.Busqueda;
import rubik.busqueda.FactoriaEstrategias;
import rubik.busqueda.Operador;
import rubik.busqueda.Problema;
import rubik.modelo.Cubo;
import rubik.modelo.EstadoRubik;
import rubik.modelo.Movimiento;
import rubik.modelo.OperadorRubik;

/**
 *
 * @author gasmu_000
 */
public class Experimento1 extends Experimento {
    public static void main(String[] args) {
        
        // se crea una semilla
        long semilla = 35675; 
        //coloca la seminlla en el cubo
               
        int nroExperimento = 1;
        int totalExperimentos = 15;
        int nroPasos = 2;
        
        List<ResultadoExperimento> resultadosAnchura = new ArrayList<ResultadoExperimento>(totalExperimentos);
        List<ResultadoExperimento> resultadosProfundidad = new ArrayList<ResultadoExperimento>(totalExperimentos);
        List<ResultadoExperimento> resultadosCostoUniforme = new ArrayList<ResultadoExperimento>(totalExperimentos);
        
        while (nroExperimento <= totalExperimentos){
            //se muestra la semilla ingresada
            semilla++;
            System.out.println("\nSEMILLA:"+semilla); 
            
            //creo instancias de busqueda
            Busqueda busquedaArbolAnchura = FactoriaEstrategias.getEstrategia(FactoriaEstrategias.ANCHURA_ARBOL);
            Busqueda busquedaArbolProfundidad = FactoriaEstrategias.getEstrategia(FactoriaEstrategias.PROFUNDIDAD_ARBOL);
            Busqueda busquedaArbolCostoUniforme = FactoriaEstrategias.getEstrategia(FactoriaEstrategias.COSTO_UNIFORME_ARBOL);
            
            //realizo busquedas
            realizarBusqueda(semilla, busquedaArbolAnchura, nroPasos);
            //realizarBusqueda(semilla, busquedaArbolProfundidad, nroPasos); // comentada ya que no va a finalizar
            realizarBusqueda(semilla, busquedaArbolCostoUniforme, nroPasos);
            
            //creo los resultados de experimentos
            resultadosAnchura.add(new ResultadoExperimento(busquedaArbolAnchura));
            resultadosProfundidad.add(new ResultadoExperimento(busquedaArbolProfundidad));
            resultadosCostoUniforme.add(new ResultadoExperimento(busquedaArbolCostoUniforme));
            
            System.out.println("Experimento " + nroExperimento + " completado.");
            nroExperimento++;
        }
        System.out.println("Todos los experimentos han finalizado.");
        System.out.println("Los resultados de busqueda en anchura son:");
        imprimirListaResultados(resultadosAnchura);
        System.out.println("Los resultados de busqueda en profundidad son:");
        imprimirListaResultados(resultadosProfundidad);
        System.out.println("Los resultados de busqueda en costo uniforme son:");
        imprimirListaResultados(resultadosCostoUniforme);
        
    }
}
