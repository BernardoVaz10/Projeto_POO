import java.util.ArrayList;

/**
 * This class Armazenamento, is the children class of Local and is the class
 * that will receive the packages from the outside occupying 50% from the Left
 * wall.
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */

public class Armazenamento extends Local {

    // instance variables
    Local local;
    private ArrayList<CentroDeDistribuicao> packages;

    /**
     * Constructor for objects of class Armazenamento
     */

    public Armazenamento(Local local, Armazem armazem) {
        // inicializate ArrayList and call the method in class father to create the area
        super(armazem);
        local.createArmazenamento();
        packages = new ArrayList<CentroDeDistribuicao>();
    }

    // Receive packages from the outside
    public void receivePackages(CentroDeDistribuicao pack) {
        packages.add(pack);
    }

    // Send packages to the inside
    public CentroDeDistribuicao sentPackages(CentroDeDistribuicao pack) {
        packages.remove(pack);
        return pack;
    }
}
