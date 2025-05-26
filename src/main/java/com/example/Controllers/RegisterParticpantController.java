package com.example.Controllers;



import com.example.BaseClasses.Event;
import com.example.BaseClasses.Participant;
import com.example.Exceptions.CapaciteMaxAtteinteException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class RegisterParticpantController {
    Event event;
    Scene previouScene;
    ManageParticpantsController previousStagecontroller;
    @FXML
    private Label alertLabel;

    @FXML
    private TextField partEmail;

    @FXML
    private TextField partName;

    @FXML
    void addParticpant(ActionEvent event) {
        int counter=Participant.getCounter();
        Participant participant=new Participant("POO"+counter,partName.getText(),partEmail.getText());
      try {
        this.event.ajouterParticipant(participant);
        alertLabel.setText("Participant Added");
        previousStagecontroller.initializeTable();
      } catch (CapaciteMaxAtteinteException e) {
        alertLabel.setText("Max Capacity Attained");
      }
    }
    @FXML
    void goBack(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(previouScene);
    }
    void initialize(Event event,Scene previouScene,ManageParticpantsController previousStageController){
        this.previouScene=previouScene;
        this.event=event;
        this.previousStagecontroller=previousStageController;
        

    }


}