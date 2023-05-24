import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private ArrayList<Vertice> vertice;

    public GrafoDirigido() {
        this.vertice = new ArrayList<Vertice>();
    }

    @Override
    public void agregarVertice(int idVertice) {
        if (this.contieneVertice(idVertice) == false) {
            this.vertice.add(new Vertice(idVertice));
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        int pos = getPosVertice(verticeId1);
        if (pos >= 0) {
            if (this.contieneVertice(verticeId2) == true) {
                this.vertice.get(pos).addAdyacentes(verticeId2, etiqueta); // En la lista de vertices busco la posicion
                                                                           // del que estoy y agrego el adyacente
            }
        }
    }

    // Obtengo la posicion de un vertice
    public int getPosVertice(int idVertice) {
        for (int i = 0; i < vertice.size(); i++) {
            if (vertice.get(i).getId() == idVertice) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void borrarVertice(int idVertice) {
        int pos = getPosVertice(idVertice); // Agarro la posicion del vertice a borrar
        if (pos >= 0) { // Si tiene posicion
            for (int i = 0; i < vertice.size(); i++) { // Recorro todos los vertices
                this.vertice.get(i).deleteArco(idVertice); // Elimino los arcos que tiene el vertice
            }
            this.vertice.remove(pos);
        }
    }

    @Override
    public boolean contieneVertice(int idVertice) {
        for (int i = 0; i < this.vertice.size(); i++) {
            if (this.vertice.get(i).getId() == idVertice) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        int pos = this.getPosVertice(verticeId1);
        if (pos >= 0) {
            if (this.contieneVertice(verticeId2) == true) {
                this.vertice.get(pos).deleteArco(verticeId2);
            }
        }
    }

    @Override
    public int cantidadArcos() {
        int total = 0;
        for (int i = 0; i < vertice.size(); i++) {
            total = total + vertice.get(i).adyacentesSize();
        }
        return total;
    }

    @Override
    public int cantidadVertices() {
        return this.vertice.size();
    }

    // Obtiene un iterador que me permite recorrer todos los vertices almacenados en
    // el grafo
    @Override
    public Iterator<Integer> obtenerVertices() {
        Iterator<Integer> it = this.getIdVertice().iterator();
        return it;
    }

    @Override
    // Obtiene un iterador que me permite recorrer todos los vertices adyacentes a
    // verticeId
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        int pos = getPosVertice(verticeId);
        if (pos >= 0) {
            Iterator<Integer> it = this.vertice.get(pos).getIdAdyacentes().iterator();
            return it;
        }
        return null;
    }

    // Trea una lista con todos los vertices del grafo
    private ArrayList<Integer> getIdVertice() {
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for (int i = 0; i < vertice.size(); i++) {
            aux.add(vertice.get(i).getId());
        }
        return aux;
    }

    // Obtiene un iterador que me permite recorrer todos los arcos del grafo
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> aux = new ArrayList<>();
        for (int i = 0; i <= vertice.size(); i++) {
            aux.addAll(vertice.get(i).getIdAdyacentes());
        }
        Iterator it = aux.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return it;

    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        int pos = this.getPosVertice(verticeId);
        if (pos >= 0) {
            Iterator it = this.vertice.get(pos).getListaArco().iterator();
            while (it.hasNext()) {
                it.next();
            }
            return it;
        }
        return null;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        int pos = this.getPosVertice(verticeId1);
        if (pos >= 0) {
            if (this.contieneVertice(verticeId2) == true) {
                return this.vertice.get(pos).getArco(verticeId2);
            }
        }
        return null;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        int pos = this.getPosVertice(verticeId1);
        if (pos >= 0) {
            if (this.contieneVertice(verticeId2) == true) {
                return this.vertice.get(pos).contiene(verticeId2);
            }
        }
        return false;
    }

    @Override
    public boolean contieneAdy(int verticeId1) {
        int pos = this.getPosVertice(verticeId1);
        if(pos >= 0){
            if(this.vertice.get(pos).getAdyacentes().size() > 0){
                return true;
            } else {
                return false;
            }
        } 
        return false;
    }
}