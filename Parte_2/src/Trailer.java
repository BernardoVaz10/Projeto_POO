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

public class Trailer extends Vehicles {

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
    public Trailer(int x, int y, Directions dir, Armazem armazem) {
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
        this.armazem = armazem;
        camera = new Camera();
        ultrasonic = new Ultrasonic();
        lidar = new Lidar();
    }

    /**
     * Method to add a transport car
     * 
     * @param tc
     */
    public void addTransportCar(TransportCar tc) {
        if (tc == null) {
            this.tc = tc;
        }
    }

    /**
     * Method to remove a transport car
     * 
     * @param tc
     */
    public void removeTransportCar(TransportCar tc) {
        if (tc != null) {
            this.tc = null;
        }
    }

    /**
     * Method to check if the trailer is towing a car
     * 
     * @return true/false
     */
    public boolean isTowCar() {
        if (this.tc == null) {
            return false;
        }
        return true;
    }

    /**
     * Method to get the information of the trailer
     * 
     * @return sb.toString()
     */
    public String towCar() {
        if (isTowCar() == true) {
            return "Está a rebocar um veículo";
        }
        return "Não está a rebocar nenhum veículo";
    }

    /**
     * Method to get the information of the trailer
     * 
     * @return sb.toString()
     */
    public String getInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLocation()).append(", Direção: ").append(getDirectionFacing())
                .append(", Estado da carga: ").append(towCar()).append(", Velocidade: ").append(getSpeed());
        return sb.toString();
    }

    /**
     * Method to get the direction facing of the trailer
     * 
     * @return dir.getDirectionFacing(dir)
     */
    public Directions getDirectionFacing(Trailer trailer) {
        return dir.getDirectionFacing(dir);
    }

    /**
     * Method to get the position of the trailer
     * 
     * @return sb.toString()
     */
    public String getPosicion(Trailer trailer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: ").append(x).append(", ").append(y);
        return sb.toString();
    }

    /**
     * Method to get the type of the vehicle
     * 
     * @return "Trailer"
     */
    public String getTypeOfVehicle() {
        return "Trailer";
    }

    /**
     * Method to get the actual weight of the vehicle
     * 
     * @return 0
     */
    public double getActualWeight() {
        return 0;
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
     * Method to stop
     */
    public void stop() {
        this.speed = 0;
    }

    /**
     * Method to move the vehicle
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
     * Method to add a pack from the car to the shelf
     * 
     * @param pack
     * @param shelf
     */
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        System.out.println("Doesnt transport packs");
    }

    /**
     * Method to add a pack from the shelf to the car
     * 
     * @param pack
     * @param shelf
     */
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        System.out.println("Doesnt transport packs");
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
     * Method to get the direction of the vehicle
     * 
     * @return dir
     */
    public Directions getDirectionFacing() {
        return dir;
    }

    /**
     * Method to set the armazem of the vehicle
     * 
     * @param armazem
     */
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    /**
     * Method to get x
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Method to get y
     * 
     * @return y
     */
    public int getY() {
        return y;
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
        return speed;
    }

    /**
     * Method to set x
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method to set y
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
