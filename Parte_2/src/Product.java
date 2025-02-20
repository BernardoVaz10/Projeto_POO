/**
 * This class Product is where we create the products wich their variables
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class Product {
    // instance variables
    private String name;
    private static int nextId = 0;
    private final int idProduct;
    private double weight;
    private TypeOfProduct product;

    /**
     * Construtor para objetos da classe Product
     */
    public Product(String name, double weight, TypeOfProduct product) {
        // inicializate instance variables
        this.name = name;
        this.idProduct = nextId;
        nextId++;
        // check if weight is valid
        if (weight > 0.0) {
            this.weight = weight;
        }
        this.product = product.getTypeOfProduct(product);

    }

    /**
     * Method to get the type of product the product is
     * 
     * @return product.getTypeOfProduct(this.product)
     */
    public TypeOfProduct getTypeOfProduct() {
        return product.getTypeOfProduct(this.product);
    }

    /**
     * Method to get the name of the product
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the weight of the product
     * 
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method to get the id of the product
     * 
     * @return idProduct
     */
    public int getId() {
        return idProduct;
    }

}
