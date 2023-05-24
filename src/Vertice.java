import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
    private int id;
    private ArrayList<Arco> adyacentes;

    public Vertice(int id){
        this.id = id;
        this.adyacentes = new ArrayList<Arco>();
    }

    public void addAdyacentes(int id2, T etiqueta) {
        if(this.contiene(id2) == false) {
            this.adyacentes.add(new Arco(this.id,id2,etiqueta));
        }
    }

    public boolean contiene(int idDestino){
        for(int i = 0; i < adyacentes.size(); i++){
            if(adyacentes.get(i).getVerticeDestino() == idDestino){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Tamaño de mi lista de adyacentes
    public int adyacentesSize() {
        return adyacentes.size();
    }

    public List getAdyacentes() {
        return this.adyacentes;
    }

    //Retorna una copia de la lista de arcos
    public ArrayList<Arco> getListaArco() {
        return new ArrayList<>(this.adyacentes);
    }

    //Agarrar un arco con un id que me pasan
    public Arco<T> getArco (int id){
        for(int i = 0; i < this.adyacentesSize(); i++){
            if(adyacentes.get(i).getVerticeDestino() == id) {
                return this.adyacentes.get(i);
            }
        }
        return null;
    }

    //Tomar todos los id adyacentes de un vertice x
    public ArrayList<Integer> getIdAdyacentes(){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for(int i = 0; i < adyacentesSize(); i++) {
            aux.add(this.adyacentes.get(i).getVerticeDestino());
        }
        return aux;
    }

    public boolean deleteArco(int id) {
        if(this.contiene(id) == true) { //Si mi lista contiene ese arco
            for(int i = 0; i < this.adyacentesSize(); i++) { //La recorro
                if(this.adyacentes.get(i).getVerticeDestino() == id) { //Comparo el id que me pasan y lo encuentro 
                    this.adyacentes.remove(this.adyacentes.get(i)); //Borro el arco id = i.
                }
            }
        }
        return false;
    }


}
