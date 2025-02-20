/**
 * This class lidar is a children class from Sensors that can see wich positions
 * of the map are free or busy
 * 
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */

public class Lidar extends Sensors {

    /**
     * Constructor for objects of class Lidar
     */
    public Lidar() {
        // inicializate instance variables using the father contructor
        super(30, 20);
    }

    /**
     * Method to check if there is an busy posicion in the way using the map by
     * simulating the movement of the car using cicles and comparing each one of the
     * simulated posicions wich the map to see if is busy or free
     * 
     * @param v
     * @return true or false
     */
    public boolean checkObstacles(Vehicles v) {
        int x;
        int y;
        for (int i = 0; i <= range; i++) {
            x = v.getX();
            x = +i;
            for (int j = 0; j <= 4; j++) {
                y = v.getY();
                y = +j;
                if (armazem.getMap()[x][y] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to get the angle
     * 
     * @return angle
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Method to get the range
     * 
     * @return range
     */
    public int getRange() {
        return range;
    }
}
