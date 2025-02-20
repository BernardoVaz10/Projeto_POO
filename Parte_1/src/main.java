
/**
 * This class main is where we will simulate the program, such as creating
 * vehicles, products, packages, locals, trying to simulate the features to see
 * what is good and wrong
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */
public class main {
    /**
     * Constructor for objects of class main
     */
    public main() {

    }

    public static void main(String[] args) {
        // define the armazem
        // Armazem armazem = new Armazem("Armazem POO", 36, 36);
        ArmazemImport armazemImport = new ArmazemImport();
        Armazem armazem = armazemImport.getArmazem().get(0);

        // print the map to see changes
        // armazem.printMap();

        // define the locals
        Local local = new Local(armazem);
        Local armazenamento = new Armazenamento(local, armazem);
        Local venda = new Venda(local, armazem);

        // define the vehicles and load them in the armazem
        /*
         * Veiculo v = new Trailer(5, 5, Directions.UP);
         * v.setArmazem(armazem);
         * armazem.loadVehicle(v);
         * Veiculo v2 = new TransportCar(10, 10, Directions.UP);
         * v2.setArmazem(armazem);
         * armazem.loadVehicle(v2);
         * Veiculo v3 = new AutomaticGuidedCard(15, 15, Directions.UP, armazem);
         * armazem.loadVehicle(v3);
         * Veiculo v4 = new UnitLoadCarrier(20, 20, Directions.UP);
         * v4.setArmazem(armazem);
         * armazem.loadVehicle(v4);
         */

        VeiculosImport veiculosImport = new VeiculosImport(armazem);
        for (Veiculo v : veiculosImport.getVeiculos()) {
            if (v == null) {
                continue;
            }
            v.setArmazem(armazem);
            armazem.loadVehicle(v);
        }
        Veiculo v = veiculosImport.getVeiculos().get(0);
        Veiculo v2 = veiculosImport.getVeiculos().get(1);
        Veiculo v3 = veiculosImport.getVeiculos().get(2);
        // Veiculo v4 = veiculosImport.getVeiculos().get(3);

        // define the shelfes and load them in the armazem
        /*
         * Shelf s = new Shelf(3, 18, Directions.RIGHT);
         * armazem.storeShelf(s);
         * Shelf s2 = new Shelf(4, 22, Directions.LEFT);
         * armazem.storeShelf(s2);
         * Shelf s3 = new Shelf(4, 26, Directions.RIGHT);
         * armazem.storeShelf(s3);
         * Shelf s4 = new Shelf(3, 30, Directions.UP);
         * armazem.storeShelf(s4);
         */

        ShelfesImport shelfesImport = new ShelfesImport();
        for (Shelf s : shelfesImport.getShelfes()) {
            armazem.storeShelf(s);
        }
        Shelf s = shelfesImport.getShelfes().get(0);
        Shelf s2 = shelfesImport.getShelfes().get(1);
        Shelf s3 = shelfesImport.getShelfes().get(2);
        Shelf s4 = shelfesImport.getShelfes().get(3);

        // print the map to see changes
        // armazem.printMap();

        // Create products and packages, store the products in the packages
        /*
         * Product p = new Product("Product 1", 8.2, TypeOfProduct.BOOKS);
         * Product p2 = new Product("Product 2", 11.1, TypeOfProduct.CLOTHINGS);
         * Product p3 = new Product("Product 3", 7.9, TypeOfProduct.BOOKS);
         * Product p4 = new Product("Product 4", 53.2, TypeOfProduct.ACCESSORIES);
         * Product p5 = new Product("Product 5", 44.5, TypeOfProduct.BIGELETRONICS);
         * Product p6 = new Product("Product 6", 25.6, TypeOfProduct.BIGTOYS);
         * Product p7 = new Product("Product 7", 6.7, TypeOfProduct.CLOTHINGS);
         * Product p8 = new Product("Product 8", 7.8, TypeOfProduct.SMALLELETRONICS);
         * Product p9 = new Product("Product 9", 18.9, TypeOfProduct.SMALLTOYS);
         * Product p10 = new Product("Product 10", 39.0, TypeOfProduct.BIGTOYS);
         */

        ProductsImport productsImport = new ProductsImport();

        Product p = productsImport.getProducts().get(0);
        Product p2 = productsImport.getProducts().get(1);
        Product p3 = productsImport.getProducts().get(2);
        Product p4 = productsImport.getProducts().get(3);
        Product p5 = productsImport.getProducts().get(4);
        Product p6 = productsImport.getProducts().get(5);
        Product p7 = productsImport.getProducts().get(6);
        Product p8 = productsImport.getProducts().get(7);
        Product p9 = productsImport.getProducts().get(8);
        Product p10 = productsImport.getProducts().get(9);

        Bag bag = new Bag();
        bag.addProduct(p);
        bag.addProduct(p2);
        bag.addProduct(p3);
        bag.addProduct(p4);

        Box box = new Box();
        box.addProduct(p5);
        box.addProduct(p6);
        box.addProduct(p7);
        box.addProduct(p8);

        CardBox cardBox = new CardBox(true);
        cardBox.addSmall(p9);
        cardBox.addBig(p10);

        // add bag to shelf
        s.addToShelf(bag);

        // set speed of vehicle and move them to coordenates (3, 18) to try to store
        // their load into the car wich the product in the shelf
        v.setSpeed(1);
        System.out.println("Vehicle v speed: " + v.getSpeed());
        v.moveTo(3, 18);
        System.out.println("Vehicle v coordenates: " + v.getX() + ", " + v.getY());
        v.addFromShelfToCar(bag, s);

        // move the vehicle v3 to local Venda and unload their product to the shelf of
        // venda
        System.out.println("Before");
        v.changeDirection(Directions.RIGHT);
        v.moveTo(3, 30);
        System.out.println("Vehicle v coordenates: " + v.getX() + ", " + v.getY());
        // v.addFromCarToShelf(bag, s4);

        // print the map to see changes
        armazem.printMap();
    }
}
