/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.jfperez.progra1_pro_final;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josep
 */
public class ManejoAtributo {
    
    /***
     * Ruta del archivo de atributos.
     */
    private String ruta = "atributo.dat";
    
    /**
     * Listado de atributos almacenados.
     */
    private List<Atributo> atributos;
    
    /**
     * Atributo cargada actualmente.
     */
    private Atributo atributo;
    
    /**
     * Variable para acceder a archivo de entidades.
     */
    private RandomAccessFile archivo;
    
    /**
     * Constructor
     */
    public ManejoAtributo() {
        try {
            this.abrirArchivo(ruta);        
            this.atributos = new ArrayList();
        } catch (Exception ex) {
            ex.printStackTrace();            
        }
    }
    
    /**
     * Abrir archivo de atributos.
     * @param ruta
     * @throws Exception 
     */
    public void abrirArchivo(String ruta) throws Exception {
        setArchivo(new RandomAccessFile(ruta, "rw"));
    }
    
    /**
     * Cerrar archivo de atributos.
     * @throws Exception 
     */
    public void cerrarArchivo() throws Exception {
        if (getArchivo() != null) {
            getArchivo().close();
        }
    }
    
    /**
     * Obtener atributo a través de índice.
     * @param indice
     * @return 
     */
    public Atributo obtener(Integer indice) {        
        int posicion = Atributo.SIZE * indice;       
        this.atributo = new Atributo();
        try {
            getArchivo().seek(posicion);
            this.getAtributo().setIndice(getArchivo().readInt());
            this.getAtributo().setNombre(leerString());
            this.getAtributo().setTipo(getArchivo().readInt());
            this.getAtributo().setLongitud(getArchivo().readInt());
            this.getAtributo().setEntidad(getArchivo().readInt());
            this.getAtributos().set(indice, this.getAtributo());
            return this.atributo;
        } catch (EOFException e) {
            return null;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }        
    }       
    
    /**
     * Crear o actualizar atributo.
     * @param atributo
     * @return 
     */
    public String guardar(Atributo atributo) {        
        if (atributo.getIndice() == null) { // registro nuevo
            if (!this.existe(atributo.getNombre())) {
                int indice = this.atributos.size();
                atributo.setIndice(indice);
                int posicion = Atributo.SIZE * indice;
                try {
                    getArchivo().seek(posicion);
                    getArchivo().writeInt(indice);
                    this.escribirString(atributo.getNombre());
                    this.getArchivo().writeInt(atributo.getTipo());
                    this.getArchivo().writeInt(atributo.getLongitud());
                    this.getArchivo().writeInt(atributo.getEntidad());
                    atributos.add(atributo);
                    this.atributo = atributo;
                    return "Atributo creado correctamente.";
                } catch(Exception ex) {
                    ex.printStackTrace();
                    this.atributo = null;
                    return "Ocurrió un error al crear atributo. " + ex.getMessage();
                }            
            } else {
                this.atributo = null;
                return "Ya existe un atributo con el nombre deseado.";
            }
        } else {
            if (!this.existe(atributo.getIndice(), atributo.getNombre())) {
                if(this.atributos.get(atributo.getIndice()) != null) {
                    int posicion = Atributo.SIZE * atributo.getIndice();
                    try {
                        this.getArchivo().seek(posicion);
                        getArchivo().writeInt(atributo.getIndice());
                        this.escribirString(atributo.getNombre());
                        this.getArchivo().writeInt(atributo.getTipo());
                        this.getArchivo().writeInt(atributo.getLongitud());
                        this.getArchivo().writeInt(atributo.getEntidad());
                        atributos.set(atributo.getIndice(), atributo);
                        this.atributo = atributo;
                        return "Atributo actualizado correctamente.";
                    } catch(Exception e) {
                        e.printStackTrace();
                        this.atributo = null;
                        return "Ocurrió un error al actualizar atributo. " + e.getMessage();
                    }
                } else {
                    this.atributo = null;
                    return "No se encontró el atributo a actualizar.";
                }
            }else {
                this.atributo = null;
                return "Ya existe un atributo con el nombre deseado.";
            }
        }
    }
    
