package lab6p2_diegoandino;

import java.util.Date;

public class Lanzamiento {
protected String titulo;
    protected Date fechaLanzamiento;
    protected int conteoLikes;
    protected int identidad;
    protected String creador;

    public Lanzamiento() {
    }

    public Lanzamiento(String titulo, Date fechaLanzamiento, int conteoLikes, int id, String creador) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.conteoLikes = conteoLikes;
        this.identidad = identidad;
        this.creador = creador;
    }

    public int getIdentidad() {
        return identidad;
    }

    public void setIdentidad(int id) {
        this.identidad = identidad;
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public int getConteoLikes() {
        return conteoLikes;
    }

    public void setConteoLikes(int conteoLikes) {
        this.conteoLikes = conteoLikes;
    }

    @Override
    public String toString() {
        return titulo + ":" + conteoLikes + ":" + fechaLanzamiento;
    }
}
