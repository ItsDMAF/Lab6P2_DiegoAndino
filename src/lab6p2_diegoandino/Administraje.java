package lab6p2_diegoandino;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administraje {

    private File fUsuarios;
    private File fLanzamientos;
    private File fCanciones;
    private File fListaReproduccion;
    private File bitacora;

    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Lanzamiento> lanzamientos = new ArrayList();
    private ArrayList<Cancion> canciones = new ArrayList();
    private ArrayList<ListaRep> listas = new ArrayList();

    public Administraje() {
    }

    public Administraje(String d, String d2, String d3, String d4, String d5) {
        fUsuarios = new File(d);
        fLanzamientos = new File(d2);
        fCanciones = new File(d3);
        fListaReproduccion = new File(d4);
        bitacora = new File(d5);
    }

    public File getfUsuarios() {
        return fUsuarios;
    }

    public void setfUsuarios(File fUsuarios) {
        this.fUsuarios = fUsuarios;
    }

    public File getfLanzamientos() {
        return fLanzamientos;
    }

    public void setfLanzamientos(File fLanzamientos) {
        this.fLanzamientos = fLanzamientos;
    }

    public File getfCanciones() {
        return fCanciones;
    }

    public void setfCanciones(File fCanciones) {
        this.fCanciones = fCanciones;
    }

    public File getfListaReproduccion() {
        return fListaReproduccion;
    }

    public void setfListaReproduccion(File fListaReproduccion) {
        this.fListaReproduccion = fListaReproduccion;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Lanzamiento> getLanzamientos() {
        return lanzamientos;
    }

    public void setLanzamientos(ArrayList<Lanzamiento> lanzamientos) {
        this.lanzamientos = lanzamientos;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<ListaRep> getListas() {
        return listas;
    }

    public void setListas(ArrayList<ListaRep> listas) {
        this.listas = listas;
    }

    public void cargarArchivos() {

        try {
            Scanner userleer = new Scanner(fUsuarios);
            Scanner lanzaleer = new Scanner(fLanzamientos);
            Scanner cancleer = new Scanner(fCanciones);
            Scanner listleer = new Scanner(fListaReproduccion);
//USER--------------------------------------------------------------------------
            while (userleer.hasNextLine()) {
                String temp = userleer.nextLine();
                String[] arreglo = temp.split("-");

                if (arreglo.length == 3) {

                    Oyente oye = new Oyente(arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]));

                    usuarios.add(oye);
                } else {
                    Artista art = new Artista(arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]), arreglo[3]);
                    usuarios.add(art);
                }
            }
//LIST--------------------------------------------------------------------------
            while (listleer.hasNextLine()) {
                String temp = listleer.nextLine();
                String[] array = temp.split("-");

                listas.add(new ListaRep(array[0], Integer.parseInt(array[1])));
            }
//LANZAMIENTO-------------------------------------------------------------------
            while (lanzaleer.hasNextLine()) {
                String temp = lanzaleer.nextLine();
                String[] array = temp.split("-");

                if (array.length == 5) {
                    Album album = new Album(array[0], new Date(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                    album.setConteoLikes(Integer.parseInt(array[4]));
                    lanzamientos.add(album);
                } else {
                    Singles single = new Singles(array[0], new Date(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                    lanzamientos.add(single);

                }

            }
//CANCIONES---------------------------------------------------------------------
            while (cancleer.hasNextLine()) {
                String temp = cancleer.nextLine();
                String[] array = temp.split("-");

                Cancion c = new Cancion(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]));

                String[] arr2 = array[3].split(",");

                for (String string : arr2) {
                    c.getPlaylists().add(Integer.parseInt(string));
                    for (ListaRep l : listas) {
                        if (l.getIdentidad() == Integer.parseInt(string)) {
                            l.getCanciones().add(c);
                        }
                    }
                }
                for (Lanzamiento l : lanzamientos) {
                    if (l.getIdentidad() == c.getAlbumPerteneciente()) {
                        if (l instanceof Album) {
                            ((Album) l).getCanciones().add(c);
                        } else {
                            ((Singles) l).setCancion(c);
                        }
                    }
                }
                canciones.add(c);
            }

            userleer.close();
            lanzaleer.close();
            cancleer.close();
            listleer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administraje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }

    }
//ESCRIBE-----------------------------------------------------------------------
    public void escribeUser() {
        try {
            FileWriter escriba = new FileWriter(fUsuarios, false);
            BufferedWriter bw = new BufferedWriter(escriba);
            for (Usuario u : usuarios) {

                bw.write(u.getUsername() + "-" + u.getPassword() + "-" + u.getEdad());

                if (u instanceof Artista) {
                    bw.write("-" + ((Artista) u).getNombreArtistico());

                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administraje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribeCanciones() {

        try {
            FileWriter escriba = new FileWriter(fCanciones, false);
            BufferedWriter bw = new BufferedWriter(escriba);

            for (Cancion c : canciones) {
                bw.write(c.getTitulo() + "-" + c.getTiempo() + "-" + c.getAlbumPerteneciente() + "-");
                for (int a : c.getPlaylists()) {
                    bw.write(Integer.toString(a));
                    if (c.getPlaylists().indexOf(a) != c.getPlaylists().size() - 1) {
                        bw.write(",");
                    }
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administraje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void escribeLanzamientos() {
        try {
            FileWriter escriba = new FileWriter(fLanzamientos);
            BufferedWriter bw = new BufferedWriter(escriba);

            for (Lanzamiento l : lanzamientos) {
                bw.write(l.getTitulo() + "-" + l.getIdentidad() + "" + l.getConteoLikes() + "/" + l.getFechaLanzamiento());

                if (l instanceof Album) {
                    bw.write(((Album) l).getCantidadCanciones());
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administraje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribeList() {
        try {
            FileWriter escriba = new FileWriter(fListaReproduccion);
            BufferedWriter bw = new BufferedWriter(escriba);
            for (ListaRep r : listas) {
                bw.write(r.getNombre() + "/" + r.getConteoLikes() + "/" + r.getUsuario() + "/" + r.getIdentidad());
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administraje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribeBitacora(Usuario u) {
        try {
            FileWriter escriba = new FileWriter(bitacora);
            BufferedWriter bw = new BufferedWriter(escriba);
            bw.write(u.getUsername() + "/");
            if (u instanceof Oyente) {
                bw.write("Oyente/");
            } else {
                bw.write("Artista/");
            }
            Date d = new Date();
            bw.write(d.toString());
            bw.write("\n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administraje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
