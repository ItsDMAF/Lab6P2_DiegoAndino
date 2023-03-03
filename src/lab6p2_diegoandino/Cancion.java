
package lab6p2_diegoandino;

public class Cancion {
    private String titulo;
    private int tiempo;
    private int albumPer;

    public Cancion() {
    }

    public Cancion(String titulo, int tiempo,  int albumPerteneciente) {
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

    @Override
    public String toString() {
        return titulo + " - " + tiempo + " : " + albumPer;
    }
    
}
