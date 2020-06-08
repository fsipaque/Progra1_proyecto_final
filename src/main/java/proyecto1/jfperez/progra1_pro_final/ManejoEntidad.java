/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.jfperez.progra1_pro_final;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josep
 */
public class ManejoEntidad {
    
    /***
     * Ruta del archivo de entidades.
     */
    String ruta = "entidad.dat";
    
    /**
     * Listado de entidades almacenadas.
     */
    private List<Entidad> entidades;
    
    /**
     * Entidad cargada actualmente.
     */
    private Entidad entidad;
    
    /**
     * Variable para acceder a archivo de entidades.
     */
    RandomAccessFile archivo;
    
    /**
     * Constructor
     */
    public ManejoEntidad() {
        try {
            this.abrirArchivo(ruta);        
            this.entidades = new ArrayList();
        } catch (Exception ex) {
            ex.printStackTrace();            
        }
    }
    
    /**
     * Abrir archivo de entidades.
     * @param ruta
     * @throws Exception 
     */
    public void abrirArchivo(String ruta) throws Exception {
        archivo = new RandomAccessFile(ruta, "rw");
    }
    
    /**
     * Cerrar archivo de entidades.
     * @throws Exception 
     */
    public void cerrarArchivo() throws Exception {
        if (archivo != null) {
            archivo.close();
        }
    }
    
    /**
     * Obtener entidad a través de índice.
     * @param indice
     * @return 
     */
    public Entidad obtener(Integer indice) {        
        int posicion = Entidad.SIZE * indice;       
        this.setEntidad(new Entidad());
        try {
            archivo.seek(posicion);
            this.getEntidad().setIndice(archivo.readInt());
            this.getEntidad().setNombre(leerString());
            this.getEntidades().set(indice, getEntidad());
            return this.getEntidad();
        } catch (EOFException e) {
            return null;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }        
    }       
    
    /**
     * Crear o actualizar entidad.
     * @param entidad
     * @return 
     */
    public String guardar(Entidad entidad) {
        if (entidad.getIndice() == null) { // registro nuevo
            if (!this.existe(entidad.getNombre())) {
                int indice = this.getEntidades().size();            
                entidad.setIndice(indice);
                int posicion = Entidad.SIZE * indice;
                try {
                    archivo.seek(posicion);
                    archivo.writeInt(indice);
                    this.escribirString(entidad.getNombre());
                    this.getEntidades().add(entidad);
                    this.entidad = entidad;
                    return "Entidad creada correctamente.";
                } catch(Exception ex) {
                    ex.printStackTrace();
                    this.entidad = null;
                    return "Ocurrió un error al crear entidad. " + ex.getMessage();
                }            
            } else {
                this.entidad = null;
                return "Ya existe una entidad con el nombre deseado.";
            }
        } else {
            if (!this.existe(entidad.getIndice(), entidad.getNombre())) {
                if(this.getEntidades().get(entidad.getIndice()) != null) {
                    int posicion = Entidad.SIZE * entidad.getIndice();
                    try {
                        this.archivo.seek(posicion);
                        archivo.writeInt(entidad.getIndice());
                        this.escribirString(entidad.getNombre());
                        this.getEntidades().set(entidad.getIndice(), entidad);
                        this.entidad = entidad;
                        return "Entidad actualizada correctamente.";
                    } catch(Exception e) {
                        e.printStackTrace();
                        this.entidad = null;
                        return "Ocurrió un error al actualizar entidad. " + e.getMessage();
                    }
                } else {
                    this.entidad = null;
                    return "No se encontró la entidad a actualizar.";
                }
            }else {
                this.entidad = null;
                return "Ya existe una entidad con el nombre deseado.";
            }
        }
    }
    
    /**
     * Eliminar entidad.
     * @param indice
     * @return 
     */
    public String eliminar(int indice) {
        if(this.getEntidades().get(indice) != null) {
            int posicion = Entidad.SIZE * indice;
            try {
                archivo.seek(posicion);
                archivo.writeInt(-1);
                escribirString("");
                this.entidad = new Entidad();
                return "Entidad eliminada correctamente.";
            } catch(Exception e) {                
                e.printStackTrace();
                this.entidad = null;
                return "Ocurrió un error al eliminar la entidad. " + e.getMessage();
            }
        } else {
            this.entidad = null;
            return "No se encontró la entidad a actualizar.";
        }
    }
    
    /**
     * Listar entidades almacenadas.
     * @return 
     */
    public List<Entidad> listar() {
        try {
            Entidad e;
            this.entidades.clear();
            archivo.seek(0);
            while (true) {
                e = new Entidad();
                e.setIndice(archivo.readInt());
                e.setNombre(leerString());
                this.getEntidades().add(e);
            }
        } catch (EOFException e) {
            return this.getEntidades();
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
            buffer = new StringBuffer(Entidad.cantidadCaracteres);
        }
        buffer.setLength(Entidad.cantidadCaracteres);
        archivo.writeChars(buffer.toString());
    }
    
    /**
     * Leer cadena de texto en archivo.
     * @return
     * @throws IOException 
     */
    private String leerString() throws IOException {
        char[] s = new char[Entidad.cantidadCaracteres];
        for (int i = 0; i < s.length; i++) {
            s[i] = archivo.readChar();
        }
        return new String(s).replace('\0', ' ');
    }

    /**
     * @return the entidades
     */
    public List<Entidad> getEntidades() {
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    /**
     * @return the entidad
     */
    public Entidad getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    
    /**
     * Validar por nombre si existe la entidad.
     * @param nombre
     * @return 
     */
    private boolean existe(String nombre) {
        for(Entidad entidad: this.entidades) {
            if (entidad.getNombre().trim().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Validar por indice y nombre si existe la entidad.
     * @param nombre
     * @return 
     */
    private boolean existe(Integer indice, String nombre) {
        for(Entidad entidad: this.entidades) {
            if (entidad.getNombre().trim().equals(nombre) && entidad.getIndice() != indice) {
                return true;
            }
        }
        return false;
    }

    /**
     * Función para validar si está vacío el archivo.
     */
    public boolean estaArchivoVacio() {
        try {
            RandomAccessFile archivo = new RandomAccessFile(this.entidad.nombreArchivo() + ".dat", "rw");
            return !(archivo.length() > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }        
    }
    
}
