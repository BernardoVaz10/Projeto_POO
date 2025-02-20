
import java.util.ArrayList;

/**
 * This class Venda, is the children class of Local and is the class
 * that will send the packages to the outside occupying 50% from the Right
 * wall.
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */
public class Venda extends Local {
    // instance variables
    Local local;
    private ArrayList<CentroDeDistribuicao> packages;
    private ArrayList<Product> products;

    /**
     * Constructor for objects of class Venda
     */
    public Venda(Local local, Armazem armazem) {
        // initialise instance variables
        super(armazem);
        local.createVenda();
        packages = new ArrayList<CentroDeDistribuicao>();
        products = new ArrayList<Product>();
    }

    // send products to the outside
    public void sellProduct(Product p) {
        products.remove(p);
    }

    // send packages to the outside
    public void sellPack(CentroDeDistribuicao pack) {
        packages.remove(pack);
    }

    // Receive packages from the (NÃO SEI)
    public void receivePackages(CentroDeDistribuicao pack) {
        packages.add(pack);
    }

    // Receive products from the (NÃO SEI)
    public void receiveProduct(Product p) {
        products.add(p);
    }

    // print products that are in this local
    public void printProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // print packages that are in this local
    public void printPackages() {
        for (CentroDeDistribuicao pack : packages) {
            System.out.println(pack);
        }
    }
}
