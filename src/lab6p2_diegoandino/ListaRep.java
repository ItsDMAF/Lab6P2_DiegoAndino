
package lab6p2_diegoandino;

import java.util.ArrayList;

public class ListaRep {
    private String nombre;
    private int contLikes;
    private ArrayList<Cancion> canciones = new ArrayList();
    private String usuario;
    private int identidad;

    public ListaRep() {
    }

    public ListaRep(String nombre, int conteoLikes) {
        this.nombre = nombre;
        this.contLikes = conteoLikes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getConteoLikes() {
        return contLikes;
    }

    public void setConteoLikes(int conteoLikes) {
        this.contLikes = conteoLikes;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public int getContLikes() {
        return contLikes;
    }

    public void setContLikes(int contLikes) {
        this.contLikes = contLikes;
    }

    public int getIdentidad() {
        return identidad;
    }

    public void setIdentidad(int identidad) {
        this.identidad = identidad;
    }
    

    @Override
    public String toString() {
        return nombre + " - " + canciones.size() + " canciones - " + contLikes + " likes";
    }

    
    
}
