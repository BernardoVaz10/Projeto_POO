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
    protected static ArrayList<Veiculo> veiculos;
    protected static ArrayList<Shelf> shelfs;

    // Constructor of class, were we inicializate the ArrayList
    public Posicionaveis() {
        veiculos = new ArrayList<Veiculo>();
        shelfs = new ArrayList<Shelf>();
    }

    // add veiculo to ArrayList veiculos
    public void addVehicle(Veiculo v) {
        veiculos.add(v);
    }

    // remove veiculo from ArrayList veiculos
    public void removeVehicle(Veiculo v) {
        veiculos.remove(v);
    }

    // add shelf to ArrayList shelfs
    public void addShelf(Shelf s) {
        shelfs.add(s);
    }

    // remove shelf from ArrayList shelfs
    public void removeShelf(Shelf s) {
        shelfs.remove(s);
    }

    // check if the vehicle is in any of the locals (Armazenamento or Venda)
    public boolean isOccupiedAtLocal(Veiculo v) {
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

    // check if the vehicle is not any of the locals (Armazenamento or Venda)
    public boolean isOccupiedOutLocal(Veiculo v) {
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

    // get the vehicle that is in the coordenates given
    public Veiculo getVehicleAtLocal(int x, int y) {
        for (Veiculo v : veiculos) {
            if (v.getX() == x) {
                if (v.getY() == y) {
                    return v;
                }
            }
        }
        return null;
    }

    // get the shelf that is in the coordenates given
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

// enum of the directions that is used in the vehicles and shelfs
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
