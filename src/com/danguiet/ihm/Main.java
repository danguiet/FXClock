package com.danguiet.ihm;

import com.danguiet.ihm.fxclock.Clock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Clock clock = new Clock(100.0d, Color.BISQUE);

		Pane root = new Pane();
		root.getChildren().add(clock);
		root.setStyle("-fx-background-color : rgb(20, 20, 30)");
		Scene scene = new Scene(root);

		stage.setScene(scene);

		stage.setTitle("Clock demo");
		stage.show();
	}

}
