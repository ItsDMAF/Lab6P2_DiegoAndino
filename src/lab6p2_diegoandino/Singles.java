
package lab6p2_diegoandino;

import java.util.Date;

public class Singles extends Lanzamiento {
      private Cancion cancion;

    public Singles() {
        super();
    }

    public Singles(String titulo, Date fechaLanzamiento, int conteoLikes, int id, String creador) {
        super(titulo, fechaLanzamiento, conteoLikes, id, creador);
    }

    
    public Singles(Cancion cancion, String titulo, Date fechaLanzamiento, int conteoLikes, int id, String creador) {
        super(titulo, fechaLanzamiento, conteoLikes, id, creador);
        this.cancion = cancion;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return super.toString()+":"+cancion;
    }
}
