import java.util.ArrayList;

public class ProductsImport {
    public static final String FILEPATH = "projPOO/files/products.csv";
    private ArrayList<Product> products;

    public ProductsImport() {
        this.products = new ArrayList<>();
        readProducts();
    }

    // read the file and store the lines in the arraylist
    public void readProducts() {
        ArrayList<String> lines = FileInputReader.readCsv(FILEPATH);

        for (String line : lines) {
            products.add(parseProducts(line));
        }
    }

    // parse the lines and create the shelfes
    public Product parseProducts(String line) {
        String[] products = line.split(",");

        String name = products[0];
        String weight = products[1];
        String typeOfProduct = products[2];

        return new Product(name, Double.parseDouble(weight), TypeOfProduct.valueOf(typeOfProduct));
    }

    // get the shelfes
    public ArrayList<Product> getProducts() {
        return products;
    }
}
