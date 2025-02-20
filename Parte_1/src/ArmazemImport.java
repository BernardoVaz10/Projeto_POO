import java.util.ArrayList;

public class ArmazemImport {
    public static final String FILEPATH = "projPOO/files/armazem.csv";
    private ArrayList<Armazem> armazem;

    public ArmazemImport() {
        this.armazem = new ArrayList<>();
        readArmazem();
    }

    // read the file and store the lines in the arraylist
    public void readArmazem() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            armazem.add(parseArmazem(line));
        }
    }

    // parse the lines and create the shelfes
    public Armazem parseArmazem(String line) {
        String[] armazem = line.split(",");

        String name = armazem[0];
        String x = armazem[1];
        String y = armazem[2];

        return new Armazem(name, Integer.parseInt(x), Integer.parseInt(y));
    }

    // get the shelfes
    public ArrayList<Armazem> getArmazem() {
        return armazem;
    }
}
