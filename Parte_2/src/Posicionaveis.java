import java.util.ArrayList;

/**
 * This class Posicionaveis is the father class of almost every class (directly
 * or indirectly) and here ww will store every vehicle created and every shelf
 * created so we can later have access either to compare or select the one
 * pretended
 *
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */

public class Posicionaveis {
    // instance variables putting the their status to protected so the children
    // classes have access to them
    protected final int MAX_X = 36;
    protected final int MAX_Y = 36;
    protected static ArrayList<Vehicles> veiculos;
    protected static ArrayList<Shelf> shelfs;

    /**
     * Constructor for objects of class Posicionaveis
     */
    public Posicionaveis() {
        veiculos = new ArrayList<Vehicles>();
        shelfs = new ArrayList<Shelf>();
    }

    /**
     * Method to add vehicle to ArrayList veiculos
     * 
     * @param v
     */
    public void addVehicle(Vehicles v) {
        veiculos.add(v);
    }

    /**
     * Method to remove vehicle from ArrayList veiculos
     * 
     * @param v
     */
    public void removeVehicle(Vehicles v) {
        veiculos.remove(v);
    }

    /**
     * Method to add shelf to ArrayList shelfs
     * 
     * @param s
     */
    public void addShelf(Shelf s) {
        shelfs.add(s);
    }

    /**
     * Method to remove shelf from ArrayList shelfs
     * 
     * @param s
     */
    public void removeShelf(Shelf s) {
        shelfs.remove(s);
    }

    /**
     * Method to check if the coordenates are valid
     * 
     * @param v
     * @return true/false
     */
    public boolean isOccupiedAtLocal(Vehicles v) {
        for (int i = 0; i <= MAX_X; i++) {
            for (int j = 0; j <= MAX_Y / 2; j++) {
                if (v.getX() == i) {
                    if (v.getY() == j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method to check if the coordenates are valid
     * 
     * @param v
     * @return true/false
     */
    public boolean isOccupiedOutLocal(Vehicles v) {
        for (int i = 0; i <= MAX_X; i++) {
            for (int j = 18; j <= MAX_Y; j++) {
                if (v.getX() == i) {
                    if (v.getY() == j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Method to check if the coordenates are valid
     * 
     * @param x
     * @param y
     * @return true/false
     */
    public Vehicles getVehicleAtLocal(int x, int y) {
        for (Vehicles v : veiculos) {
            if (v.getX() == x) {
                if (v.getY() == y) {
                    return v;
                }
            }
        }
        return null;
    }

    /**
     * Method to get the shelf at the coordenates
     * 
     * @param x
     * @param y
     * @return s
     */
    public Shelf getShelfAtLocal(int x, int y) {
        for (Shelf s : shelfs) {
            if (s.getX() == x) {
                if (s.getY() == y) {
                    return s;
                }
            }
        }
        return null;
    }

}

/**
 * This class Directions is an enum class that will be used to set the direction
 * of the vehicles
 * 
 * @version June 2023
 */
enum Directions {
    UP, DOWN, RIGHT, LEFT, NULL;

    // method to get the posicion that the object is currently facing
    public Directions getDirectionFacing(Directions dir) {

        switch (dir) {
            case UP:
                return UP;

            case DOWN:
                return DOWN;

            case RIGHT:
                return RIGHT;

            case LEFT:
                return LEFT;

            default:
                return NULL;
        }
    }
}