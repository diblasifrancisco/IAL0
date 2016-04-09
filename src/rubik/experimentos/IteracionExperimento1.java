/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.experimentos;

/**
 *
 * @author gasmu_000
 */
public class IteracionExperimento1 {
    
    private long tiempoBusqueda;
    
    private long nroNodosExplorados;
    
    private long maxListaAbierta;
    
    private boolean esCompleta;

    /**
     * Get the value of esCompleta
     *
     * @return the value of esCompleta
     */
    public boolean isEsCompleta() {
        return esCompleta;
    }

    /**
     * Set the value of esCompleta
     *
     * @param esCompleta new value of esCompleta
     */
    public void setEsCompleta(boolean esCompleta) {
        this.esCompleta = esCompleta;
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
