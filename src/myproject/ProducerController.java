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
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author lim
 */

public class ProducerController implements Initializable {
@FXML
private AnchorPane rootPane;

 Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(3000));
        ft.setNode(rootPane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play(); 
        ft.setOnFinished(eve->{
            FadeTransition ft2=new FadeTransition();
        ft2.setDuration(Duration.millis(3000));
        ft2.setNode(rootPane);
        ft2.setFromValue(1);
        ft2.setToValue(0);
        ft2.play(); 
        ft2.setOnFinished(e->{
             try{
       Parent home=FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene hone=new Scene(home);
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setScene(hone);
        stage.show();
         stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
        }
        catch(IOException a){
            
        } 
        });
             
        });
    }    
    
}
