import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {

    public void escribir(ArrayList result) {
        BufferedWriter bw = null;
        
        try {
            File file = new File("/home/siu-mapuche/TUDAI/Programacion_3/tp_especial/src/libros/salida.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

    	for(int i = 0; i < result.size(); i++){
    		bw.write(result.get(i).toString());
            bw.newLine();
    	}

            /*
             *
             * ...
             *
             */

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
