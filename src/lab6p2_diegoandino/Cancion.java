package lab6p2_diegoandino;

import java.util.ArrayList;

public class Cancion {

    private String titulo;
    private int tiempo;
    private int albumPer;
    private ArrayList<Integer> playlists = new ArrayList();

    public Cancion() {
    }

    public Cancion(String titulo, int tiempo, int albumPer) {
        this.titulo = titulo;
        this.tiempo = tiempo;
        this.albumPer = albumPer;
    }

   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getAlbumPerteneciente() {
        return albumPer;
    }

    public void setAlbumPerteneciente(int albumPerteneciente) {
        this.albumPer = albumPerteneciente;
    }

    public int getAlbumPer() {
        return albumPer;
    }

    public void setAlbumPer(int albumPer) {
        this.albumPer = albumPer;
    }

    public ArrayList<Integer> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Integer> playlists) {
        this.playlists = playlists;
    }

   
    @Override
    public String toString() {
        return titulo + " - " + tiempo + " : " + albumPer;
    }

}
