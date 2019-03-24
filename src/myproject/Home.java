/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author lim
 */
public class Home implements Initializable {
  Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
   @FXML
   private AnchorPane rootPane;
   @FXML private Label child;
   @FXML private Label adult;
   @FXML private Button Bchild;
   @FXML private Button Badult;
   @FXML private ImageView evee;
   @FXML private ImageView sao;
   public Stage stage;
  
    @FXML
    private void child(ActionEvent event) throws IOException{
        
        FadeTransition childFade=new FadeTransition();
        childFade.setDuration(Duration.millis(1000));
        childFade.setNode(Badult);
        childFade.setFromValue(1);
        childFade.setToValue(0);
        childFade.play();
        childFade.setOnFinished(e->{
            evee.setVisible(true);
        FadeTransition childFadeout=new FadeTransition();
        childFadeout.setDuration(Duration.millis(1000));
        childFadeout.setNode(evee);
        childFadeout.setFromValue(0);
        childFadeout.setToValue(1);
        childFadeout.play();
        childFadeout.setOnFinished(ev->{
             TranslateTransition tt=new TranslateTransition();
            tt.setDuration(Duration.seconds(1));
            tt.setNode(child);
            tt.setToX(164);
            tt.play();
             tt.setOnFinished(even->{
               FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(rootPane);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play(); 
        ft.setOnFinished(eve->{
           
              try{
       Parent home=FXMLLoader.load(getClass().getResource("childHome.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(hone);
        stage.show();
         stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
        }
        catch(IOException a){
            
        } 
        });
            });
        
        });
        });
        
        
      
        
      
 }
    @FXML
    private void childEnter(){
        
          FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(child);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play(); 
    }
    @FXML
    private void childExit(){
        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(child);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play(); 
    }
    @FXML
    private void adultEnter(){
          FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(adult);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play(); 
    }
    @FXML
    private void adultExit(){
        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(adult);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play(); 
    }
 @FXML
 private void adult(ActionEvent event) throws IOException{
     FadeTransition childFade=new FadeTransition();
     
        childFade.setDuration(Duration.millis(1000));
        childFade.setNode(Bchild);
        childFade.setFromValue(1);
        childFade.setToValue(0);
        childFade.play();
        childFade.setOnFinished(e->{
           sao.setVisible(true);
        FadeTransition childFadeout=new FadeTransition();
        childFadeout.setDuration(Duration.millis(1000));
        childFadeout.setNode(sao);
        childFadeout.setFromValue(0);
        childFadeout.setToValue(1);
        childFadeout.play();
        childFadeout.setOnFinished(ev->{
             TranslateTransition tt=new TranslateTransition();
            tt.setDuration(Duration.seconds(1));
            tt.setNode(adult);
            tt.setToX(-210);
            tt.play();
             tt.setOnFinished(even->{
               FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(rootPane);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play(); 
        ft.setOnFinished(eve->{
           
              try{
       Parent home=FXMLLoader.load(getClass().getResource("Special.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(hone);
        stage.show();
         stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
        }
        catch(IOException a){
            
        } 
        });
            });
        
        });
        }); 
 }
   
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sao.setVisible(false);
       evee.setVisible(false);
        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(rootPane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play(); 
    }    
}

