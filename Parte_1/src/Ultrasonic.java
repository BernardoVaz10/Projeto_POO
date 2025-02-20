
/**
 * This class Ultrasonic is a children class of Sensors and its similar to class
 * Lidar the diference is the angle and range
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */
public class Ultrasonic extends Sensors {
    /**
     * Constructor for objects of class Ultrasonic
     */
    public Ultrasonic() {
        // initialise instance variables using constructor of father class
        super(180, 8);
    }

    // check if there is an busy posicion in the way using the map by simulating
    // the movement of the car using cicles and comparing each one of the simulated
    // posicions wich the map to see if is busy or free
    public boolean checkObstacles(Veiculo v) {
        int x;
        int y;
        for (int i = 0; i <= range; i++) {
            x = v.getX();
            x = +i;
            for (int j = 0; j <= range; j++) {
                y = v.getY();
                y = +j;
                if (armazem.getMap()[x][y] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // get the angle
    public int getAngle() {
        return angle;
    }

    // get the range
    public int getRange() {
        return range;
    }
}
