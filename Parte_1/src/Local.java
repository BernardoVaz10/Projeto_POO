/**
 * This class Local is the father class of Armazenamento and Venda that are two
 * locals to collect packages from the outside and deliver packages to the
 * outside, using this father class we can call each of the methods to create
 * and eliminate each local
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */
public class Local extends Posicionaveis {
    // instance variables
    Armazem armazem;

    /**
     * Constructor for objects of class Local
     */
    public Local(Armazem armazem) {
        // initialise instance variables
        this.armazem = armazem;
    }

    // method used by children class Armazenamento to create the area
    public void createArmazenamento() {
        for (int j = 0; j < 18; j++) {
            armazem.setBusy(0, j);
        }
    }

    // method used by children class Armazenamento to eliminate the area
    public void deleteArmazenamento() {
        for (int j = 0; j < 18; j++) {
            armazem.setFree(0, j);
        }
    }

    // method used by children class Venda to create the area
    public void createVenda() {
        for (int j = 0; j < 18; j++) {
            armazem.setBusy(35, j);
        }
    }

    // method used by children class Venda to eliminate the area
    public void deleteVenda() {
        for (int j = 0; j < 18; j++) {
            armazem.setFree(35, j);
        }
    }
}
