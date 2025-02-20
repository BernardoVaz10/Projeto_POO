import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * This class contains the methods to create the different types of atoms
 * and the different types of vehicles.
 * The atoms are used to represent the packages.
 * The vehicles are used to represent the different types of vehicles.
 * The methods return a Node object, which is a superclass of all the JavaFX
 * scene graph
 * 
 * @author Bernardo Vaz 202200278, Tiago Ramada 202200354
 * @email Bernardo(202200278@estudantes.ips.pt)
 *        Tiago(202200354@estudantes.ips.pt)
 * @version June 2023
 */
public class Anims {
    /**
     * Method to get the red atoms
     * 
     * @param number
     * @return group
     */
    public static Node getRedAtoms(final int number) {
        Circle circle = new Circle(10, 10f, 3.5);
        circle.setFill(Color.RED);
        Group group = new Group();
        group.getChildren().add(circle);
        return group;
    }

    /**
     * Method to get the green atoms
     * 
     * @param number
     * @return group
     */
    public static Node getGreenAtoms(final int number) {
        Circle circle = new Circle(10, 10f, 3.5);
        circle.setFill(Color.LIGHTGREEN);
        Group group = new Group();
        group.getChildren().add(circle);
        return group;
    }

    /**
     * Method to get the blue atoms
     * 
     * @param number
     * @return group
     */
    public static Node getBlueAtoms(final int number) {
        Rectangle rectangle = new Rectangle(6.5, 6.5, 7, 7);
        rectangle.setFill(Color.BLUE);
        Group group = new Group();
        group.getChildren().add(rectangle);
        return group;
    }

    /**
     * Method to get the violet atoms
     * 
     * @param number
     * @return group
     */
    public static Node getVioletAtoms(final int number) {
        Rectangle rectangle = new Rectangle(6.5, 6.5, 7, 7);
        rectangle.setFill(Color.VIOLET);
        Group group = new Group();
        group.getChildren().add(rectangle);
        return group;
    }

    /**
     * Method to get the yellow atoms
     * 
     * @param number
     * @return group
     */
    public static Node getYellowAtoms(final int number) {
        Rectangle rectangle = new Rectangle(6.5, 6.5, 7, 7);
        rectangle.setFill(Color.YELLOW);
        Group group = new Group();
        group.getChildren().add(rectangle);
        return group;
    }

    /**
     * Method to get car image
     * 
     * @param number
     * @return group
     */
    public static Node getCarImage(final int number) {
        Image image = new Image("images/automatic.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Group group = new Group();
        group.getChildren().add(imageView);
        return group;
    }

    /**
     * Method to get automatic with package image
     * 
     * @param number
     * @return group
     */
    public static Node getAutomaticPackageImage(final int number) {
        Image image = new Image("images/automaticPackage.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Group group = new Group();
        group.getChildren().add(imageView);
        return group;
    }

    /**
     * Method to get trailer image
     * 
     * @param number
     * @return group
     */
    public static Node getTrailerImage(final int number) {
        Image image = new Image("images/trailer.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Group group = new Group();
        group.getChildren().add(imageView);
        return group;
    }

    /**
     * Method to get unitloadcarrier image
     * 
     * @param number
     * @return group
     */
    public static Node getUnitLoadCarrierImage(final int number) {
        Image image = new Image("images/unitloadcarrier.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Group group = new Group();
        group.getChildren().add(imageView);
        return group;
    }

    /**
     * Method to get unitloadcarrier with package image
     * 
     * @param number
     * @return group
     */
    public static Node getUnitLoadCarrierPackageImage(final int number) {
        Image image = new Image("images/unitLoadCarrierPackage.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Group group = new Group();
        group.getChildren().add(imageView);
        return group;
    }

    /**
     * Method to get transportcar image
     * 
     * @param number
     * @return group
     */
    public static Node getTransportCarImage(final int number) {
        Image image = new Image("images/transportcar.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        Group group = new Group();
        group.getChildren().add(imageView);
        return group;
    }
}
