package com.example.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.BaseClasses.Concert;
import com.example.BaseClasses.Event;
import com.example.BaseClasses.Participant;
import com.example.Services.GestionEvenement;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class showEventsController {
    Scene previouScene;
    @FXML
    private TableColumn<Event, String> eventID;

    @FXML
    private TableColumn<Event, String> eventName;

    @FXML
    private TableColumn<Event,Integer> eventCapacite;

    @FXML
    private TableColumn<Event,String> eventDate;

    

    @FXML
    private TableColumn<Event,String> eventType;
    @FXML
    private TableView<Event> eventTable;

    @FXML
    void goBack(ActionEvent event){
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(previouScene);
    }

    @FXML
    void selectEvent(ActionEvent event) {
        //get the current selected table view row
        Event selectedEvent=eventTable.getSelectionModel().getSelectedItem();
        if(selectedEvent!=null){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/eventOptions.fxml"));
       try {

        Parent parent=loader.load();
        //get and previous scene to ease navigation
        Scene previouScene=((Node) event.getSource()).getScene();
        eventOptions controller=loader.getController();
        controller.initialize(selectedEvent,previouScene);
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
       } catch (Exception e) {
       e.printStackTrace();
       }

        }
    }

    void fillTable(){
        eventID.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getId()));
        eventName.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getNom()));
        eventDate.setCellValueFactory(celldata->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
             String date=celldata.getValue().getDate().format(formatter);
           return new SimpleObjectProperty<>(date);
        });
        eventType.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getClass().getSimpleName()));
        eventCapacite.setCellValueFactory(celldata->new SimpleObjectProperty<>(Integer.valueOf(celldata.getValue().getCapaciteMax())));


        ObservableList<Event> myEvents=FXCollections.observableArrayList(GestionEvenement.getGestionEvenement().getEvents());
        eventTable.setItems(myEvents);

        CompletableFuture<Void> future=new CompletableFuture<>();
        future.runAsync(()->{
            Timeline refresher = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> eventTable.refresh())
        );
        refresher.setCycleCount(Timeline.INDEFINITE);
        refresher.play();
        });
         
    }
    
    void initialize(Scene previousScene){
        this.previouScene=previousScene;
    }

}
