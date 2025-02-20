
import java.util.ArrayList;

/**
 * This class Shelf is an children class of Posicionaveis and will work almost
 * as the vehicle, we create and add/remove packs from shelfes
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */
public class Shelf extends Posicionaveis {
    // instance variables
    private Directions dir;
    private int x;
    private int y;
    private ArrayList<CentroDeDistribuicao> shelfProducts;

    /**
     * Construtor para objetos da classe Shelf
     */
    public Shelf(int x, int y, Directions dir) {
        // add the shelf created to the ArrayList on posicionaveis
        shelfs.add(this);
        // check if the coordenates are valid
        if (x > 0 && x < MAX_X) {
            this.x = x;
        }
        if (y > 0 && y < MAX_Y) {
            this.y = y;
        }
        // inicializate instance variables
        this.dir = dir.getDirectionFacing(dir);
        shelfProducts = new ArrayList<>();
    }

    // add pack to shelf
    public void addToShelf(CentroDeDistribuicao pack) {
        shelfProducts.add(pack);
    }

    // remove pack from shelf
    public void removeFromShelf(CentroDeDistribuicao pack) {
        shelfProducts.remove(pack);
    }

    // boolean to get info about we can load the shelf, from the car
    public boolean canAddToShelf(Veiculo v) {
        if (isOpositeDir(v)) {
            return true;
        }
        return false;
    }

    // auxiliar method to check if its possible to add packs from the vehicle to
    // shelf by seeing if their in opposite directions (example: if shelf direction
    // UP, vehicle direction must be DOWN)
    public boolean isOpositeDir(Veiculo v) {
        if (v.getDirectionFacing() == Directions.DOWN && this.dir == Directions.UP) {
            return true;
        } else if (v.getDirectionFacing() == Directions.UP && this.dir == Directions.DOWN) {
            return true;
        } else if (v.getDirectionFacing() == Directions.LEFT && this.dir == Directions.RIGHT) {
            return true;
        } else if (v.getDirectionFacing() == Directions.RIGHT && this.dir == Directions.LEFT) {
            return true;
        }
        return false;
    }

    // get the direction facing of the shelf
    public Directions getDirectionFacing() {
        return dir;
    }

    // get the x
    public int getX() {
        return x;
    }

    // get the y
    public int getY() {
        return y;
    }

}
