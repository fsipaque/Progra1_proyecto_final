/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.jfperez.progra1_pro_final;

/**
 *
 * @author josep
 */
public class Entidad {
    
    /**
     * Cantidad de caracteres
     */
    public static final int cantidadCaracteres = 25;
    
    /**
     * Tamaño de registro de entidad
     */
    public static final int SIZE = Integer.BYTES + (Character.BYTES * cantidadCaracteres);

    /**
     * Indice de la entidad.
     */
    private Integer indice;
    
    /**
     * Nombre de la entidad.
     */
    private String nombre;

    /**
     * @return the indice
     */
    public Integer getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(Integer indice) {
        this.indice = indice;        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
