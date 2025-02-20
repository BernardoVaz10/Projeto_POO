
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;

/**
 * Intro class is the main class of the application. It is responsible for
 * creating the initial scene and changing the scene when the user clicks on the
 * button.
 *
 * @author Bernardo e Tiago
 * @version June 2023
 */
public class Intro extends Application {
    // Variables
    public static final int INTRO_WIDTH = 1024;
    public static final int INTRO_HEIGHT = 640;
    private Stage stage;

    /**
     * The start method is the main entry point for every JavaFX application.
     * It is called after the init() method has returned and after
     * the system is ready for the application to begin running.
     *
     * @param stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Centro de Distribuição");
        stage.setResizable(false);
        stage.setScene(getInitialScene());
        stage.show();
    }

    /**
     * This method creates the initial scene of the application
     * 
     * @return the initial scene
     */
    public Scene getInitialScene() {
        // Create a new border pane
        StackPane root = new StackPane();
        root.setPadding(new Insets(10, 10, 10, 10));

        // create a label
        Label label = new Label("Centro de Distribuição");
        label.setPadding(new Insets(10, 10, 10, 10));
        label.setStyle("-fx-font-size: 25px;");
        label.setTranslateY(-250);

        // button created
        Button startButton = new Button("Start");
        startButton.setPadding(new Insets(10, 10, 10, 10));
        startButton.setTranslateY(150);

        // set an action on the button using method reference
        startButton.setOnAction(this::buttonClick);

        // Load and configure the image
        Image image = new Image("images/start.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        imageView.setTranslateY(-50);

        DropShadow sombra = new DropShadow();
        sombra.setRadius(2.0);
        sombra.setOffsetX(5.0);
        sombra.setOffsetY(5.0);
        sombra.setColor(Color.GREY);
        label.setEffect(sombra);

        root.getChildren().addAll(label, startButton, imageView);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, INTRO_WIDTH, INTRO_HEIGHT);
        return scene;
    }

    /**
     * This will be executed when the button is clicked
     */
    private void buttonClick(ActionEvent event) {
        showPopup();
    }

    /**
     * This method changes the current scene
     * 
     * @param scene the new scene
     */
    public void changeScene(Scene scene) {
        stage.setScene(scene);
    }

    /**
     * This method shows a popup
     */
    private void showPopup() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Before start");
        alert.setHeaderText("Centro de Distribuição");
        alert.setContentText("This project aims to create a distribution center management system.\n\n"
                + "It will include features such as inventory management, order processing, and others.\n\n"
                + "Once you close this popup, the main program will be displayed.");

        alert.showAndWait();
        showMainScene();
    }

    /**
     * This method shows the main scene
     */
    private void showMainScene() {
        // calling the new scene
        CentroDeDistribuicaoFX cd = new CentroDeDistribuicaoFX();
        stage.setScene(cd.getThisScene());
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
