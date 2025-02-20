/**
 * This class CentroDeDistribuicao is the father class of Bag, Box, CardBox and
 * Pallet and this is where give the codes to the each one of the type of
 * packings we create
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */
public class CentroDeDistribuicao {
    // instance variables
    private static int nextId = 0;
    private final int idPacking;
    private char type;

    /**
     * Constructor for objects of class CentroDeDistribuicao
     */
    public CentroDeDistribuicao(char type) {
        // inicializate instance variables
        idPacking = nextId;
        nextId++;
        this.type = type;
    }

    /**
     * Method to get the type of the packing
     * 
     * @return type
     */
    public char getType() {
        return type;
    }

    /**
     * Method to get the id of the packing
     * 
     * @return idPacking
     */
    public int getIdPacking() {
        return idPacking;
    }

    /**
     * Method to get the code of the packing
     * 
     * @return sb.toString()
     */
    public String getCode() {

        StringBuilder sb = new StringBuilder();
        sb.append(getType()).append(getIdPacking());
        return sb.toString();
    }
}