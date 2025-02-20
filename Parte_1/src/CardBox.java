//imports
import java.util.ArrayList;

/**
 * This class CardBox is a children class of CentroDeDistribuicao and its a type
 * of packing that can be used to pack some type of product, this is where we
 * will see if we can add some type of product and add or remove them if possible
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */

public class CardBox extends CentroDeDistribuicao {
    // instance variables
    private ArrayList<Product> p;
    private static final int MAX_PRODUCTS = 10;
    private double cardBoxWeight;
    private boolean isBigStored;

    /**
     * Construtor para objetos da classe CardBox
     */
    public CardBox(boolean isBigStored) {
        // inicializate instance variables using the constructor of father class and
        // receive the indication if we want to store 1 big product or 10 small product
        super('C');
        p = new ArrayList<>();
        cardBoxWeight = 0.0;
        this.isBigStored = isBigStored;

    }

    // get the actual cardbox weight
    public double getCardBoxWeight() {
        for (Product product : p) {
            cardBoxWeight = +product.getWeight();
        }
        return cardBoxWeight;
    }

    // return the code of the cardbox
    public String getCode() {

        StringBuilder sb = new StringBuilder();
        sb.append(getType()).append(getIdPacking());
        return sb.toString();
    }

    // add a small product to the cardbox using the auxiliar method
    public void addSmall(Product product) {
        if (p.size() < MAX_PRODUCTS) {
            if (canAddSmall(product)) {
                p.add(product);
            }
        }
    }

    // add a big product to the cardbox using the auxiliar method
    public void addBig(Product product) {
        if (p.isEmpty()) {
            if (canAddBig(product)) {
                p.add(product);
            }
        }
    }

    // remove a small product from the cardbox
    public void removeSmall(Product product) {
        if (isBigStored == false) {
            for (Product prod : p) {
                if (prod.equals(product)) {
                    p.remove(product);
                }
            }
        }
    }

    // remove a big product from the cardbox
    public void removeBig(Product product) {
        if (isBigStored == true) {
            p.remove(product);
        }
    }

    // auxiliar method to see if we can add the small product to the cardbox
    public boolean canAddSmall(Product product) {
        if (isBigStored == false) {
            if (product.getTypeOfProduct() != TypeOfProduct.BIGELETRONICS
                    || product.getTypeOfProduct() != TypeOfProduct.BIGTOYS) {
                return true;
            }
        }
        return false;
    }

    // auxiliar method to see if we can add the big product to the cardbox
    public boolean canAddBig(Product product) {
        if (isBigStored == true) {
            if (product.getTypeOfProduct() == TypeOfProduct.BIGELETRONICS
                    || product.getTypeOfProduct() == TypeOfProduct.BIGTOYS) {
                return true;
            }
        }
        return false;
    }
}
