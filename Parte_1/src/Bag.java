
/**
 * This class Bag is a children class of CentroDeDistribuicao and its a type of
 * packing that can be used to pack some type of product, this is where we will
 * see if we can add some type of product and add or remove them if possible
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class Bag extends CentroDeDistribuicao {

    // instance variables
    private Product product;
    private double bagWeight;

    /**
     * Construtor para objetos da classe Bag
     */
    public Bag() {
        // inicializate instance variables using the constructor of father class
        super('B');
        bagWeight = 0.0;
    }

    // get the actual bag weight
    public double getBagWeight() {
        return bagWeight;
    }

    // return the code of the bag
    public String getCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType()).append(getIdPacking());
        return sb.toString();
    }

    // add a product to the bag using the auxiliar method
    public void addProduct(Product product) {
        if (canBeAdded(product) == true) {
            this.product = product;
            bagWeight = product.getWeight();
        }
    }

    // remove a product from the bag
    public void removeProduct() {
        this.product = null;
        bagWeight = 0.0;
    }

    // auxiliar method to see if we can add the product to the bag
    public boolean canBeAdded(Product product) {
        if (product.getTypeOfProduct() == TypeOfProduct.SMALLTOYS
                || product.getTypeOfProduct() == TypeOfProduct.SMALLELETRONICS
                || product.getTypeOfProduct() == TypeOfProduct.ACCESSORIES
                || product.getTypeOfProduct() == TypeOfProduct.CLOTHINGS) {
            return true;
        }

        return false;
    }

}
