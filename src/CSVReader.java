import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void read(Libreria libreria) {
        String csvFile = "src/libros/dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                Libro libro = new Libro(items[0],items[1],items[2]);
                String []aux = items[3].split(" ");
            
                for(int j=0;j<aux.length;j++){
                    libro.addGeneros(aux[j]);
                }
                libreria.addLibros(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}