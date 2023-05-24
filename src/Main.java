import java.util.Iterator;

public class Main<T> {
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();  
        
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);
        grafo.agregarVertice(9);
        grafo.agregarArco(2,7, "2 a 7");
        grafo.agregarArco(7,1, "7 a 1");
        grafo.agregarArco(1,3, "1 a 3");
        grafo.agregarArco(3,9, "3 a 9");
        grafo.agregarArco(3,4, "3 a 4");
        grafo.agregarArco(4,6, "4 a 6");
        grafo.agregarArco(4,5, "4 a 5");
        grafo.agregarArco(5,8, "5 a 8");
        grafo.agregarArco(6,8, "6 a 8");

        ServicioDfs dfs=new ServicioDfs(grafo);
        ServicioBfs bfs=new ServicioBfs(grafo);
        System.out.println("Orden posible dfs : "+ dfs.dfs());
        System.out.println("Orden posible bfs : "+ bfs.bfs());
        ServicioCamino caminos=new ServicioCamino(grafo,2,4,6);
        System.out.println("El camino es : "+caminos.camino());
        
        
    }
}