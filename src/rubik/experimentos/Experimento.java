/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.experimentos;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import rubik.busqueda.Busqueda;
import rubik.busqueda.Operador;
import rubik.busqueda.Problema;
import rubik.modelo.Cubo;
import rubik.modelo.EstadoRubik;
import rubik.modelo.Movimiento;

/**
 *
 * @author gasmu_000
 */
public abstract class Experimento {
    
    
    protected static void realizarBusqueda(long semilla, Busqueda busqueda, int nroPasos){
        
        Cubo cubo = new Cubo();
        cubo.rnd.setSeed(semilla);
        //mezclar el cubo con la cantidad de pasos indicados
        cubo.mezclar(nroPasos);
        
        Problema problema = new Problema(new EstadoRubik(cubo), busqueda);
        
        Vector<Operador> opsSolucion = problema.obtenerSolucion();
        
        boolean resultadoEncontrado = opsSolucion != null;
        
        problema.getBuscador().getRendimiento().setResultadoEncontrado(resultadoEncontrado);
    }
    
    protected static void imprimirListaResultados (List lista){
        Iterator iterator = lista.iterator();
        
        while (iterator.hasNext()) {
            ResultadoExperimento resultado = (ResultadoExperimento)iterator.next();
            System.out.println(resultado.toString());
        }
    }
}
