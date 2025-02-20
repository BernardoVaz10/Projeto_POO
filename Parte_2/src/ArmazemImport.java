import java.util.ArrayList;

/**
 * The class ArmazemImport will read the file armazem.csv and will create the
 * armazem.
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */
public class ArmazemImport {
    public static final String FILEPATH = "files/armazem.csv";
    private ArrayList<Armazem> armazem;

    /**
     * Constructor for objects of class ArmazemImport
     */
    public ArmazemImport() {
        this.armazem = new ArrayList<>();
        readArmazem();
    }

    /**
     * Method to read the file armazem.csv
     */
    public void readArmazem() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            armazem.add(parseArmazem(line));
        }
    }

    /**
     * Method to parse the file armazem.csv
     * 
     * @param line
     * @return
     */
    public Armazem parseArmazem(String line) {
        String[] armazem = line.split(",");

        String name = armazem[0];
        String x = armazem[1];
        String y = armazem[2];

        return new Armazem(name, Integer.parseInt(x), Integer.parseInt(y));
    }

    /**
     * Method to get the armazem
     * 
     * @return armazem
     */
    public ArrayList<Armazem> getArmazem() {
        return armazem;
    }
}
