package com.example.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.BaseClasses.Event;
import com.example.BaseClasses.Participant;
import com.example.Exceptions.CapaciteMaxAtteinteException;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ManageParticpantsController {
    Scene previouScene; 
    Event event;
    @FXML
    private Label alertLabel;

    @FXML
    private TableColumn<Participant, String> partEmail;

    @FXML
    private TableColumn<Participant,String> partID;

    @FXML
    private TableColumn<Participant,String> partName;

    @FXML
    private TableView<Participant> partTable;

    @FXML
    void addParticpant(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/registerParticpant.fxml"));
        try {
            Parent root=loader.load();
            Scene scene=new Scene(root);
            //get controller
            RegisterParticpantController controller=loader.getController();
            Scene previouScene=((Node) event.getSource()).getScene();
            controller.initialize(this.event, previouScene,this);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("Register Particpant");
            stage.show();


            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(previouScene);
    }

    @FXML
    void removeParticipant(ActionEvent event) {
        Participant participant=partTable.getSelectionModel().getSelectedItem();
        if(participant!=null){
            this.event.removeParticipant(participant);
            initializeTable();
        }
    }
    void initialize(Scene previouScene,Event event){
        this.event=event;
        this.previouScene=previouScene;
        initializeTable();
        
    }
    public void initializeTable(){
        partID.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getId()));
        partEmail.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getEmail()));
        partName.setCellValueFactory(celldata->new SimpleObjectProperty<>(celldata.getValue().getNom()));

       
        ObservableList myParticipants=FXCollections.observableArrayList(event.getParticipants());
        partTable.setItems(myParticipants);
    }

}
