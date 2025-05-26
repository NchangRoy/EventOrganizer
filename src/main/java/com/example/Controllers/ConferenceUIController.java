package com.example.Controllers;

import com.example.BaseClasses.Conference;
import com.example.BaseClasses.Event;
import com.example.BaseClasses.Intervenant;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConferenceUIController {
    Scene previouScene;
    Conference conference;
   
    @FXML
    private TableColumn<Intervenant,String> IntervID;

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
    private TextField eventName;

    @FXML
    private TableColumn<Intervenant,String> intervEmail;

    @FXML
    private TableColumn<Intervenant, String> intervName;
    @FXML
    private TextField eventTheme;

    @FXML
    private TableView<Intervenant> intervTable;


    @FXML
    private TextField inteEmail;

    @FXML
    private TextField inteName;
    @FXML
    void addIntervenant(ActionEvent event) {
        Intervenant intervenant=new Intervenant("IOO"+Intervenant.getCounter(),inteName.getText(),inteEmail.getText());;
         conference.ajouterIntervenant(intervenant);
         alertLabel.setText("Intervenant Created");
         intializeTable();
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(previouScene);
    }

    @FXML
    void modifyEvent(ActionEvent event) {

        conference.setDate(eventDate.getValue());
       try {
        conference.setCapaciteMax(Integer.parseInt(eventCapacity.getText()));
       } catch (Exception e) {
        alertLabel.setText("Capacity must be an integer");
       }
       conference.setNom(eventName.getText());
       conference.setTheme(eventTheme.getText());


       alertLabel.setText("Conference details modified");
      
        
    }
    void initialize(Event event,Scene previouScene){
        this.conference=(Conference)event;
        this.previouScene=previouScene;
       
        setFields();
        intializeTable();


    }
    void setFields(){

        eventName.setText(conference.getNom());
        eventDate.setValue(conference.getDate());
        eventCapacity.setText(Integer.toString(conference.getCapaciteMax()));
        eventTheme.setText(conference.getTheme());
        
    }
    void intializeTable(){
        intervEmail.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getEmail()));
        intervName.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getNom()));;
        IntervID.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getId()));
        ObservableList myIntervenant=FXCollections.observableArrayList(conference.getIntervenants());
        intervTable.setItems(myIntervenant);
    }

}
