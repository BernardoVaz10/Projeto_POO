
import java.util.ArrayList;

/**
 * This class AutomaticGuidedCar is a children class of Veiculo and this is
 * where we will control the car, such as the moving, directions and where we
 * will be loading and unloading the content of the car and check if we can
 * actually add
 * them to this type of car (if the pack type is compatible)
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class TransportCar extends Veiculo {

    // instances variables
    private double transportWeight;
    private final double MAX_WEIGHT = 200.0;
    private Directions dir;
    private int x;
    private int y;
    private ArrayList<CentroDeDistribuicao> al;
    private int speed;
    private Armazem armazem;

    /**
     * Construtor para objetos da classe TransportCar
     */
    public TransportCar(int x, int y, Directions dir) {
        // Validating the posicions given
        if (x > 0 && x < MAX_X) {
            this.x = x;
        }
        if (y > 0 && y < MAX_Y) {
            this.y = y;
        }
        // inicializate instances and add vehicle to the arrayList vehicles on class
        // Posicionaveis
        al = new ArrayList<>();
        veiculos.add(this);
        transportWeight = 0.0;
        this.dir = dir.getDirectionFacing(dir);
    }

    // get the actual direction the vehicle is facing
    public Directions getDirectionFacing() {
        return dir;
    }

    // get on the string format the actual location of the vehicle
    public String getPosicion(int x, int y) {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(x).append(", ").append(y);
        return sb.toString();
    }

    // get the x
    public int getX() {
        return x;
    }

    // get the y
    public int getY() {
        return y;
    }

    // auxiliar method to see if we can add the package to the car
    public boolean canAdd(CentroDeDistribuicao pack) {
        if (pack.getType() == 'B') {
            Bag bag = (Bag) pack;
            if (transportWeight + bag.getBagWeight() <= MAX_WEIGHT) {
                return true;
            }
        } else if (pack.getType() == 'X') {
            Box box = (Box) pack;
            if (transportWeight + box.getBoxWeight() <= MAX_WEIGHT) {
                return true;
            }
        }
        return false;
    }

    // method to add the package to the car
    public void add(CentroDeDistribuicao pack) {
        if (canAdd(pack) == true) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                transportWeight += bag.getBagWeight();
                al.add(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                transportWeight += box.getBoxWeight();
                al.add(box);
            }
        }
    }

    // method to remove the package from the car
    public void remove(CentroDeDistribuicao pack) {
        if (al.contains(pack)) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                transportWeight -= bag.getBagWeight();
                al.remove(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                transportWeight -= box.getBoxWeight();
                al.remove(box);
            }
        }
    }

    // get the actual weight of the load in the car
    public double getActualWeight() {
        return transportWeight;
    }

    // return the type of vehicle
    public String getTypeOfVehicle() {
        return "TransportCar";
    }

    // get on the string format the actual location of the vehicle
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(this.x).append(", ").append(this.y);
        return sb.toString();
    }

    // method to stop the vehicle
    public void stop() {
        this.speed = 0;
    }

    // set speed of vehicle (this vehicle cant change speed so its always 1)
    public void setSpeed(int speed) {
        this.speed = 1;
    }

    // get actual speed
    public int getSpeed() {
        return speed;
    }

    // method to move one posicion, that verified if the posicion given by moveTo
    // method are valid, check the posicion of the vehicle to move them one posicion
    // on the direction facing (using the getMap method to verified if is free) and
    // set free the posicion they leave on the map and
    // set busy on the posicion of the map they move
    public void move() {
        if (dir == Directions.UP) {
            if (y < MAX_Y) {
                if (armazem.getMap()[x][y + 1] == 0) {
                    armazem.setFree(this.getX(), this.getY());
                    y += this.speed;
                    armazem.setBusy(this.getX(), this.getY());
                }
            }
        } else if (dir == Directions.DOWN) {
            if (y > 0) {
                if (armazem.getMap()[x][y - 1] == 0) {
                    armazem.setFree(this.getX(), this.getY());
                    y -= this.speed;
                    armazem.setBusy(this.getX(), this.getY());
                }
            }
        } else if (dir == Directions.RIGHT) {
            if (x < MAX_X) {
                if (armazem.getMap()[x + 1][y] == 0) {
                    armazem.setFree(this.getX(), this.getY());
                    x += this.speed;
                    armazem.setBusy(this.getX(), this.getY());
                }
            }
        } else if (dir == Directions.LEFT) {
            if (x > 0) {
                if (armazem.getMap()[x - 1][y] == 0) {
                    armazem.setFree(this.getX(), this.getY());
                    x -= this.speed;
                    armazem.setBusy(this.getX(), this.getY());
                }
            }
        }
    }

    // move to a specific location using the move method and change direction method
    // to help
    public void moveTo(int x, int y) {
        if (this.x < x) {
            while (this.x != x) {
                move();
            }
        } else if (this.x > x) {
            while (this.x != x) {
                move();
            }
        } else if (this.y < y) {
            while (this.y != y) {
                move();
            }
        } else if (this.y > y) {
            while (this.y != y) {
                move();
            }
        }
    }

    // changeDirection(Directions dir)
    public void changeDirection(Directions dir) {
        this.dir = dir;
    }

    // give al to Shelf
    public ArrayList<CentroDeDistribuicao> getBaggage() {
        return al;
    }

    // add from car to shelf
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                transportWeight -= bag.getBagWeight();
                al.remove(bag);
                shelf.addToShelf(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                transportWeight -= box.getBoxWeight();
                al.remove(box);
                shelf.addToShelf(box);
            }
        }
    }

    // add from shelf to car
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                transportWeight += bag.getBagWeight();
                al.add(bag);
                shelf.removeFromShelf(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                transportWeight += box.getBoxWeight();
                al.add(box);
                shelf.removeFromShelf(box);
            }
        }
    }

    // set the armazem
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }
}
