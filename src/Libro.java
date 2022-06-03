import java.util.ArrayList;
import java.util.Iterator;


public class Libro {
    private String titulo;
    private String autor;
    private String cantHojas;
    private ArrayList generos;

    public Libro(String titulo, String autor, String cantHojas) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantHojas = cantHojas;
        this.generos =new ArrayList<String>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCantHojas() {
        return cantHojas;
    }

    public void setCantHojas(String cantHojas) {
        this.cantHojas = cantHojas;
    }
    public void addGeneros(String g){
        this.generos.add(g);
    }

    public ArrayList getGeneros(){
        return this.generos;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }
}
