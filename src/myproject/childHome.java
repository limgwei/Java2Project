/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author lim
 */
public class childHome implements Initializable{
    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView cloud;
   @FXML
   private Label cover;
   @FXML
   private Button easy;
   @FXML
   private Button hard;
   
     @FXML
    private void start(ActionEvent event) throws IOException{
        cover.setVisible(true);
        easy.setVisible(true);
        hard.setVisible(true);
         
    }
    @FXML
    private void easy(ActionEvent event)throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("Easy.fxml"));
         Scene scene=new Scene(root);
         Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         stage.setScene(scene);
          stage.centerOnScreen();
         stage.show();
         stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
    }
    @FXML private void hard(ActionEvent event)throws IOException{
       
    Parent root=FXMLLoader.load(getClass().getResource("MathQuiz2.fxml"));
         Scene scene=new Scene(root);
         Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         stage.setScene(scene);
          stage.centerOnScreen();
         stage.show();
         stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
    }
    @FXML private void exit(ActionEvent event)throws IOException{
         Parent root=FXMLLoader.load(getClass().getResource("Home.fxml"));
         Scene scene=new Scene(root);
         Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         stage.setScene(scene);
          stage.centerOnScreen();
         stage.show();
         stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
    }
           
    @Override
     public void initialize(URL url, ResourceBundle rb) {
        rootPane.setOpacity(0);
       makeFadeInTransition();
       TranslateTransition transition=new TranslateTransition();
        transition.setNode(cloud);
        transition.setDuration(Duration.seconds(5));
        transition.setToX(500);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
       
        transition.play();
        cover.setVisible(false);
        easy.setVisible(false);
        hard.setVisible(false);
    }
private void makeFadeInTransition(){
    FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(rootPane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play(); 
}    
}
