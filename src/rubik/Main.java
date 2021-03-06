package rubik;
import java.util.Vector;
import rubik.busqueda.FactoriaEstrategias;
import rubik.modelo.EstadoRubik;
import rubik.modelo.OperadorRubik;
import rubik.busqueda.Operador;
import rubik.busqueda.Problema;
import rubik.modelo.Cubo;
import rubik.modelo.Movimiento;

/**
 * Interfaz a travez de la consola
 * Inteligencia Artificial 2016
 */

/**
 * Formulacion conceptual de la solucion del Cubo Rubik
 * como un problema de busqueda
 * 
Estados: Las distintas posiciones de las caras en el cubo.<br>
Estado inicial: cualquiera puede ser estado inicial. <br>
Estado final:cubo con cada cara de un solo color<br>
Funci�n sucesor: problema:posici�n de las caras, acci�n: mover una cara, sucesor:posici�n de las caras.<br>
Operadores/acciones:mover una fila o una columna de una cara del cubo, moviendo las correspondientes filas 
* o columnas de las caras que correspondan, siguiendo el modelo de un cubo.<br>
Test objetivo: las 6 caras con todas las casillas de un mismo color.<br>
Costo camino: es igual al n�mero de pasos, por lo tanto 1 (por cada movimiento).
 */
public class Main {
    /**
     * se mezcla el cubo generado con dos movimientos aleatorios (la semilla es para determinar el movimiento aleatorio en cada paso)
     * muestra la semilla, luego se muestran los movimientos realizados
    <br>
     * por ultimo se muestra el cubo como qued� 
     * genera un problema con el cubo y la estrategia indicada, luego obtiene la solucion,
     * se muestra los movimientos que siguio para llegar a la solucion,se aplican los movimientos de la solucion
    <br>
     * por ultimo muestra el cubo armado, o indica que no se encontro solucion de ser el caso
    */
     public static void main(String[] args) {
         
        Cubo cubo = new Cubo();
        // Describir para que son las lineas de codigo sigientes
        
        // se crea una semilla
        long semilla = 35853; 
        //coloca la seminlla en el cubo
        cubo.rnd.setSeed(semilla); 
        //se muestra la semilla ingresada
        System.out.println("\nSEMILLA:"+semilla); 
        
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
