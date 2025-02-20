/**
 * This class Camera is a children class from Sensors that can recognizes the
 * elements of the busy location found
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (a version number or a date)
 */

public class Camera extends Sensors {

    /**
     * Constructor for objects of class Camera
     */
    public Camera() {
        // inicializate instance variables using the father constructor
        super(90, 30);
    }

    // check what kind of obstacle is in the busy posicion found using the ArrayList
    // of posicionaveis and comparing if any of them has the same coordenates of the
    // busy location found, if none was found it means the only obstacle possibly is
    // a wall
    public boolean checkObstacles(Veiculo v) {
        int x;
        int y;
        for (int i = 0; i <= range; i++) {
            x = v.getX();
            x = +i;
            for (int j = 0; j <= 15; j++) {
                y = v.getY();
                y = +j;
                if (armazem.getMap()[x][y] == 1) {
                    if (pos.getVehicleAtLocal(x, y) != null) {
                        System.out.println("There is a vehicle in the way at (" + x + ", " + y + ")! ");
                        return true;
                    } else if (pos.getShelfAtLocal(x, y) != null) {
                        System.out.println("There is a shelf in the way at (" + x + ", " + y + ")! ");
                        return true;
                    } else {
                        System.out.println("There is a wall in the way at (" + x + ", " + y + ")! ");
                        return true;
                    }
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
