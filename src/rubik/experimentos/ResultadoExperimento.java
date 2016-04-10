/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.experimentos;

import rubik.busqueda.Busqueda;
import rubik.busqueda.RendimientoBusqueda;

/**
 *
 * @author gasmu_000
 */
public class ResultadoExperimento {
    protected long tiempoBusqueda;
    
    protected long nroNodosExplorados;
    
    protected long maxListaAbierta;
    
    protected boolean resultadoEncontrado;
    
    public ResultadoExperimento() {
    }

    public ResultadoExperimento(Busqueda busqueda) {
        RendimientoBusqueda rendimiento = busqueda.getRendimiento();
        
        this.tiempoBusqueda = rendimiento.getTiempoBusquedaMili();
        this.nroNodosExplorados = rendimiento.getNroNodosExplorados();
        this.maxListaAbierta = rendimiento.getMaxListaAbierta();
        this.resultadoEncontrado = rendimiento.isResultadoEncontrado();
    }

    @Override
    public String toString() {
        return "ResultadoExperimento1{" + "tiempoBusqueda=" + tiempoBusqueda + ", nroNodosExplorados=" + nroNodosExplorados + ", maxListaAbierta=" + maxListaAbierta + ", resultadoEncontrado=" + resultadoEncontrado + '}';
    }
    
    
    
    /**
     * Get the value of resultadoEncontrado
     *
     * @return the value of resultadoEncontrado
     */
    public boolean isResultadoEncontrado() {
        return resultadoEncontrado;
    }

    /**
     * Set the value of resultadoEncontrado
     *
     * @param resultadoEncontrado new value of resultadoEncontrado
     */
    public void setResultadoEncontrado(boolean resultadoEncontrado) {
        this.resultadoEncontrado = resultadoEncontrado;
    }

    /**
     * Get the value of maxListaAbierta
     *
     * @return the value of maxListaAbierta
     */
    public long getMaxListaAbierta() {
        return maxListaAbierta;
    }

    /**
     * Set the value of maxListaAbierta
     *
     * @param maxListaAbierta new value of maxListaAbierta
     */
    public void setMaxListaAbierta(long maxListaAbierta) {
        this.maxListaAbierta = maxListaAbierta;
    }


    /**
     * Get the value of nroNodosExplorados
     *
     * @return the value of nroNodosExplorados
     */
    public long getNroNodosExplorados() {
        return nroNodosExplorados;
    }

    /**
     * Set the value of nroNodosExplorados
     *
     * @param nroNodosExplorados new value of nroNodosExplorados
     */
    public void setNroNodosExplorados(long nroNodosExplorados) {
        this.nroNodosExplorados = nroNodosExplorados;
    }

    /**
     * Get the value of tiempoBusqueda
     *
     * @return the value of tiempoBusqueda
     */
    public long getTiempoBusqueda() {
        return tiempoBusqueda;
    }

    /**
     * Set the value of tiempoBusqueda
     *
     * @param tiempoBusqueda new value of tiempoBusqueda
     */
    public void setTiempoBusqueda(long tiempoBusqueda) {
        this.tiempoBusqueda = tiempoBusqueda;
    }
    
}
