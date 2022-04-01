package br.com.silascaimi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Formulário");
    	
    	BorderPane root = new BorderPane();
    	root.setPadding(new Insets(10));
    	
    	GridPane grid = new GridPane();
    	grid.setHgap(5);
    	grid.setVgap(7);
    	
    	// Input Nome
    	grid.add(new Label("Nome:"), 0, 0);
    	TextField txtNome = new TextField();
    	GridPane.setHgrow(txtNome, Priority.ALWAYS);
    	grid.add(txtNome, 1, 0);
    	
    	// Input Email
    	grid.add(new Label("Email:"), 0, 1);
    	TextField txtEmail = new TextField();
    	GridPane.setHgrow(txtEmail, Priority.ALWAYS);
    	grid.add(txtEmail, 1, 1);
    	
    	// Radio Sexo
    	grid.add(new Label("Sexo:"), 0, 2);
    	RadioButton btnMasc = new RadioButton("Masculino");
    	btnMasc.setSelected(true);
    	RadioButton btnFem = new RadioButton("Feminino");
    	
    	ToggleGroup group = new ToggleGroup();
    	btnMasc.setToggleGroup(group);
    	btnFem.setToggleGroup(group);
    	
    	HBox radioBox = new HBox(5, btnMasc, btnFem);
    	grid.add(radioBox, 1, 2);
    	
    	// Select Estados
    	grid.add(new Label("Estado:"), 0, 3);
    	ChoiceBox<String> chcEstados = new ChoiceBox<String>();
    	ObservableList<String> estados = FXCollections.observableArrayList("Paraná", "São Paulo", "Pernambuco", "Amazonas");
    	chcEstados.setItems(estados);
    	chcEstados.getSelectionModel().select(0);;
    	grid.add(chcEstados, 1, 3);
    	
    	root.setCenter(grid);
    	
    	// Buttons
    	HBox buttonBar = new HBox(5);
    	buttonBar.setAlignment(Pos.CENTER_RIGHT);
    	Button btnGravar = new Button("Gravar");
    	Button btnCancelar = new Button("Cancelar");
    	buttonBar.getChildren().addAll(btnGravar, btnCancelar);
    	
    	root.setBottom(buttonBar);
    	
    	Scene scene = new Scene(root, 300, 200);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }

}