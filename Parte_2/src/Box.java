/**
 * This class Box is a children class of CentroDeDistribuicao and its a type of
 * packing that can be used to pack some type of product, this is where we will
 * see if we can add some type of product and add or remove them if possible
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class Box extends CentroDeDistribuicao {
    
    // instance variables
    private Product product;
    private double boxWeight;

    /**
     * Construtor para objetos da classe Box
     */
    public Box() {
         // inicializate instance variables using the constructor of father class
        super('X');
        boxWeight = 0.0;
    }

    /**
     * Method to get the actual box weight
     * 
     * @return boxWeight
     */
    public double getBoxWeight() {
        return boxWeight;
    }

    /**
     * Method to get the code of the box
     * 
     * @return sb.toString()
     */
    public String getCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType()).append(getIdPacking());
        return sb.toString();
    }

    /**
     * Method to add a product to the box using the auxiliar method
     * 
     * @param product
     */
    public void addProduct(Product product) {
        if (canBeAdded(product) == true) {
            this.product = product;
            boxWeight = product.getWeight();
        }
    }

    /**
     * Method to remove a product from the box
     */
    public void removeProduct() {
        this.product = null;
        boxWeight = 0.0;
    }

    /**
     * Method to check if the product can be added to the box
     * 
     * @param product
     * @return true or false
     */
    public boolean canBeAdded(Product product) {
        if (product.getTypeOfProduct() == TypeOfProduct.SMALLTOYS
                || product.getTypeOfProduct() == TypeOfProduct.SMALLELETRONICS
                || product.getTypeOfProduct() == TypeOfProduct.ACCESSORIES
                || product.getTypeOfProduct() == TypeOfProduct.BOOKS) {
            return true;
        }

        return false;
    }
}