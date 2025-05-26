package com.example.Controllers;

import com.example.BaseClasses.Concert;
import com.example.BaseClasses.Event;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class concertUIController {
    Concert concert;
   
    Scene previouScene;
    @FXML
    private Label alertLabel;

    @FXML
    private TextField concertArtist;

    @FXML
    private TextField concertCapacity;

    @FXML
    private DatePicker concertDate;

    @FXML
    private TextField concertGenre;

    @FXML
    private TextField concertName;

    @FXML
    void goBack(ActionEvent event) {
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(previouScene);
    }

    @FXML
    void modifyConcert(ActionEvent event) {
        concert.setArtiste(concertArtist.getText());
        concert.setCapaciteMax(Integer.parseInt(concertCapacity.getText()));
        concert.setDate(concertDate.getValue());
        concert.setGenreMusical(concertGenre.getText());
        concert.setNom(concertName.getText());
        alertLabel.setText("Concert Details Modified");
       
    }

    void initialize(Event event,Scene previousScene){
        concert=(Concert)event;
       
        this.previouScene=previousScene;
        setFields();
    }
    void setFields(){
        concertArtist.setText(concert.getArtiste());
        concertCapacity.setText(Integer.toString(concert.getCapaciteMax()));
        concertDate.setValue(concert.getDate());
        concertName.setText(concert.getNom());
        concertGenre.setText(concert.getGenreMusical());

    }

}
