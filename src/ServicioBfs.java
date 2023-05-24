import java.sql.SQLOutput;
import java.util.*;

public class ServicioBfs {
    
    public HashMap map;
    public Grafo<?> grafo;

    public ServicioBfs(Grafo g){
        this.map=new HashMap();
        this.grafo=g;
    }

    public List<Integer> bfs() {
        Iterator it = this.grafo.obtenerVertices();
        while(it.hasNext()) {
            this.map.put(it.next(),"no_visit");
        }

        List<Integer> lista = new ArrayList<>();
        Iterator<Integer> it2 = this.grafo.obtenerVertices();

        while(it2.hasNext()) {
            int aux = it2.next();
            if(this.map.get(aux).equals("no_visit")) {
                lista.add(aux);
                bfs_visit(aux,lista);
            }
        }
        return lista;
    }

    public void bfs_visit(int vertice, List lista) {
        Queue<Integer> cola = new LinkedList<>();
        this.map.replace(vertice,"visit");
        cola.offer(vertice); //Agrego el vertice a la lista

        while(!cola.isEmpty()) { //Mientras lista no este vacia
            Integer v = cola.poll(); //Agarro el primer elemento y lo borro
            Iterator<Integer> it = this.grafo.obtenerAdyacentes(v); //Busco los adyacentes del que borre
            while(it.hasNext()) {
                int it2 = it.next();
                if(this.map.get(it2).equals("no_visit")) {
                    this.map.replace((it2),"visit");
                    lista.add(it2);
                    cola.offer(it2);
                }
            }
        }


    }

}
