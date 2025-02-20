
/**
 * This class TypeOfProduct is the class that will help us making the
 * distinction of each product giving us the info about what is each product
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version (número da versão ou data aqui)
 */
public enum TypeOfProduct {
    CLOTHINGS, SMALLTOYS, BIGTOYS, SMALLELETRONICS, BIGELETRONICS, BOOKS, ACCESSORIES, NULL;

    // method to get the type of product the product is
    public TypeOfProduct getTypeOfProduct(TypeOfProduct product) {

        switch (product) {
            case CLOTHINGS:
                return CLOTHINGS;

            case SMALLTOYS:
                return SMALLTOYS;

            case BIGTOYS:
                return BIGTOYS;

            case SMALLELETRONICS:
                return SMALLELETRONICS;

            case BOOKS:
                return BOOKS;

            case ACCESSORIES:
                return ACCESSORIES;

            default:
                return NULL;
        }
    }
}
