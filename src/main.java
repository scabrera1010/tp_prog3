import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        CSVReader reader=new CSVReader();
        CSVWritter writte= new CSVWritter();

        Libreria libreria=new Libreria();

        reader.read(libreria);

       // long startTime = System.currentTimeMillis();

        System.out.println(libreria.getByGenero("cine"));

        ArrayList salida = libreria.getByGenero("cine");

        writte.escribir(salida);
        //System.out.println(libreria.getContador());

       // long endTime = System.currentTimeMillis() - startTime;

      //  System.out.println("Tiempo de ejecucion = " + Long.toString(endTime));


    }

}
