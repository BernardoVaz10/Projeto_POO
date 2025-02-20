
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * CentroDeDistribuicaoFX class is the main class of the application. It is
 * responsible for creating the initial scene and changing the scene when the
 * user clicks on the button.
 *
 * @author Bernardo e Tiago
 * @version June 2023
 */
public class CentroDeDistribuicaoFX extends GridPane {
    private ShelfesImport shelfesImport;
    private VeiculosImport vehiclesImport;
    private ArmazemImport armazemImport;
    private Armazem armazem;
    private Simulation simulation;

    private ObservableList<String> items;
    private ListView<String> listOfCars;

    private ObservableList<String> itemsInformationCars;
    private ListView<String> listInformationCars;

    private ObservableList<String> items2;
    private ListView<String> listOfShelfs;

    private ObservableList<String> itemsInformationShelfs;
    private ListView<String> listInformationShelfs;

    private BorderPane root;
    private Pane pane;

    private ArrayList<Vehicles> vehicles;
    private ArrayList<Shelf> shelfs;

    /**
     * Constructor for objects of class CentroDeDistribuicaoFX
     */
    public CentroDeDistribuicaoFX() {
        super();

        armazemImport = new ArmazemImport();
        armazem = armazemImport.getArmazem().get(0);
        shelfesImport = new ShelfesImport();
        vehiclesImport = new VeiculosImport(armazem);
        vehicles = vehiclesImport.getVeiculos();
        shelfs = shelfesImport.getShelfes();
        simulation = new Simulation(this);
    }

    /**
     * The getThisScene method is the main entry point for every JavaFX application.
     * It is called after the init() method has returned and after the system is
     * ready for the application to begin running.
     * 
     * @return the initial scene
     */
    public Scene getThisScene() {
        // Create a new borderpane
        root = new BorderPane();

        root.setLeft(getGridPane());
        root.setRight(getStackPane());

        Scene scene = new Scene(root, 1200, 722);
        scene.getStylesheets().add("game.css");
        return scene;
    }

    /**
     * This method creates the grid pane of the application
     * 
     * @return the grid pane
     */
    public GridPane getGridPane() {
        int rows = 36;
        int columns = 36;

        GridPane gp = new GridPane();
        gp.getStyleClass().add("game-grid");

        for (int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(20);
            gp.getColumnConstraints().add(column);
        }

        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(20);
            gp.getRowConstraints().add(row);
        }

        showElements(rows, columns, gp);

