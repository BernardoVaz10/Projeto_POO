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
public class UnitLoadCarrier extends Vehicles {

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
    public UnitLoadCarrier(int x, int y, Directions dir, Armazem armazem) {
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
     * Method to add a pallet to the car
     * 
     * @param pallet
     */
    public void addPallet(Pallet pallet) {
        if (pallet == null) {
            this.pallet = pallet;
        }
    }

    /**
     * Method to get the actual weight of the car
     * 
     * @return weight
     */
    public double getActualWeight() {
        if (pallet != null) {
            return 1;
        }
        return 0;
    }

    /**
     * Method to add from car to venda
     * 
     * @param pack
     * @param venda
     */
    @Override
    public void addFromCarToVenda(CentroDeDistribuicao pack, Venda venda) {
        if (pallet != null) {
            venda.receivePackages(pack);
            this.pallet = null;
        }
    }

    /**
     * Method to add from venda to car
     * 
     * @param pack
     * @param venda
     */
    public void removePallet() {
        this.pallet = null;
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
     * Method to get the x
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Method to get the y
     * 
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Method to get the type of vehicle
     * 
     * @return "ULC"
     */
    public String getTypeOfVehicle() {
        return "ULC";
    }

    /**
     * Method to get the pallet
     * 
     * @return pallet
     */
    public String pallet() {
        if (getPallet() != null) {
            return "O veículo possui 1 palete";
        }
        return "O veículo não possui paletes";
    }

    /**
     * Method to get the information of the vehicle
     * 
     * @return sb.toString()
     */
    public String getInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLocation()).append(", Direção: ").append(getDirectionFacing())
                .append(", Estado da carga: ").append(pallet()).append(", Velocidade: ").append(getSpeed());
        return sb.toString();
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
                        //System.out.println("x: " + this.x + " y: " + this.y);
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
                        //System.out.println("x: " + this.x + " y: " + this.y);
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
                        //System.out.println("x: " + this.x + " y: " + this.y);
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
                        //System.out.println("x: " + this.x + " y: " + this.y);
                        armazem.setFree(this.getX(), this.getY());
                        x -= this.speed;
                        centroDeDistribuicaoFX.showElements(MAX_Y, MAX_X, centroDeDistribuicaoFX.getGridPane());
                        //System.out.println("x: " + this.x + " y: " + this.y);
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
                            if (this.x == x - 1 || this.y == y - 1 ) {
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
     * Method to add from car to shelf
     * 
     * @param pack
     * @param shelf
     */
    public void addFromCarToShelf(CentroDeDistribuicao pack, Shelf shelf) {
        //if (shelf.isOpositeDir(this)) {
            shelf.addToShelf(pallet);
            this.pallet = null;
        //}
    }

    /**
     * Method to add from shelf to car
     * 
     * @param pack
     * @param shelf
     */
    public void addFromShelfToCar(CentroDeDistribuicao pack, Shelf shelf) {
        //if (shelf.isOpositeDir(this)) {
            if (pack != null) {
                pallet = (Pallet) pack;
                shelf.removeFromShelf(pallet);
            }
        //}
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
        if (speed > 0 && speed <= 3) {
            this.speed = speed;
        }
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
     * Method to get the pallet
     * 
     * @return pallet
     */
    public Pallet getPallet() {
        return this.pallet;
    }

    /**
     * Method to add pallet to shelf
     * 
     * @param shelf
     */
    public void addPalletToShelf(Shelf shelf) {
        if (shelf.isOpositeDir(this)) {
            shelf.addToShelf(pallet);
            this.pallet = null;
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
     * Method to set the x
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method to set the y
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
