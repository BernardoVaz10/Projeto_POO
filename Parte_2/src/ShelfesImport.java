import java.util.ArrayList;
/**
 * This class ShelfesImport, is the class that will read the file shelfes.csv and
 * store the lines in an arraylist
 *
 * @author Bernardo e Tiago
 * @version June 2023
 */
public class ShelfesImport {
    public static final String FILEPATH = "files/shelfes.csv";
    private ArrayList<Shelf> shelfes;

    /**
     * Constructor for objects of class ShelfesImport
     */
    public ShelfesImport() {
        this.shelfes = new ArrayList<>();
        readShelfes();
    }

    /**
     * Method that reads the file shelfes.csv
     */
    public void readShelfes() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            shelfes.add(parseShelfes(line));
        }
    }

    /**
     * Method that parses the lines and creates the shelfes
     * 
     * @param line
     * @return the shelfes
     */
    public Shelf parseShelfes(String line) {
        String[] shelfes = line.split(",");

        String x = shelfes[0];
        String y = shelfes[1];
        String dir = shelfes[2];
        String x2 = shelfes[3];
        String y2 = shelfes[4];

        return new Shelf(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir), Integer.parseInt(x2),
                Integer.parseInt(y2));
    }

    /**
     * Method that returns the shelfes
     * 
     * @return the shelfes
     */
    public ArrayList<Shelf> getShelfes() {
        return shelfes;
    }
}