        return gp;
    }

    /**
     * This method creates the stack pane of the application
     * 
     * @return the stack pane
     */
    public StackPane getStackPane() {
        StackPane sp = new StackPane();
        sp.getChildren().addAll(getHbox(), movementButtons());
        return sp;
    }

    /**
     * This method creates the hbox of the application
     * 
     * @return the hbox
     */
    public HBox getHbox() {
        HBox hb = new HBox(30);
        hb.getChildren().addAll(getVBoxCars(), getVBoxShelfs());
        hb.setPadding(new Insets(0, 30, 0, 0));
        return hb;
    }

    /**
     * This method creates the vbox of the application
     * 
     * @return the vbox
     */
    public VBox getVBoxCars() {
        VBox sp = new VBox();
        sp.setPadding(new Insets(10));
        sp.setSpacing(10);
        Label listLabel = new Label("Lista de Carros: ");

        this.listOfCars = new ListView<>();
        this.listOfCars.setPrefSize(100, 120);

        this.items = FXCollections.observableArrayList();
        addCarsToList();

        Label listInformationCarsLabel = new Label("Lista de informação dos carros: ");
        this.listInformationCars = new ListView<>();
        this.listInformationCars.setPrefSize(100, 100);
        this.itemsInformationCars = FXCollections.observableArrayList();

        Button btn1 = new Button("See informations");
        btn1.setOnAction(e -> seeInformationCars());

        this.listOfCars.setItems(this.items);

        sp.getChildren().addAll(listLabel, this.listOfCars, btn1, listInformationCarsLabel, this.listInformationCars);
        return sp;
    }

    /**
     * This method adds the cars to the list
     * 
     */
    public void addCarsToList() {
        for (int i = 0; i < vehicles.size(); i++) {
            String name = vehicles.get(i).getTypeOfVehicle();
            if (!name.isEmpty()) {
                this.items.add(name);
            }
        }
    }

    /**
     * This method shows the information of the cars
     * 
     */
    public void seeInformationCars() {
        clearInformationCars();
        int index = this.listOfCars.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            this.itemsInformationCars.add(vehicles.get(index).getInformation());
            this.listInformationCars.setItems(this.itemsInformationCars);
        }
    }

    /**
     * This method clears the information of the cars
     */
    public void clearInformationCars() {
        this.itemsInformationCars.clear();
        this.listInformationCars.setItems(this.itemsInformationCars);
    }

    /**
     * This method creates the vbox of the application
     * 
     * @return the vbox
     */
    public VBox getVBoxShelfs() {
        VBox sp2 = new VBox();
        sp2.setPadding(new Insets(10));
        sp2.setSpacing(10);
        Label listLabel = new Label("Lista de Prateleiras: ");

        this.listOfShelfs = new ListView<>();
        this.listOfShelfs.setPrefSize(100, 120);

        this.items2 = FXCollections.observableArrayList();
        addShelfsToList();

        Label listInformationShelfsLabel = new Label("Lista de informação das prateleiras: ");
        this.listInformationShelfs = new ListView<>();
        this.listInformationShelfs.setPrefSize(100, 100);
        this.itemsInformationShelfs = FXCollections.observableArrayList();

        this.listOfShelfs.setItems(this.items2);
        Button btn2 = new Button("See informations");
        btn2.setOnAction(e -> seeInformationShelfs());

        sp2.getChildren().addAll(listLabel, this.listOfShelfs, btn2, listInformationShelfsLabel, listInformationShelfs);
        return sp2;
    }

    /**
     * This method shows the information of the shelfs
     * 
     */
    public void seeInformationShelfs() {
        clearInformation();
        int index = this.listOfShelfs.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            this.itemsInformationShelfs.add(shelfs.get(index).getInformation());
            this.listInformationShelfs.setItems(this.itemsInformationShelfs);
        }
    }

    /**
     * This method clears the information of the shelfs
     */
    public void clearInformation() {
        this.itemsInformationShelfs.clear();
        this.listInformationShelfs.setItems(this.itemsInformationShelfs);
    }

    /**
     * This method adds the shelfs to the list
     * 
     */
    public void addShelfsToList() {
        for (int i = 0; i < shelfs.size(); i++) {
            String name = shelfs.get(i).getName();
            if (!name.isEmpty()) {
                this.items2.add(name);
            }
        }
    }

    /**
     * This method shows the elements of the application
     * 
     * @param rows    the rows of the application
     * @param columns the columns of the application
     * @param gp      the grid pane of the application
     */
    public void showElements(int rows, int columns, GridPane gp) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                this.pane = new Pane();

                if (j == 0 && i <= 18)
                    pane.getChildren().add(Anims.getRedAtoms(1));

                if (j == 0 && i > 18 || j == 35 && i <= 18 || i == 0 && j >= 1 || i == 35 && j < 35)
                    pane.getChildren().add(Anims.getVioletAtoms(1));

                if (j == 35 && i > 18)
                    pane.getChildren().add(Anims.getGreenAtoms(1));

                // Show the shelfes in the grid pane (blue squares)
                for (int k = 0; k < this.shelfs.size(); k++) {
                    if (this.shelfs.get(k).getX() == i
                            && this.shelfs.get(k).getY() == j)
                        pane.getChildren().add(Anims.getBlueAtoms(1));

                    if (this.shelfs.get(k).getX2() == i
                            && this.shelfs.get(k).getY2() == j)
                        pane.getChildren().add(Anims.getBlueAtoms(1));
                }

                if (i == 5 && j == 18)
                    pane.getChildren().add(Anims.getYellowAtoms(1));

                if (i == 3 && j == 22)
                    pane.getChildren().add(Anims.getYellowAtoms(1));

                if (i == 5 && j == 26 || i == 5 && j == 27)
                    pane.getChildren().add(Anims.getYellowAtoms(1));

                if (i == 3 && j == 29)
                    pane.getChildren().add(Anims.getYellowAtoms(1));

                // Show the vehicles in the grid pane
                for (int k = 0; k < this.vehicles.size(); k++) {

                    if (this.vehicles.get(k).getX() == 14) {
                        // print coordinates of the vehicle
                        System.out.println("X: " + this.vehicles.get(k).getX());
                        System.out.println("Y: " + this.vehicles.get(k).getY() + "\n\n");
                    }

                    if (this.vehicles.get(k).getX() == i
                            && this.vehicles.get(k).getY() == j)

                        if (this.vehicles.get(k).getTypeOfVehicle() == "AGV") {
                            if (this.vehicles.get(k).getActualWeight() == 0.0)
                                pane.getChildren().add(Anims.getCarImage(1));
                            else
                                pane.getChildren().add(Anims.getAutomaticPackageImage(1));
                        } else if (this.vehicles.get(k).getTypeOfVehicle() == "TransportCar") {
                            pane.getChildren().add(Anims.getTransportCarImage(1));
                        } else if (this.vehicles.get(k).getTypeOfVehicle() == "Trailer") {
                            pane.getChildren().add(Anims.getTrailerImage(1));
                        } else if (this.vehicles.get(k).getTypeOfVehicle() == "ULC") {
                            if (this.vehicles.get(k).getActualWeight() == 0.0)
                                pane.getChildren().add(Anims.getUnitLoadCarrierImage(1));
                            else
                                pane.getChildren().add(Anims.getUnitLoadCarrierPackageImage(1));
                        }
                }

                pane.getStyleClass().add("game-grid-cell");
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                gp.add(pane, i, j);
            }
        }
    }

    /**
     * This method creates the movement buttons of the application
     * 
     * @return the hbox
     */
    public HBox movementButtons() {
        Button move = new Button("Move");
        move.setOnAction(e -> buttonMove());
        Button stop = new Button("Stop");
        stop.setOnAction(e -> stop());

        HBox hb = new HBox();
        hb.setTranslateX(125);
        hb.setTranslateY(350);
        hb.setSpacing(10);
        hb.getChildren().addAll(move, stop);

        return hb;
    }

    /**
     * This method moves the vehicles
     * 
     */
    public void buttonMove() {
        int index = this.listOfCars.getSelectionModel().getSelectedIndex();
        vehicles.get(index).setSpeed(1);

        if (index != -1) {
            if (vehicles.get(index).getTypeOfVehicle() == "AGV") {
                this.simulation.stepAVG(vehicles, index);
            } else if (vehicles.get(index).getTypeOfVehicle() == "TransportCar") {
                // this.simulation.stepAVG(vehicles, index);
            } else if (vehicles.get(index).getTypeOfVehicle() == "Trailer") {
                // this.simulation.stepTrailer(vehicles, index, this);
            } else if (vehicles.get(index).getTypeOfVehicle() == "ULC") {
                this.simulation.stepAVG(vehicles, index);
            }
        }

        root.setLeft(getGridPane());
    }

    /**
     * This method stops the vehicles
     * 
     */
    public void stop() {
        int index = this.listOfCars.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            vehicles.get(index).stop();
        }
    }

    /**
     * This method sets the left of the application
     * 
     */
    public void setLeft() {
        root.setLeft(getGridPane());
    }

    /**
     * This method sets the right of the application
     * 
     */
    public Pane getPane() {
        return this.pane;
    }

    /**
     * This method sets the right of the application
     * 
     */
    public ArrayList<Shelf> getShelfes() {
        return this.shelfs;
    }

    /**
     * This method sets the right of the application
     * 
     */
    public Armazem getArmazem() {
        return this.armazem;
    }
}
