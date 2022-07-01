
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Libreria {
    ArrayList<Libro> libros;
    private String genero;
    private Libreria left;
    private Libreria right;
    static int contador = 0;

    public Libreria(){
        this.libros=new ArrayList<>();
    }

    public void addLibros(Libro libro){
      Iterator<String> it = libro.getGeneros().iterator();
      while(it.hasNext()){
          String genero = it.next();
          addLibro(libro,genero);
          
        }
    }

    private void addLibro(Libro l, String g) {
        contador++;
        if(this.genero == null) {
            this.genero = g;
            this.libros.add(l);
            return ;
        }else if(this.genero.equals(g)){
            this.libros.add(l);
            return;
        } else {
            if(this.genero.compareTo(g) > 0){
                if(this.left != null){
                    this.left.addLibro(l,g);
                }else {
                    this.left = new Libreria();
                    this.left.addLibro(l,g);
                }
            }else{
                if(this.genero.compareTo(g) < 0){
                    if(this.right != null){
                        this.right.addLibro(l,g);
                    }else {
                        this.right = new Libreria();
                        this.right.addLibro(l,g);
                    }

                }

            }

        }
    }

    public int getContador(){
        return this.contador;
    }


    public ArrayList getByGenero(String genero_dado){
        
        ArrayList aux=new ArrayList();
        if(this.genero.compareTo(genero_dado)==0){
            return this.libros;
        }
        if(this.genero.compareTo(genero_dado)>0){
            if(this.left!=null){
                return this.left.getByGenero(genero_dado);
            }
        }
        if(this.genero.compareTo(genero_dado)<0){
            if(this.right!=null){
                return this.right.getByGenero(genero_dado);
            }
        }
        return aux;
    }

}
