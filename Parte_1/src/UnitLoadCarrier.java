
/**
 * This class UnitLoadCarrier is a children class of Veiculo and this is
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
public class UnitLoadCarrier extends Veiculo {

    // instances variables
    private int x;
    private int y;
    private Directions dir;
    private Pallet pallet;
    private int speed;
    private Camera camera;
    private Ultrasonic ultrasonic;
    private Lidar lidar;
    private Armazem armazem;

    /**
     * Construtor para objetos da classe UnitLoadCarrier
     */
    public UnitLoadCarrier(int x, int y, Directions dir) {
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
        veiculos.add(this);
        camera = new Camera();
        ultrasonic = new Ultrasonic();
        lidar = new Lidar();
    }

    // add a pallet to the car
    public void addPallet(Pallet pallet) {
        if (pallet == null) {
            this.pallet = pallet;
        }
    }

    // remove a pallet from the car
    public void removePallet() {
        this.pallet = null;
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

    // get the x
    public int getX() {
        return x;
    }

    // get the y
    public int getY() {
        return y;
    }

    // return the type of vehicle
    public String getTypeOfVehicle() {
        return "ULC";
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
        camera.checkObstacles(this);
        ultrasonic.checkObstacles(this);
        lidar.checkObstacles(this);
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

    // Add from car to shelf
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            shelf.addToShelf(pallet);
            this.pallet = null;
        }
    }

    // Add from shelf to car
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            if (pallet == null) {
                pallet = (Pallet) pack;
                shelf.removeFromShelf(pallet);
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

    // set speed of vehicle up to 3
    public void setSpeed(int speed) {
        if (speed > 0 && speed <= 3) {
            this.speed = speed;
        }
    }

    // get actual speed
    public int getSpeed() {
        return this.speed;
    }

    // get the pallet
    public Pallet getPallet() {
        return this.pallet;
    }

    // add from car to shelf
    public void addPalletToShelf(Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            shelf.addToShelf(pallet);
            this.pallet = null;
        }
    }

    // set the armazem
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }
}
