
package lab6p2_diegoandino;

import java.util.ArrayList;

public class Artista extends Usuario {
    protected String Artistico;
    protected ArrayList<Cancion> canciones = new ArrayList();
    protected ArrayList<Album> albumes = new ArrayList();

    public Artista() {
        super();
    }

    public Artista(String nombreArtistico, String username, float password, int edad) throws Exception {
        super(username, password);
        this.Artistico = nombreArtistico;
        setEdad(edad);
    }

    public String getNombreArtistico() {
        return Artistico;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) throws Exception {
        if(edad > 18){
            this.edad = edad;
        }else{
            throw new Exception("Ingrese edad valida");
        }
    }

    @Override
    public String toString() {
        return super.toString()+" - Artista";
    }
}
