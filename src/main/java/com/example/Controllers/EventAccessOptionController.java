package com.example.Controllers;

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
        showEventsController SEC=loader.getController();
        SEC.fillTable();
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

    public void initialize(GestionEvenement gestionEvenement){
        
        
    }

}