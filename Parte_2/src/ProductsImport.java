import java.util.ArrayList;
/**
 * This class ProductsImport, is the class that will read the file products.csv
 * and store the products in an arraylist
 *
 * @author Bernardo e Tiago
 * @version June 2023
 */
public class ProductsImport {
    public static final String FILEPATH = "files/products.csv";
    private ArrayList<Product> products;

    /**
     * Constructor for objects of class ProductsImport
     */
    public ProductsImport() {
        this.products = new ArrayList<>();
        readProducts();
    }

    /**
     * Method that reads the file products.csv
     */
    public void readProducts() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            products.add(parseProducts(line));
        }
    }

    /**
     * Method that parses the lines and creates the products
     * 
     * @param line
     * @return the product
     */
    public Product parseProducts(String line) {
        String[] products = line.split(",");

        String name = products[0];
        String weight = products[1];
        String typeOfProduct = products[2];

        return new Product(name, Double.parseDouble(weight), TypeOfProduct.valueOf(typeOfProduct));
    }

    /**
     * Method that returns the products
     * 
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
}
