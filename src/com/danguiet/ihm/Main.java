package com.danguiet.ihm;

import com.danguiet.ihm.fxclock.Clock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Clock clock = new Clock(300.0d);

		Scene scene = new Scene(clock);

		stage.setScene(scene);

		stage.setTitle("Clock demo");
		stage.show();
	}

}