    /**
     * Eliminar atributo.
     * @param indice
     * @return 
     */
    public String eliminar(int indice) {
        if(atributos.get(indice) != null) {
            int posicion = Atributo.SIZE * indice;
            try {
                getArchivo().seek(posicion);
                getArchivo().writeInt(-1);
                escribirString("");
                getArchivo().writeInt(-1);
                getArchivo().writeInt(-1);
                getArchivo().writeInt(-1);
                this.atributo = new Atributo();
                return "Atributo eliminado correctamente.";
            } catch(Exception e) {                
                e.printStackTrace();
                this.atributo = null;
                return "Ocurrió un error al eliminar el atributo. " + e.getMessage();
            }
        } else {
            this.atributo = null;
            return "No se encontró el atributo a actualizar.";
        }
    }
    
    /**
     * Listar atributos almacenados.
     * @return 
     */
    public List<Atributo> listar() {
        try {
            Atributo a;
            this.atributos.clear();
            getArchivo().seek(0);
            while (true) {
                a = new Atributo();
                a.setIndice(getArchivo().readInt());
                a.setNombre(leerString());
                a.setTipo(getArchivo().readInt());
                a.setLongitud(getArchivo().readInt());
                a.setEntidad(getArchivo().readInt());
                atributos.add(a);
            }
        } catch (EOFException e) {
            return this.atributos;
        } catch (Exception e) {
            System.err.println("Ocurrio un error al leer datos del archivo " + e.getMessage());
            return null;
        }
    }

    /**
     * Escribir cadena de texto en archivo.
     * @param linea
     * @throws Exception 
     */
    private void escribirString(String linea) throws Exception {
        StringBuffer buffer = null;
        if (linea != null) {
            buffer = new StringBuffer(linea);
        } else {
            buffer = new StringBuffer(Atributo.cantidadCaracteres);
        }
        buffer.setLength(Atributo.cantidadCaracteres);
        getArchivo().writeChars(buffer.toString());
    }
    
    /**
     * Leer cadena de texto en archivo.
     * @return
     * @throws IOException 
     */
    private String leerString() throws IOException {
        char[] s = new char[Atributo.cantidadCaracteres];
        for (int i = 0; i < s.length; i++) {
            s[i] = getArchivo().readChar();
        }
        return new String(s).replace('\0', ' ');
    }

    
    public List<Atributo> obtenerPorEntidad(Integer entidad) {        
        List<Atributo> resultado = new ArrayList();
        for(Atributo atributo: this.atributos){        
            System.out.println("*************");
            System.out.println(atributo);
            if (atributo.getEntidad().equals(entidad)){                
                resultado.add(atributo);
            }
        }        
        return resultado;
    }
    
    
    /**
     * Validar por nombre si existe el atributo.
     * @param nombre
     * @return 
     */
    private boolean existe(String nombre) {
        for(Atributo atributo: this.atributos) {
            if (atributo.getNombre().trim().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Validar por indice y nombre si existe el atributo.
     * @param nombre
     * @return 
     */
    private boolean existe(Integer indice, String nombre) {
        for(Atributo atributo: this.atributos) {
            if (atributo.getNombre().trim().equals(nombre) && atributo.getIndice() != indice) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the atributos
     */
    public List<Atributo> getAtributos() {
        return atributos;
    }

    /**
     * @param atributos the atributos to set
     */
    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    /**
     * @return the atributo
     */
    public Atributo getAtributo() {
        return atributo;
    }

    /**
     * @param atributo the atributo to set
     */
    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    /**
     * @return the archivo
     */
    public RandomAccessFile getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(RandomAccessFile archivo) {
        this.archivo = archivo;
    }
    
}
