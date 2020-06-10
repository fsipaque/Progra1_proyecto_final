/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.jfperez.progra1_pro_final;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josep
 */
public class ManejoRegistro {
    
    private List<Object> componentes;
    
    public ManejoRegistro() {
        this.componentes = new ArrayList();
    }

    /**
     * @param componentes the componentes to set
     */
    public void setComponentes(List<Object> componentes) {
        this.componentes = componentes;
    }

    /**
     * @return the componentes
     */
    public List<Object> getComponentes() {
        return componentes;
    }       
    
}
