import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDfs {
    public HashMap map;
    public Grafo<?> grafo;

    public ServicioDfs(Grafo<?> g) {
        this.map=new HashMap();
        this.grafo = g;
    }

    public List<Integer> dfs() {
        Iterator<Integer> it = this.grafo.obtenerVertices();
        ArrayList<Integer> lista = new ArrayList();
        
        while(it.hasNext()) {
            this.map.put(it.next(),"blanco");
        }

        Iterator<Integer> it2 = this.grafo.obtenerVertices();
        while(it2.hasNext()) {
            int aux = it2.next();
            if(map.get(aux).equals("blanco")) {
                lista.add(aux);
                dfs_visit(aux,lista);
            }
        }
        return lista;
    }

    public void dfs_visit(int vertice,ArrayList lista) {
        this.map.replace(vertice, "Amarillo");

        Iterator<Integer> it3 = this.grafo.obtenerAdyacentes(vertice);
        while(it3.hasNext()) {
            int aux = it3.next();
            if(map.get(aux).equals("blanco")) {
                lista.add(aux);
                dfs_visit(aux,lista);
            }
        }
        this.map.replace(vertice, "Negro");
    }
    




}
