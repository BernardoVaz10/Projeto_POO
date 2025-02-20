
//imports
import java.util.ArrayList;

/**
 * This class AutomaticGuidedCar is a children class of Veiculo and this is
 * where we will control the car, such as the moving, directions and where we
 * will be
 * loading and unloading the content of the car and check if we can actually add
 * them to this type of car (if the pack type is compatible)
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class AutomaticGuidedCard extends Veiculo {

    // instances variables
    private final double MAX_WEIGHT = 100.0;
    private Directions dir;
    private int x;
    private int y;
    private ArrayList<CentroDeDistribuicao> al;
    private double actualWeight;
    private int speed;
    private Camera camera;
    private Ultrasonic ultrasonic;
    private Lidar lidar;
    private Armazem armazem;

    /**
     * Construtor para objetos da classe AutomaticGuidedCard
     */

    public AutomaticGuidedCard(int x, int y, Directions dir, Armazem armazem) {
        // Validating the posicions given
        if (x > 0 && x < MAX_X) {
            this.x = x;
        }
        if (y > 0 && y < MAX_Y) {
            this.y = y;
        }

        // inicializate instances and add vehicle to the arrayList vehicles on class
        // Posicionaveis
        this.dir = dir.getDirectionFacing(dir);
        al = new ArrayList<>();
        actualWeight = 0.0;
        veiculos.add(this);
        this.armazem = armazem;

        // inicializate sensors
        camera = new Camera();
        camera.setArmazem(armazem);
        camera.setPos(armazem.getPosicionaveis());
        ultrasonic = new Ultrasonic();
        ultrasonic.setArmazem(armazem);
        lidar = new Lidar();
        lidar.setArmazem(armazem);
    }

    // get the actual direction the vehicle is facing
    public Directions getDirectionFacing() {
        return this.dir;
    }

    // get on the string format the actual location of the vehicle
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(x).append(", ").append(y);
        return sb.toString();
    }

    // get the x coordenate of the vehicle
    public int getX() {
        return x;
    }

    // get the y coordenate of the vehicle
    public int getY() {
        return y;
    }

    // get the actual weight of the vehicle
    public double getActualWeight() {
        return actualWeight;
    }

    // auxiliar method to see if we can add the package to the car
    public boolean canAdd(CentroDeDistribuicao pack) {
        if (pack.getType() == 'B') {
            Bag bag = (Bag) pack;
            if (actualWeight + bag.getBagWeight() <= MAX_WEIGHT) {
                return true;
            }
        } else if (pack.getType() == 'X') {
            Box box = (Box) pack;
            if (actualWeight + box.getBoxWeight() <= MAX_WEIGHT) {
                return true;
            }
        }
        return false;
    }

    // method to add the package to the car
    public void add(CentroDeDistribuicao pack) {
        if (canAdd(pack)) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                actualWeight += bag.getBagWeight();
                al.add(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                actualWeight += box.getBoxWeight();
                al.add(box);
            }
        }
    }

    // method to remove the package to the car
    public void remove(CentroDeDistribuicao pack) {
        if (pack.getType() == 'B') {
            Bag bag = (Bag) pack;
            actualWeight -= bag.getBagWeight();
            al.remove(bag);
        } else if (pack.getType() == 'X') {
            Box box = (Box) pack;
            actualWeight -= box.getBoxWeight();
            al.remove(box);
        }
    }

    // return the type of vehicle
    public String getTypeOfVehicle() {
        return "AGV";
    }

    // method to move one posicion, that verified if the posicion given by moveTo
    // method are valid, check the posicion of the vehicle to move them one posicion
    // on the direction facing (using the getMap method to verified if is free) and
    // set free the posicion they leave on the map and
    // set busy on the posicion of the map they move
    public void move() {
        if (x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y) {
            if (dir == Directions.UP) {
                if (y < MAX_Y - 1) { // Verifica se y está dentro dos limites válidos
                    if (armazem.getMap()[x][y + 1] == 0 || armazem.getMap()[x][y + 1] == 1) {
                        armazem.setFree(this.getX(), this.getY());
                        y += this.speed;
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.RIGHT);
                    }
                }
            } else if (dir == Directions.DOWN) {
                if (y > 0) { // Verifica se y está dentro dos limites válidos
                    if (armazem.getMap()[x][y - 1] == 0 || armazem.getMap()[x][y - 1] == 1) {
                        armazem.setFree(this.getX(), this.getY());
                        y -= this.speed;
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.LEFT);
                    }
                }
            } else if (dir == Directions.RIGHT) {
                if (x < MAX_X - 1) { // Verifica se x está dentro dos limites válidos
                    if (armazem.getMap()[x + 1][y] == 0 || armazem.getMap()[x + 1][y] == 1) {
                        armazem.setFree(this.getX(), this.getY());
                        x += this.speed;
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.UP);
                    }
                }
            } else if (dir == Directions.LEFT) {
                if (x > 0) { // Verifica se x está dentro dos limites válidos
                    if (armazem.getMap()[x - 1][y] == 0 || armazem.getMap()[x - 1][y] == 1) {
                        armazem.setFree(this.getX(), this.getY());
                        x -= this.speed;
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.DOWN);
                    }
                }
            }

            // camera.checkObstacles(this);
            // ultrasonic.checkObstacles(this);
            // lidar.checkObstacles(this);
        }
    }

    // move to a specific location using the move method and change direction method
    // to help
    public void moveTo(int x, int y) {
        if (x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y) {
                while (this.x != x || this.y != y && this.x != x - 1 && this.y != y - 1) {
                    if (this.x < x) {
                        changeDirection(Directions.RIGHT);
                        while (this.x != x) {
                            move();
                            if (this.x == x - 1 || this.y == y - 1 ) {
                                break;
                            }
                        }
                    } else if (this.x > x) {
                        changeDirection(Directions.LEFT);
                        while (this.x != x) {
                            move();
                            if (this.x == x - 1 || this.y == y - 1) {
                                break;
                            }
                        }
                    }
                    if (this.y < y) {
                        changeDirection(Directions.UP);
                        while (this.y != y) {
                            System.out.println("x: " + this.x + " y: " + this.y);
                            move();
                            if (this.x == x - 1 || this.y == y - 1) {
                                break;
                            }
                        }
                    } else if (this.y > y) {
                        changeDirection(Directions.DOWN);
                        while (this.y != y) {
                            move();
                            if (this.x == x - 1 || this.y == y - 1) {
                                break;
                            }
                        }
                    }
                }
            }
    }

    // method to change the actual direction facing of the vehicle
    public void changeDirection(Directions dir) {
        this.dir = dir;
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
        return this.speed;
    }

    // get the packages inside the ArrayList (means inside the vehicle)
    public ArrayList<CentroDeDistribuicao> getBaggage() {
        return al;
    }

    // add from car to shelf checking the type of pack we are unloading
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                actualWeight -= bag.getBagWeight();
                al.remove(bag);
                shelf.addToShelf(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                actualWeight -= box.getBoxWeight();
                al.remove(box);
                shelf.addToShelf(box);
            }
        }
    }

    // add from shelf to car checking the type of pack we are loading to see if its
    // compatible
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            if (pack.getType() == 'B') {
                Bag bag = (Bag) pack;
                actualWeight += bag.getBagWeight();
                al.add(bag);
                System.out.println("Bag added to car");
                shelf.removeFromShelf(bag);
            } else if (pack.getType() == 'X') {
                Box box = (Box) pack;
                actualWeight += box.getBoxWeight();
                al.add(box);
                System.out.println("Box added to car");
                shelf.removeFromShelf(box);
            }
        }
    }

    // set the armazem
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }
}
