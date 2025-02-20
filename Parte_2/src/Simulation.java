import java.util.ArrayList;

/**
 * This class Simulation is the class where we will be doing the simulation
 * and where we will be calling the methods from the other classes
 * to do the simulation
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version June 2023
 */
public class Simulation {
    private int count;
    private CentroDeDistribuicaoFX cd;
    private ProductsImport productsImport;
    private Local local;
    private Venda venda;
    private Armazenamento armazenamento;
    private Bag bag;
    private Box box;
    private Pallet pallet;
    private CardBox cardBox;
    private Product p, p2, p3, p4, p5, p6, p7, p8, p9, p10;

    /**
     * Constructor for objects of class Simulation
     */
    public Simulation(CentroDeDistribuicaoFX cd) {
        this.cd = cd;

        this.count = 1;

        local = new Local(cd.getArmazem());
        venda = new Venda(local, cd.getArmazem());
        armazenamento = new Armazenamento(local, cd.getArmazem());

        productsImport = new ProductsImport();

        p = productsImport.getProducts().get(0);
        p2 = productsImport.getProducts().get(1);
        p3 = productsImport.getProducts().get(2);
        p4 = productsImport.getProducts().get(3);
        p5 = productsImport.getProducts().get(4);
        p6 = productsImport.getProducts().get(5);
        p7 = productsImport.getProducts().get(6);
        p8 = productsImport.getProducts().get(7);
        p9 = productsImport.getProducts().get(8);
        p10 = productsImport.getProducts().get(9);

        bag = new Bag();
        bag.addProduct(p);
        bag.addProduct(p2);
        bag.addProduct(p3);
        bag.addProduct(p4);

        box = new Box();
        box.addProduct(p5);
        box.addProduct(p6);
        box.addProduct(p7);
        box.addProduct(p8);

        cardBox = new CardBox(true);
        cardBox.addSmall(p9);
        cardBox.addBig(p10);

        pallet = new Pallet();
        pallet.addCardBox(cardBox);

        // add bag to shelf
        cd.getShelfes().get(0).addToShelf(bag);
        cd.getShelfes().get(1).addToShelf(box);
        cd.getShelfes().get(2).addToShelf(cardBox);
        cd.getShelfes().get(3).addToShelf(pallet);
    }

    /**
     * Method to do the simulation of the AutomaticCar
     * 
     * @param vehicles
     * @param index
     */
    public void stepAVG(ArrayList<Vehicles> vehicles, int index) {
        if (count == 1) {
            // if is AutomaticCar
            if (vehicles.get(index) instanceof AutomaticGuidedCar)
                vehicles.get(index).moveTo(5, 19, cd);
            else if (vehicles.get(index) instanceof UnitLoadCarrier)
                vehicles.get(index).moveTo(3, 30, cd);
        }

        if (count == 2) {
            if (vehicles.get(index) instanceof AutomaticGuidedCar)
                vehicles.get(index).addFromShelfToCar(bag, cd.getShelfes().get(0));
            else if (vehicles.get(index) instanceof UnitLoadCarrier)
                vehicles.get(index).addFromShelfToCar(pallet, cd.getShelfes().get(3));
        }

        if (count == 3) {
            if (vehicles.get(index) instanceof AutomaticGuidedCar)
                vehicles.get(index).moveTo(20, 35, cd);
            else if (vehicles.get(index) instanceof UnitLoadCarrier)
                vehicles.get(index).moveTo(21, 35, cd);
        }

        if (count == 4){
            if (vehicles.get(index) instanceof AutomaticGuidedCar)
                vehicles.get(index).addFromCarToVenda(bag, venda);
            else if (vehicles.get(index) instanceof UnitLoadCarrier)
                vehicles.get(index).addFromCarToVenda(pallet, venda);


            count = 0;
        }

        count++;
    }
}
