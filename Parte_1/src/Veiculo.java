/**
 * This class Veiculo is an abstract class and father class of the 4 types of
 * vehicles and here we just put the general methods we will be using in the
 * children classes
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou data aqui)
 */

public abstract class Veiculo extends Posicionaveis {

    // Constructor
    public Veiculo() {
    }

    // Methods
    public abstract void changeDirection(Directions dir);

    public abstract Directions getDirectionFacing();

    public abstract void setArmazem(Armazem armazem);

    public abstract void setSpeed(int speed);

    public abstract int getSpeed();

    public abstract void moveTo(int x, int y);

    public abstract void move();

    public abstract void stop();

    public abstract int getX();

    public abstract int getY();

    public abstract void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf);

    public abstract void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf);

}
