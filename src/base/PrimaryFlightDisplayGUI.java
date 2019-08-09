package base;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.util.ArrayList;

public class PrimaryFlightDisplayGUI extends Application {
    private ComboBox<String> batteryComboBox;
    private ComboBox<String> apuOilTankComboBox;
    private TableView tableView;
    private ArrayList<PrimaryFlightDisplayEntry> dataList;
    private ObservableList data;

    //battery
    private PrimaryFlightDisplayEntry batteryEntry;

    //apu_oil_tank
    private PrimaryFlightDisplayEntry apuOilTankEntry;

    public static void main(String... args) {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        Application.launch(args);

        FlightRecorder.instance.shutdown();
        LogEngine.instance.close();
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("A380 - Primary Flight Display");

        Airplane airplane = new Airplane();
        airplane.build();

        Cockpit cockpit = new Cockpit(airplane);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color: #336699;");

        Button startupButton = new Button("Startup");
        startupButton.setPrefSize(75, 20);

        startupButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.startup();
                update();
            }
        });

        Button taxiButton = new Button("Taxi");
        taxiButton.setPrefSize(75, 20);

        taxiButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.taxi();
                update();
            }
        });

        Button takeoffButton = new Button("TakeOff");
        takeoffButton.setPrefSize(75, 20);

        takeoffButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.takeoff();
                update();
            }
        });

        Button climbingButton = new Button("Climbing");
        climbingButton.setPrefSize(75, 20);

        climbingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.climbing();
                update();
            }
        });

        Button rightTurnButton = new Button("R-Turn");
        rightTurnButton.setPrefSize(75, 20);

        rightTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.rightTurn();
                update();
            }
        });

        Button leftTurnButton = new Button("L-Turn");
        leftTurnButton.setPrefSize(75, 20);

        leftTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.leftTurn();
                update();
            }
        });

        Button descentButton = new Button("Descent");
        descentButton.setPrefSize(75, 20);

        descentButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.descent();
                update();
            }
        });

        Button landingButton = new Button("Landing");
        landingButton.setPrefSize(75, 20);

        landingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.landing();
                update();
            }
        });

        Button shutdownButton = new Button("Shutdown");
        shutdownButton.setPrefSize(75, 20);

        shutdownButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.shutdown();
                update();
            }
        });

        hBox.getChildren().addAll(startupButton, taxiButton, takeoffButton, climbingButton, rightTurnButton,
                leftTurnButton, descentButton, landingButton, shutdownButton);

        TabPane tabPane = new TabPane();

        Tab visualTab = new Tab();
        visualTab.setText("Visual");
        visualTab.setContent(buildVisualView());
        tabPane.getTabs().add(visualTab);

        Tab tableTab = new Tab();
        tableTab.setText("Table");
        buildTableView();
        tableTab.setContent(tableView);
        tabPane.getTabs().add(tableTab);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(hBox, tabPane);

        Scene scene = new Scene(vbox, 850, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane buildVisualView() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.BASELINE_LEFT);

        // --- insert section: begin

        //battery
        Label batteryStatusLabel = new Label("BatteryStatus : ");
        gridPane.add(batteryStatusLabel, 6, 0);

        batteryComboBox = new ComboBox<>();
        batteryComboBox.getItems().addAll("0", "50","100");
        batteryComboBox.setValue("0");
        batteryComboBox.setEditable(false);
        gridPane.add(batteryComboBox, 7, 0);

        //apu_oil_tank
        Label apuOilTankStatusLabel = new Label("APUOilTankStatus : ");
        gridPane.add(apuOilTankStatusLabel, 9, 0);

        apuOilTankComboBox = new ComboBox<>();
        apuOilTankComboBox.getItems().addAll("0", "50","100");
        apuOilTankComboBox.setValue("0");
        apuOilTankComboBox.setEditable(false);
        gridPane.add(apuOilTankComboBox, 10, 0);

        return gridPane;
    }

    public void buildTableView() {
        tableView = new TableView();
        data = getInitialTableData();
        tableView.setItems(data);

        TableColumn attributeColumn = new TableColumn("attribute");
        attributeColumn.setCellValueFactory(new PropertyValueFactory("attribute"));

        TableColumn valueColumn = new TableColumn("value");
        valueColumn.setCellValueFactory(new PropertyValueFactory("value"));

        tableView.getColumns().setAll(attributeColumn, valueColumn);
        tableView.setPrefWidth(450);
        tableView.setPrefHeight(450);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void setBatteryStatus(int percentage) {
        batteryComboBox.getItems().addAll(Integer.toString(percentage));
        batteryComboBox.setValue(Integer.toString(percentage));
        batteryComboBox.setEditable(false);
    }

    public void setApuOilTankStatus(int percentage) {
        apuOilTankComboBox.getItems().addAll(Integer.toString(percentage));
        apuOilTankComboBox.setValue(Integer.toString(percentage));
        apuOilTankComboBox.setEditable(false);
    }

    private void initData() {
        dataList = new ArrayList<>();

        // battery
         batteryEntry = new PrimaryFlightDisplayEntry("BatteryStatus", Integer.toString(PrimaryFlightDisplay.instance.percentage));
         dataList.add(batteryEntry);

         //apu_oil_tank
        apuOilTankEntry =  new PrimaryFlightDisplayEntry("APUOilTankStatus",Integer.toString(PrimaryFlightDisplay.instance.level));
        dataList.add(apuOilTankEntry);

    }

    private ObservableList getInitialTableData() {
        initData();
        data = FXCollections.observableList(dataList);
        return data;
    }

    public void update() {
        //battery
        batteryEntry.setValue(Integer.toString(PrimaryFlightDisplay.instance.percentage));
        setBatteryStatus(PrimaryFlightDisplay.instance.percentage);
        tableView.refresh();

        //apu_oil_tank
        apuOilTankEntry.setValue(Integer.toString(PrimaryFlightDisplay.instance.level));
        setApuOilTankStatus(PrimaryFlightDisplay.instance.level);
        tableView.refresh();
    }
}