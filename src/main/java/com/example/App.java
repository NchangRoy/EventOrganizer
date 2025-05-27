package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

import com.example.Controllers.EventAccessOptionController;
import com.example.Services.GestionEvenement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
public class App extends Application  {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/EventAccessOptions.fxml"));
        Parent root=loader.load();
        EventAccessOptionController controller =loader.getController();

        //create jackson object mapper
        ObjectMapper mapper=new ObjectMapper();
        //add module to handle Localdate
        mapper.registerModule(new JavaTimeModule());
        

        File file=new File("src/main/java/com/example/SavedJsonFiles/save.json");
        GestionEvenement gestionEvenement=mapper.readValue(file, GestionEvenement.class);

        //pass gestionEvenement to next class
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
