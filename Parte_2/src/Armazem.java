/**
 * The class Armazem will retain the limits of the "map" and will have a name,
 * here is were we will control the most parts related to the map, like load
 * vehicles and shelfs in certain locations as see if they are free/busy.
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */

public class Armazem {

    // instance variables
    private String name;
    private final int MAX_X;
    private final int MAX_Y;
    private Posicionaveis posicionaveis;

    // arrayList matriz de 36x36 com locais vazios e ocupados.
    private int[][] map;

    /**
     * Constructor for objects of class Armazem
     */

    public Armazem(String name, int MAX_X, int MAX_Y) {

        // inicializate variable and call constructor of class Posicionaveis
        this.name = name;
        this.posicionaveis = new Posicionaveis();
        this.MAX_X = MAX_X;
        this.MAX_Y = MAX_Y;
        map = new int[MAX_X][MAX_Y];

        // set all positions of map to free
        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_Y; j++) {
                map[i][j] = 0;
            }
        }
    }

    /**
     * Method to load vehicle on the map
     * 
     * @param v
     */
    public void loadVehicle(Vehicles v) {
        posicionaveis.addVehicle(v);
        setBusy(v.getX(), v.getY());
    }

    /**
     * Method to unload vehicle on the map
     * 
     * @param v
     */
    public void unloadVehicle(Vehicles v) {
        posicionaveis.removeVehicle(v);
        setFree(v.getX(), v.getY());
    }

    /**
     * Method to store shelf on the map
     * 
     * @param s
     */
    public void storeShelf(Shelf s) {
        posicionaveis.addShelf(s);
        setBusy(s.getX(), s.getY());
        setBusy(s.getX2(), s.getY2());
    }

    /**
     * Method to remove shelf on the map
     * 
     * @param s
     */
    public void removeShelf(Shelf s) {
        posicionaveis.removeShelf(s);
        setFree(s.getX(), s.getY());
        setFree(s.getX2(), s.getY2());
    }

    /**
     * Method to set position of the map busy
     * 
     * @param x
     * @param y
     */
    public void setBusy(int x, int y) {
        map[x][y] = 1;
    }

    /**
     * Method to set position of the map free
     * 
     * @param x
     * @param y
     */
    public void setFree(int x, int y) {
        map[x][y] = 0;
    }

    /**
     * Method to check if position of the map is busy
     * 
     * @param x
     * @param y
     * @return true/false
     */
    public boolean isBusy(int x, int y) {
        if (map[x][y] == 1) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if position of the map is free
     * 
     * @param x
     * @param y
     * @return true/false
     */
    public boolean isFree(int x, int y) {
        if (map[x][y] == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if position of the map is valid
     * 
     * @param x
     * @param y
     * @return true/false
     */
    public boolean isValid(int x, int y) {
        if (x < 0 || x > MAX_X || y < 0 || y > MAX_Y) {
            return false;
        }
        return true;
    }

    /**
     * Method to check if position of the map is valid and free
     * 
     * @param x
     * @param y
     * @return true/false
     */
    public boolean isValidAndFree(int x, int y) {
        if (isValid(x, y) && isFree(x, y)) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if position of the map is valid and busy
     * 
     * @param x
     * @param y
     * @return true/false
     */
    public boolean isValidAndBusy(int x, int y) {
        if (isValid(x, y) && isBusy(x, y)) {
            return true;
        }
        return false;
    }

    /**
     * Method to return the name of the map
     * 
     * @return map
     */
    public int[][] getMap() {
        return map;
    }

    /**
     * Method to print the map
     */
    public void printMap() {
        System.out.println("Map:");
        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_Y; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method to return posicionaveis
     * 
     * @return posicionaveis
     */
    public Posicionaveis getPosicionaveis() {
        return posicionaveis;
    }
}