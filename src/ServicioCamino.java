import java.util.*;

public class ServicioCamino {
    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;
    private HashMap map;

    public ServicioCamino(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        this.map=new HashMap();
    }

    //Pongo todos los vertices en blanco
    public List<List<Integer>> camino() {
        Iterator it = this.grafo.obtenerVertices();
        
        while(it.hasNext()) {
            this.map.put(it.next(),"blanco");
        }

        List<Integer> lista = new ArrayList<>();
        List<List<Integer>> recorrido = new ArrayList();
        
        Iterator<Integer> it2 = this.grafo.obtenerAdyacentes(this.origen);
        while(it2.hasNext()) {
            int i = it2.next();
            if(this.map.get(i).equals("blanco")) {
                lista.add(i);
                camino_visit(i,lista,recorrido);
            }
        }
        return recorrido;
    }

    public void camino_visit(int i, List lista, List<List<Integer>> recorrido) {
        this.map.replace(i, "amarillo");
        //Controlo si la lista es mayor al limite
        if(lista.size() < this.lim) {
            if(this.destino == i) {
                recorrido.add(lista);
            } else {
                Iterator<Integer> it3 = this.grafo.obtenerAdyacentes(i);
                while(it3.hasNext()) {
                    int aux = it3.next();
                    if(this.map.get(aux).equals("blanco")) {
                        if(this.grafo.contieneAdy(aux) == true){
                            lista.add(aux);
                            camino_visit(aux,lista,recorrido);
                        }
                    }
                }
            }
        }
        this.map.replace(i,"blanco");
    }

}
