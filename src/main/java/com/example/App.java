package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.Controllers.EventAccessOptionController;
import com.example.Services.GestionEvenement;

public class App extends Application  {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/EventAccessOptions.fxml"));
        Parent root=loader.load();
        EventAccessOptionController controller =loader.getController();
        GestionEvenement gestionEvenement=GestionEvenement.getGestionEvenement();
        controller.initialize(gestionEvenement);
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Options");
        stage.show();
    }   
    public static void main(String[] args) {
        launch(args);
    }
    
}
