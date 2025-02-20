import java.util.ArrayList;

/**
 * This class LocaisImport, is the class that will read the file locais.csv and
 * store the lines in an arraylist
 *
 * @author Bernardo e Tiago
 * @version June 2023
 */
public class LocaisImport {
    public static final String FILEPATH = "files/locais.csv";
    private ArrayList<String> locais;

    /**
     * Constructor for objects of class LocaisImport
     */
    public LocaisImport() {
        this.locais = new ArrayList<>();
        readLocais();
    }

    /**
     * Method that reads the file locais.csv
     */
    public void readLocais() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            locais.add(line);
        }
    }

    /*
     * public Local parseLocais(String line) {
     * String[] locais = line.split(",");
     * 
     * String name = locais[0];
     * String x = locais[1];
     * String y = locais[2];
     * 
     * if(name.equals("venda")){
     * return new Venda(null, null)
     * }
     * else if(name.equals("armazenamento")){
     * return new Armazenamento(name, Integer.parseInt(x), Integer.parseInt(y));
     * }
     * }
     */
}
