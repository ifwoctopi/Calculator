/*
Staci Tranquille
05/1/2024
Computer Program Design Section 002
Java FX Application for Scientific Calculator. Accessing the Calculator.
 */
package com.example.fxhelloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculating extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        // Create a FXMLLoader to load the GUI layout from the FXML file.
        FXMLLoader fxmlLoader = new FXMLLoader(Calculating.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        stage.setTitle("Scientific Calculator");  // Set the title of the stage (main window).
        stage.setScene(scene);
        stage.show(); //Shows the stage (application) to the user
    }

    public static void main(String[] args) {
        launch(); //launches the application
    }
}