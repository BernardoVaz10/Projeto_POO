
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

    public Sensors(int angle, int range) {
        // inicializate instance variables
        this.angle = angle;
        this.range = range;
    }

    // set armazem
    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    // set posicionaveis
    public void setPos(Posicionaveis pos) {
        this.pos = pos;
    }
}
