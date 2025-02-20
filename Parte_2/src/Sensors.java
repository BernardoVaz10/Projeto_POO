/**
 * This class Sensors is the father class of Camera, Lidar and Ultrasonic and is
 * used to create each one of the sensors wich their angle and range already
 * determinated
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou data aqui)
 */

public class Sensors extends Posicionaveis {
    // instance variables
    protected int angle;
    protected int range;
    Armazem armazem;
    Posicionaveis pos;

    /**
     * Constructor for objects of class Sensors
     */
    public Sensors(int angle, int range) {
        // inicializate instance variables
        this.angle = angle;
        this.range = range;
    }

    /**
     * Set the armazem
     * 
     * @param armazem
     */
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    /**
     * Method to set the position of the sensor
     * 
     * @param pos
     */
    public void setPos(Posicionaveis pos) {
        this.pos = pos;
    }
}