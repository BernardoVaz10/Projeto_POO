/**
 * This class Veiculo is an abstract class and father class of the 4 types of
 * vehicles and here we just put the general methods we will be using in the
 * children classes
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version June 2023
 */

public abstract class Vehicles extends Posicionaveis {
    // instance variables

    /**
     * Constructor for objects of class Vehicles
     */
    public Vehicles() {
        // initialise instance variables

    }

    /**
     * Method to change the direction of the vehicle
     * 
     * @param dir
     */
    public abstract void changeDirection(Directions dir);

    /**
     * Method to get the direction of the vehicle
     * 
     * @return dir
     */
    public abstract Directions getDirectionFacing();

    /**
     * Method to set the armazem of the vehicle
     * 
     * @param armazem
     */
    public abstract void setArmazem(Armazem armazem);

    /**
     * Method to set the speed of the vehicle
     * 
     * @param speed
     */
    public abstract void setSpeed(int speed);

    /**
     * Method to get the speed of the vehicle
     * 
     * @return speed
     */
    public abstract int getSpeed();

    /**
     * Method to move the vehicle to a specific coordenates
     * 
     * @param x
     * @param y
     * @param armazem
     */
    public abstract void moveTo(int x, int y, CentroDeDistribuicaoFX centroDeDistribuicaoFX);

    /**
     * Method to move the vehicle to a specific coordenates
     * 
     * @param x
     * @param y
     * @param armazem
     */
    public abstract void move(CentroDeDistribuicaoFX centroDeDistribuicaoFX);

    /**
     * Method to stop the vehicle
     */
    public abstract void stop();

    /**
     * Method to get the x coordenates of the vehicle
     * 
     * @return x
     */
    public abstract int getX();

    /**
     * Method to get the y coordenates of the vehicle
     * 
     * @return y
     */
    public abstract int getY();

    /**
     * Method to set the x coordenates of the vehicle
     * 
     * @param x
     */
    public abstract void setX(int x);

    /**
     * Method to set the y coordenates of the vehicle
     * 
     * @param y
     */
    public abstract void setY(int y);

    /**
     * Method to add a pack from the car to the shelf
     * 
     * @param pack
     */
    public abstract void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf);

    /**
     * Method to add a pack from the shelf to the car
     * 
     * @param pack
     */
    public abstract void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf);

    /**
     * Method to get the type of vehicle
     * 
     * @return typeOfVehicle
     */
    public abstract String getTypeOfVehicle();

    /**
     * Method to get the information of the vehicle
     * 
     * @return information
     */
    public abstract String getInformation();

    /**
     * Method to add a pack from the car to the venda
     * 
     * @param pack
     */
    public void addFromCarToVenda(CentroDeDistribuicao pack, Venda venda){};

    /**
     * Method to get the actual weight of the vehicle
     * 
     * @return actualWeight
     */
    public abstract double getActualWeight();

}
