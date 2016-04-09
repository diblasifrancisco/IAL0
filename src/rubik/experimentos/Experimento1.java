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
public class Experimento1 {
    public static void main(String[] args) {
         
        
        // Describir para que son las lineas de codigo sigientes
        
        // se crea una semilla
        long semilla = 35675; 
        //coloca la seminlla en el cubo
         
        
        int nroExperimento = 1;
        int totalExperimentos = 15;
        
        List<IteracionExperimento1> resultadosAbierta = new ArrayList<IteracionExperimento1>(totalExperimentos);
        List<IteracionExperimento1> resultadosProfundidad = new ArrayList<IteracionExperimento1>(totalExperimentos);
        List<IteracionExperimento1> resultadosCostoUniforme = new ArrayList<IteracionExperimento1>(totalExperimentos);
        
        while (nroExperimento <= totalExperimentos){
            //se muestra la semilla ingresada
            System.out.println("\nSEMILLA:"+semilla); 
            
            Cubo cubo = new Cubo();
            cubo.rnd.setSeed(semilla);
            //mezclar el cubo con la cantidad de pasos indicados
            Vector<Movimiento> movsMezcla = cubo.mezclar(2); 

            //muestra los movimientos realizados en el cubo para mezclarlo
            System.out.println("\nMOVIMIENTOS:"); 
            for (Movimiento m : movsMezcla) {
                System.out.print(m.toString() + " ");
            }
            //muestra el estado inicial
            System.out.println();
            System.out.println("CUBO INICIAL:\n" + cubo.toString()); 

            // Describir para que son las lineas de codigo sigientes

            //crea el problema a resolver con el cubo como quedo en el paso anterior y la estrategia de busqueda elegida
            Problema problema = new Problema(new EstadoRubik(cubo), FactoriaEstrategias.getEstrategia(3));
            
            //obtiene la solucion, guarda las acciones que llevan a la solucion en un vector.
            Vector<Operador> opsSolucion = problema.obtenerSolucion();  
            
            //muestra la solucion
            System.out.println("\nSOLUCION:");
            //si la encontro
            if (opsSolucion != null) {
                for (Operador o : opsSolucion) {
                    //muestra las acciones
                    System.out.println("Accion: " + o.getEtiqueta() + " "); 
                    OperadorRubik or = (OperadorRubik) o;
                    //realiza la accion
                    cubo.mover(or.getMovimiento());
                }
                System.out.println();
                //muestra el cubo resuelto
                System.out.println("CUBO FINAL:\n" + cubo.toString()); 
            } else {
                //sino indica que no hay solucion
                System.out.println("no se ha encontrado solucion");
            }
        }
    }
    
    private Busqueda realizarBusqueda(long semilla){
        Cubo cubo = new Cubo();
        cubo.rnd.setSeed(semilla);
        //mezclar el cubo con la cantidad de pasos indicados
        Vector<Movimiento> movsMezcla = cubo.mezclar(2);
        
        
    }
}
