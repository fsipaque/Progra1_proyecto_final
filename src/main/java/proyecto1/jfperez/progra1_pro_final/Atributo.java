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
public class Atributo {
    
    /**
     * Cantidad de caracteres en nombre
     */
    private static int cantidadCaracteres = 25;
    
    /**
     * Tamaño del registro del atributo.
     */
    private static int SIZE = (4 * Integer.BYTES) + (Character.BYTES * cantidadCaracteres);
    
    /**
     * Indice del atributo.
     */
    private Integer indice;
    
    /**
     * Nombre del atributo.
     */
    private String nombre;
    
    /**
     * Tipo del atributo.
     */
    private Integer tipo;
    
    /**
     * Longitud del atributo si es String.
     */
    private Integer longitud;
    
    /**
     * Entidad a la que pertenece el atributo.
     */
    private Integer entidad; 

    /**
     * @return the cantidadCaracteres
     */
    public static int getCantidadCaracteres() {
        return cantidadCaracteres;
    }

    /**
     * @param aCantidadCaracteres the cantidadCaracteres to set
     */
    public static void setCantidadCaracteres(int aCantidadCaracteres) {
        cantidadCaracteres = aCantidadCaracteres;
    }

    /**
     * @return the SIZE
     */
    public static int getSIZE() {
        return SIZE;
    }

    /**
     * @param aSIZE the SIZE to set
     */
    public static void setSIZE(int aSIZE) {
        SIZE = aSIZE;
    }

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

    /**
     * @return the tipo
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the longitud
     */
    public Integer getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the entidad
     */
    public Integer getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Integer entidad) {
        this.entidad = entidad;
    }       
    
    public static String getTipoToString(Integer tipo) {
        switch(tipo) {
            case 1:
                return "String";
            case 2:
                return "Date";
            case 3:
                return "Double";
            case 4:
                return "Integer";
        }
        return "Undefined";
    }
    
    public static Integer getTipoToInteger(String tipo) {
        if (tipo.equals("String")) {
            return 1;
        }else if (tipo.equals("String")) {
            return 1;
        }else if (tipo.equals("Date")) {
            return 2;
        }else if (tipo.equals("Double")) {
            return 3;
        }else if (tipo.equals("Integer")) {
            return 4;
        }
        return -1;
    }
    
}
