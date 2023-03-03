
package lab6p2_diegoandino;

import java.util.Date;

public class Lanzamiento {
    protected String titulo;
    protected Date fechaLanz;
    protected int contLikes;

    public Lanzamiento() {
    }

    public Lanzamiento(String titulo, Date fechaLanzamiento, int conteoLikes) {
        this.titulo = titulo;
        this.fechaLanz = fechaLanzamiento;
        this.contLikes = conteoLikes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLanzamiento() {
        return fechaLanz;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanz = fechaLanzamiento;
    }

    public int getConteoLikes() {
        return contLikes;
    }

    public void setConteoLikes(int conteoLikes) {
        this.contLikes = conteoLikes;
    }

    @Override
    public String toString() {
        return titulo + ":" + contLikes + ":" + fechaLanz;
    }
}
