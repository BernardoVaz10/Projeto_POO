
import java.util.ArrayList;
// import class Veiculo.java

public class VeiculosImport {
    private static final String FILEPATH = "projPOO/files/vehiculos.csv";
    private ArrayList<Veiculo> veiculos;
    private static Armazem armazem;

    public VeiculosImport(Armazem armazem) {
        this.veiculos = new ArrayList<>();
        this.armazem = armazem;
        readVeiculos();
    }

    // read the file and store the lines in the arraylist
    public void readVeiculos() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            veiculos.add(parseVeiculo(line));
        }
    }

    // parse veiculos to the correct type
    public static Veiculo parseVeiculo(String line) {
        String[] veiculo = line.split(",");

        String type = veiculo[0];
        String x = veiculo[1];
        String y = veiculo[2];
        String dir = veiculo[3];

        // if the type is a car
        if (type.equals("TransportCar")) {
            return new TransportCar(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir));
        }
        // if the type is a trailer
        else if (type.equals("Trailer")) {
            return new Trailer(Integer.parseInt(x), Integer.parseInt(y), Directions.valueOf(dir));
        }
        // if the type is a agv
        else if (type.equals("AutomaticGuidedCar")) {
            return new AutomaticGuidedCard(Integer.parseInt(x), Integer.parseInt(x), Directions.valueOf(dir), armazem);
        }

        return null;
    }

    // get the veiculos
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    // get the number of veiculos
    public int getNumberOfVeiculos() {
        return veiculos.size();
    }
}
