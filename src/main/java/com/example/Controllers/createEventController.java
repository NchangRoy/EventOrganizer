package com.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

import com.example.BaseClasses.Concert;
import com.example.BaseClasses.Conference;
import com.example.BaseClasses.Event;
import com.example.Exceptions.EvenementDejaExistantException;
import com.example.Services.GestionEvenement;
public class createEventController {
    GestionEvenement gestionEvenement;
    Scene previousScene;
    @FXML
    private Label alertLabel;

     @FXML
    private TextField concertArtist;

    @FXML
    private TextField concertGenre;

    @FXML
    private VBox concertVBox;

    @FXML
    private HBox confHBox;

    @FXML
    private TextField confTheme;

    @FXML
    private TextField eventCapacity;

    @FXML
    private DatePicker eventDate;

    @FXML
    private TextField eventID;

    @FXML
    private TextField eventName;

    @FXML
    private ChoiceBox<String> eventTypeChooser;
    @FXML
    void createEvent(ActionEvent event) {
        

           try{
          try {
            int capacity=Integer.parseInt(eventCapacity.getText());
             

             //we check if the user selected a concert or conference 
             if(eventTypeChooser.getValue().equals("Concert")){
                Concert concert =new Concert(eventID.getText(),eventName.getText(),eventDate.getValue(),capacity,concertArtist.getText(),concertGenre.getText());
                gestionEvenement.ajouterEvenement(concert);
             }
             else if(eventTypeChooser.getValue().equals("Conference")){
                 Conference conference=new Conference(eventID.getText(),eventName.getText(),eventDate.getValue(),capacity,confTheme.getText());
                 gestionEvenement.ajouterEvenement(conference);
             }


           
            alertLabel.setText("Event Created");
        
           
            
        

          } catch (NumberFormatException e) {
            alertLabel.setText("Category must be int");
          }

        } catch (EvenementDejaExistantException e) {
            alertLabel.setText("Event already exists");
        }
     
      
        
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       for(Event e:gestionEvenement.getEvents()){
        System.out.println(e.afficherDetails());
       }
        stage.setScene(this.previousScene);
        
    }
    public void initialize(Scene previouScene,GestionEvenement gestionEvenement){
        this.previousScene=previouScene;
        this.gestionEvenement=GestionEvenement.getGestionEvenement();
        eventTypeChooser.getItems().addAll("Concert","Conference");
        
        eventTypeChooser.setOnAction(e->{
            if(eventTypeChooser.getValue().equals("Concert")){
                concertVBox.setVisible(true);
                confHBox.setVisible(false);
            }
            else if(eventTypeChooser.getValue().equals("Conference")){
                concertVBox.setVisible(false);
                confHBox.setVisible(true);
            }
        });
        
    }

}
