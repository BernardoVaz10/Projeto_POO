
import java.util.ArrayList;
// import class Veiculo.java

public class VeiculosImport {
    private static final String FILEPATH = "files/vehiculos.csv";
    private ArrayList<Vehicles> veiculos;
    private static Armazem armazem;

    /**
     * Constructor for objects of class VeiculosImport
     * 
     * @param armazem
     */
    public VeiculosImport(Armazem armazem) {
        this.veiculos = new ArrayList<>();
        this.armazem = armazem;
        readVeiculos();
    }

    /**
     * Method that reads the file vehiculos.csv
     */
    public void readVeiculos() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            veiculos.add(parseVeiculo(line));
        }
    }

    /**
     * Method that parses the lines and creates the veiculos
     * 
     * @param line
     * @return the veiculos
     */
    public static Vehicles parseVeiculo(String line) {
        String[] veiculo = line.split(",");

        String type = veiculo[0];
        String x = veiculo[1];
        String y = veiculo[2];
        String dir = veiculo[3];

        // if the type is a car
        if (type.equals("TransportCar")) {
            return new TransportCar(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir), armazem);
        }
        // if the type is a trailer
        else if (type.equals("Trailer")) {
            return new Trailer(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir), armazem);
        }
        // if the type is a agv
        else if (type.equals("AutomaticGuidedCar")) {
            return new AutomaticGuidedCar(Integer.parseInt(x), Integer.parseInt(x), Directions.valueOf(dir), armazem);
        }
        // if the type is a ulc
        else if (type.equals("UnitLoadCarrier")) {
            return new UnitLoadCarrier(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir), armazem);
        }

        return null;
    }

    /**
     * Method that returns the veiculos
     * 
     * @return the veiculos
     */
    public ArrayList<Vehicles> getVeiculos() {
        return veiculos;
    }

    /**
     * Method that returns the number of veiculos
     * 
     * @return the number of veiculos
     */
    public int getNumberOfVeiculos() {
        return veiculos.size();
    }
}
