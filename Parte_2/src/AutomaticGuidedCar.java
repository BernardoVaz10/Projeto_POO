
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
public class AutomaticGuidedCar extends Vehicles {

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
     * 
     * @param x
     * @param y
     * @param dir
     * @param armazem
     */
    public AutomaticGuidedCar(int x, int y, Directions dir, Armazem armazem) {
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

    /**
     * Method to get the direction of the vehicle
     * 
     * @return dir
     */
    public Directions getDirectionFacing() {
        return this.dir;
    }

    /**
     * Method to get the location of the vehicle
     * 
     * @return sb.toString()
     */
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(x).append(", ").append(y);
        return sb.toString();
    }

    /**
     * Method to get the information of the vehicle
     * 
     * @return sb.toString()
     */
    public String getInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLocation()).append(", Direção: ").append(getDirectionFacing())
                .append(", Peso da carga: ").append(getActualWeight()).append(", Velocidade: ").append(getSpeed());
        return sb.toString();
    }

    /**
     * Method to get the x coordenate of the vehicle
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Method to get the y coordenate of the vehicle
     * 
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Method to get the actual weight of the vehicle
     * 
     * @return actualWeight
     */
    public double getActualWeight() {
        return actualWeight;
    }

    /**
     * Method to check if we can add the package to the car, checking the type of
     * pack and the actual weight of the car
     * 
     * @param pack
     * @return true/false
     */
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

    /**
     * Method to add the package to the car, checking the type of pack and the
     * actual weight of the car
     * 
     * @param pack
     */
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

    /**
     * Method to remove the package from the car, checking the type of pack and the
     * actual weight of the car
     * 
     * @param pack
     */
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

    /**
     * Method to get the type of vehicle
     * 
     * @return "AGV"
     */
    public String getTypeOfVehicle() {
        return "AGV";
    }

    /**
     * Method to move the vehicle, checking the direction and the actual position of
     * the vehicle
     * 
     * @param centroDeDistribuicaoFX
     */
    public void move(CentroDeDistribuicaoFX centroDeDistribuicaoFX) {
        if (x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y) {
            if (dir == Directions.UP) {
                if (y < MAX_Y - 1) { // Verifica se y está dentro dos limites válidos
                    if (armazem.getMap()[x][y + 1] == 0 || armazem.getMap()[x][y + 1] == 1) {
                        // System.out.println("x: " + this.x + " y: " + this.y);
                        armazem.setFree(this.getX(), this.getY());
                        y += this.speed;
                        // show the car image in the new position
                        centroDeDistribuicaoFX.showElements(MAX_Y, MAX_X, centroDeDistribuicaoFX.getGridPane());
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.RIGHT);
                    }
                }
            } else if (dir == Directions.DOWN) {
                if (y > 0) { // Verifica se y está dentro dos limites válidos
                    if (armazem.getMap()[x][y - 1] == 0 || armazem.getMap()[x][y - 1] == 1) {
                        // System.out.println("x: " + this.x + " y: " + this.y);
                        armazem.setFree(this.getX(), this.getY());
                        y -= this.speed;
                        centroDeDistribuicaoFX.showElements(MAX_Y, MAX_X, centroDeDistribuicaoFX.getGridPane());
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.LEFT);
                    }
                }
            } else if (dir == Directions.RIGHT) {
                if (x < MAX_X - 1) { // Verifica se x está dentro dos limites válidos
                    if (armazem.getMap()[x + 1][y] == 0 || armazem.getMap()[x + 1][y] == 1) {
                        // System.out.println("x: " + this.x + " y: " + this.y);
                        armazem.setFree(this.getX(), this.getY());
                        x += this.speed;
                        centroDeDistribuicaoFX.showElements(MAX_Y, MAX_X, centroDeDistribuicaoFX.getGridPane());
                        armazem.setBusy(this.getX(), this.getY());
                    } else {
                        changeDirection(Directions.UP);
                    }
                }
            } else if (dir == Directions.LEFT) {
                if (x > 0) { // Verifica se x está dentro dos limites válidos
                    if (armazem.getMap()[x - 1][y] == 0 || armazem.getMap()[x - 1][y] == 1) {
                        // System.out.println("x: " + this.x + " y: " + this.y);
                        armazem.setFree(this.getX(), this.getY());
                        x -= this.speed;
                        centroDeDistribuicaoFX.showElements(MAX_Y, MAX_X, centroDeDistribuicaoFX.getGridPane());
                        // System.out.println("x: " + this.x + " y: " + this.y);
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

    /**
     * Method to move the vehicle to a specific coordenates
     * 
     * @param x
     * @param y
     * @param armazem
     */
    public void moveTo(int x, int y, CentroDeDistribuicaoFX centroDeDistribuicaoFX) {
        if (x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y) {
            while (this.x != x || this.y != y && this.x != x - 1 && this.y != y - 1) {
                if (this.x < x) {
                    changeDirection(Directions.RIGHT);
                    while (this.x != x) {
                        move(centroDeDistribuicaoFX);
                        if (this.x == x - 1 || this.y == y - 1) {
                            break;
                        }
                    }
                } else if (this.x > x) {
                    changeDirection(Directions.LEFT);
                    while (this.x != x) {
                        move(centroDeDistribuicaoFX);
                        if (this.x == x - 1 || this.y == y - 1) {
                            break;
                        }
                    }
                }
                if (this.y < y) {
                    changeDirection(Directions.UP);
                    while (this.y != y) {
                        System.out.println("x: " + this.x + " y: " + this.y);
                        move(centroDeDistribuicaoFX);
                        if (this.x == x - 1 || this.y == y - 1) {
                            break;
                        }
                    }
                } else if (this.y > y) {
                    changeDirection(Directions.DOWN);
                    while (this.y != y) {
                        move(centroDeDistribuicaoFX);
                        if (this.x == x - 1 || this.y == y - 1) {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Method to change the direction of the vehicle
     * 
     * @param dir
     */
    public void changeDirection(Directions dir) {
        this.dir = dir;
    }

    /**
     * Method to stop the vehicle
     */
    public void stop() {
        this.speed = 0;
    }

    /**
     * Method to set the speed of the vehicle
     * 
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = 1;
    }

    /**
     * Method to get the speed of the vehicle
     * 
     * @return speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Method to get the arraylist of the vehicle
     * 
     * @return al
     */
    public ArrayList<CentroDeDistribuicao> getBaggage() {
        return al;
    }

    /**
     * Method to add the package to the car, checking the type of pack and the
     * actual weight of the car
     * 
     * @param pack
     * @param shelf
     */
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        // if (shelf.isOpositeDir(this)) {
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
        // }
    }

    /**
     * Method to add the package to the car, checking the type of pack and the
     * actual weight of the car
     * 
     * @param pack
     * @param shelf
     */
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        // if (shelf.isOpositeDir(this)) {
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
        // }
    }

    /**
     * Method to add the package to the car, checking the type of pack and the
     * actual weight of the car
     * 
     * @param pack
     * @param venda
     */
    @Override
    public void addFromCarToVenda(CentroDeDistribuicao pack, Venda venda) {
        if (pack.getType() == 'B') {
            Bag bag = (Bag) pack;
            actualWeight -= bag.getBagWeight();
            al.remove(bag);
            venda.receivePackages(pack);
        } else if (pack.getType() == 'X') {
            Box box = (Box) pack;
            actualWeight -= box.getBoxWeight();
            al.remove(box);
            venda.receivePackages(pack);
            ;
        }
    }

    /**
     * Method to set the armazem
     * 
     * @param armazem
     */
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    /**
     * Method to set the x coordenate
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method to set the y coordenate
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

}