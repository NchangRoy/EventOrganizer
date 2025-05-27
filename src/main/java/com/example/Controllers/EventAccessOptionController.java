package com.example.Controllers;

import java.io.File;
import java.time.LocalDate;

import com.example.BaseClasses.Concert;
import com.example.Services.GestionEvenement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class EventAccessOptionController {
    GestionEvenement gestionEvenement=GestionEvenement.getGestionEvenement();
    @FXML
    void Create_Events(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/createEvent.fxml"));
       try {
        Parent root=loader.load();
        Scene scene=new Scene(root);
        Scene currentScene=((Node)event.getSource()).getScene();
        createEventController controller=loader.getController();
        controller.initialize(currentScene, this.gestionEvenement);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("create Event");
        stage.show();


        //close current winddow
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

       } catch (Exception e) {
       e.printStackTrace();
       }

    }

    @FXML
    void View_Events(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/showEvents.fxml"));
       try {
        Parent root=loader.load();
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        showEventsController controller=loader.getController();
        Scene currentScene=((Node)event.getSource()).getScene();
        controller.initialize(currentScene);
       controller.fillTable();
        stage.setScene(scene);
        stage.setTitle("View Event");
        stage.show();

        //close current window 
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

       } catch (Exception e) {
        e.printStackTrace();
       }
        
    }
    @FXML
    void Save(ActionEvent event){
        ObjectMapper mapper=new ObjectMapper();
        //add module to serialize Localdate
        mapper.registerModule(new JavaTimeModule());
         File file=new File("src/main/java/com/example/SavedJsonFiles/save.json");
         try {
            mapper.writeValue(file,GestionEvenement.getGestionEvenement());
         } catch (Exception e) {
           e.printStackTrace();
         }
    }

    public void initialize(GestionEvenement gestionEvenement){
        
        this.gestionEvenement=gestionEvenement;
        GestionEvenement gestionEvenement2=GestionEvenement.getGestionEvenement();
        if(gestionEvenement.equals(gestionEvenement2)){
            System.out.println("Same instance");
        }
    }

}