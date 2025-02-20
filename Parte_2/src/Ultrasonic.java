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

    /**
     * Method to check if there is any obstacle in the way of the vehicle
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