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
    private int x, x2;
    private int y, y2;
    private ArrayList<CentroDeDistribuicao> shelfProducts;

    /**
     * Construtor para objetos da classe Shelf
     */
    public Shelf(int x, int y, Directions dir, int x2, int y2) {
        // add the shelf created to the ArrayList on posicionaveis
        shelfs.add(this);
        // check if the coordenates are valid
        if (x > 0 && x < MAX_X && x2 > 0 && x2 < MAX_X) {
            this.x = x;
            this.x2 = x2;
        }
        if (y > 0 && y < MAX_Y && y2 > 0 && y2 < MAX_Y) {
            this.y = y;
            this.y2 = y2;
        }
        // inicializate instance variables
        this.dir = dir.getDirectionFacing(dir);
        shelfProducts = new ArrayList<>();
    }

    /**
     *  Method to add to shelf
     * 
     * @param pack
     */
    public void addToShelf(CentroDeDistribuicao pack) {
        shelfProducts.add(pack);
    }

    /**
     * Method to remove from shelf
     * 
     * @param pack
     */
    public void removeFromShelf(CentroDeDistribuicao pack) {
        shelfProducts.remove(pack);
    }

    /**
     * Method to check if its possible to add to shelf
     * 
     * @return true/false
     */
    public boolean canAddToShelf(Vehicles v) {
        if (isOpositeDir(v)) {
            return true;
        }
        return false;
    }

    /**
     * Method to return the number of products on shelf
     * 
     * @return count
     */
    public int numberOfProducts() {
        int count = 0;
        if (shelfProducts.isEmpty() == true) {
            return count;
        }
        for (int i = 0; i < shelfProducts.size(); i++) {
            count++;
        }
        return count;
    }

    /**
     * Method to check if the vehicle is in the oposite direction of the shelf
     * 
     * @param v
     * @return true/false
     */
    public boolean isOpositeDir(Vehicles v) {
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

    /**
     * Method to get the direction of the shelf
     * 
     * @return dir
     */
    public Directions getDirectionFacing() {
        return dir;
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
     * Method to get the x2
     * 
     * @return x2
     */
    public int getX2() {
        return x2;
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
     * Method to get the y2
     * 
     * @return y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * Method to get the name
     * 
     * @return "Shelf"
     */
    public String getName() {
        return "Shelf";
    }

    /**
     * Method to get the information
     * 
     * @return sb.toString()
     */
    public String getInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posições: X-").append(getX()).append(", X2-").append(getX2()).append(", Y-").append(getY())
                .append(", Y2-").append(getY2()).append(", Direção: ").append(getDirectionFacing())
                .append(", Quantidade de produtos: ").append(numberOfProducts());
        return sb.toString();
    }

}
