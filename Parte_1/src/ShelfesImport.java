import java.util.ArrayList;

public class ShelfesImport {
    public static final String FILEPATH = "projPOO/files/shelfes.csv";
    private ArrayList<Shelf> shelfes;

    public ShelfesImport() {
        this.shelfes = new ArrayList<>();
        readShelfes();
    }

    // read the file and store the lines in the arraylist
    public void readShelfes() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            shelfes.add(parseShelfes(line));
        }
    }

    // parse the lines and create the shelfes
    public Shelf parseShelfes(String line) {
        String[] shelfes = line.split(",");

        String x = shelfes[0];
        String y = shelfes[1];
        String dir = shelfes[2];

        return new Shelf(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir));
    }

    // get the shelfes
    public ArrayList<Shelf> getShelfes() {
        return shelfes;
    }
}