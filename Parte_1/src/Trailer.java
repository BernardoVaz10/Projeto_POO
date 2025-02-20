
/**
 * This class Trailer is a children class of Veiculo and this is
 * where we will be loading and unloading the content of the car and check if we
 * can actually add them to this type of car (if the pack type is compatible)
 * and add/remove a transport car, because alone this type of car cant move
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class Trailer extends Veiculo {

    // instances variables
    private Directions dir;
    private int x, y;
    private TransportCar tc;
    private int speed;
    private Camera camera;
    private Ultrasonic ultrasonic;
    private Lidar lidar;
    private Armazem armazem;

    /**
     * Construtor para objetos da classe Trailer
     */
    public Trailer(int x, int y, Directions dir) {
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

    // add a transport car
    public void addTransportCar(TransportCar tc) {
        if (tc == null) {
            this.tc = tc;
        }
    }

    // remove a transport car
    public void removeTransportCar(TransportCar tc) {
        if (tc != null) {
            this.tc = null;
        }
    }

    // check if is already have a towcar
    public boolean isTowCar() {
        if (this.tc == null) {
            return false;
        }
        return true;
    }

    // get the actual direction facing of the car
    public Directions getDirectionFacing(Trailer trailer) {
        return dir.getDirectionFacing(dir);
    }

    // get the posicion of the trailer on a string
    public String getPosicion(Trailer trailer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(x).append(", ").append(y);
        return sb.toString();
    }

    // get the type of vehicle
    public String getTypeOfVehicle() {
        return "Trailer";
    }

    // get the location of the car
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(x).append(", ").append(y);
        return sb.toString();
    }

    // method to stop the vehicle
    public void stop() {
        this.speed = 0;
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

    // method to add a pack from the car to the shelf
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        System.out.println("Doesnt transport packs");
    }

    // method to add a pack from the shelf to the car
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        System.out.println("Doesnt transport packs");
    }

    // method to change the actual direction facing of tthe vehicle
    public void changeDirection(Directions dir) {
        this.dir = dir;
    }

    // get the actual direction facing
    public Directions getDirectionFacing() {
        return dir;
    }

    // set the armazem
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    // get the x
    public int getX() {
        return x;
    }

    // get the y
    public int getY() {
        return y;
    }

    // set speed of vehicle (this vehicle cant change speed so its always 1)
    public void setSpeed(int speed) {
        this.speed = 1;
    }

    // get actual speed
    public int getSpeed() {
        return speed;
    }
}
