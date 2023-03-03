
package lab6p2_diegoandino;

import java.util.ArrayList;

public class Oyente extends Usuario{
     private ArrayList<Cancion> canciones = new ArrayList();
    private ArrayList<ListaRep> Creadas  = new ArrayList();
    private ArrayList<ListaRep> ConLike = new ArrayList();

    public Oyente() {
        super();
    }

    public Oyente(String username, float password, int edad) throws Exception {
        super(username, password);
        setEdad(edad);
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<ListaRep> getListasCreadas() {
        return Creadas;
    }

    public void setListasCreadas(ArrayList<ListaRep> listasCreadas) {
        this.Creadas = Creadas;
    }

    public ArrayList<ListaRep> getListasConLike() {
        return ConLike;
    }

    public void setListasConLike(ArrayList<ListaRep> listasConLike) {
        this.ConLike = ConLike;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) throws Exception {
        if(edad > 12){
            this.edad = edad;
        }else{
            throw new Exception("Edad debe ser mayor a 12");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - Oyente";
    }
    
}
