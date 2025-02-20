
//imports
import java.util.ArrayList;

/**
 * This class Pallet is a children class of CentroDeDistribuicao and its a type
 * of packing that can be used to pack some type of product, this is where we
 * will see if we can add some type of product and add or remove them if
 * possible
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (um número da versão ou uma data)
 */

public class Pallet extends CentroDeDistribuicao {
    // instance variables and assuming that the number maximum cardbox, a pallet can
    // take its 5
    private ArrayList<CardBox> cb;
    private static final int MAX_CARDBOXES = 5;

    /**
     * Construtor para objetos da classe Pallet
     */

    public Pallet() {
        // inicializate instance variables using the constructor of father class
        super('P');
        cb = new ArrayList<>();
    }

    // return the code of the pallet
    public String getCode() {

        StringBuilder sb = new StringBuilder();
        sb.append(getType()).append(getIdPacking());
        return sb.toString();
    }

    // auxiliar method to see if we can add the cardbox to the pallet (assuming that
    // the maximum is 5)
    public boolean canStore(CardBox cardbox) {
        if (cb.size() < MAX_CARDBOXES) {
            return true;
        }
        return false;
    }

    // add a cardbox to the pallet
    public void addCardBox(CardBox cardBox) {
        if (canStore(cardBox) == true) {
            cb.add(cardBox);
        }
    }

    // remove a cardbox from the pallet
    public void removeCardBox(CardBox cardbox) {
        for (CardBox cardb : cb) {
            if (cardb.equals(cardbox)) {
                cb.remove(cardbox);
            }
        }
    }

}
