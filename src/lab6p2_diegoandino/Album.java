
package lab6p2_diegoandino;

import java.util.ArrayList;
import java.util.Date;

public class Album extends Lanzamiento {
    private ArrayList<Cancion> canciones = new ArrayList();
    private int cantCanciones = 0;

    public Album(String par, Date date, int parseInt, int parseInt1) {
        super();
    }

    public Album(String titulo, Date fechaLanzamiento, int conteoLikes) {
        super(titulo, fechaLanzamiento, conteoLikes);
    }

    public void addCancion(Cancion c) {
        canciones.add(c);
        cantCanciones++;
    }

    public void removeCanciones(Cancion c) {
        if (canciones.contains(c)) {
            canciones.remove(c);
            cantCanciones--;
        }
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
        cantCanciones = canciones.size();
    }

    public int getCantidadCanciones() {
        return cantCanciones;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantCanciones = cantidadCanciones;
    }

    @Override
    public String toString() {
        return super.toString() + ":" +cantCanciones + " canciones";
    }
}
