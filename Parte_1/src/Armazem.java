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

    // add vehicle to the arrayList veiculos and set on the map that posicion as
    // busy
    public void loadVehicle(Veiculo v) {
        posicionaveis.addVehicle(v);
        setBusy(v.getX(), v.getY());
    }

    // remove vehicle from the arrayList veiculos and set on the map that posicion
    // as free
    public void unloadVehicle(Veiculo v) {
        posicionaveis.removeVehicle(v);
        setFree(v.getX(), v.getY());
    }

    // add shelf to the arrayList shelfs and set on the map that posicion as busy
    public void storeShelf(Shelf s) {
        posicionaveis.addShelf(s);
        setBusy(s.getX(), s.getY());
    }

    // remove shelf to the arrayList shelfs and set on the map that posicion as free
    public void removeShelf(Shelf s) {
        posicionaveis.removeShelf(s);
        setFree(s.getX(), s.getY());
    }

    // Set posicion of the map busy
    public void setBusy(int x, int y) {
        map[x][y] = 1;
    }

    // Set position of the map free
    public void setFree(int x, int y) {
        map[x][y] = 0;
    }

    // Check if position of the map is busy
    public boolean isBusy(int x, int y) {
        if (map[x][y] == 1) {
            return true;
        }
        return false;
    }

    // Check if position of the map is free
    public boolean isFree(int x, int y) {
        if (map[x][y] == 0) {
            return true;
        }
        return false;
    }

    // Check if position is valid (inside the map)
    public boolean isValid(int x, int y) {
        if (x < 0 || x > MAX_X || y < 0 || y > MAX_Y) {
            return false;
        }
        return true;
    }

    // Check if position is valid and free
    public boolean isValidAndFree(int x, int y) {
        if (isValid(x, y) && isFree(x, y)) {
            return true;
        }
        return false;
    }

    // Check if position is valid and busy
    public boolean isValidAndBusy(int x, int y) {
        if (isValid(x, y) && isBusy(x, y)) {
            return true;
        }
        return false;
    }

    // return map
    public int[][] getMap() {
        return map;
    }

    // print map formatted to console
    public void printMap() {
        System.out.println("Map:");
        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_Y; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // return posicionaveis
    public Posicionaveis getPosicionaveis() {
        return posicionaveis;
    }
}
