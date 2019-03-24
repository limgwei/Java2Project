/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lim
 */
public class MathQuiz2Controller implements Initializable {
int proA,proB,proC,butA,butB,butC,butD,o,b,ans1,i;
		int count = 0;
		int sco = 0;
		public Stage stage;
		String t=new String("o");
		String f=new String("x");
Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       ;
        
        @FXML Label lblpro=new Label();
        @FXML Label lbltime=new Label();
        @FXML Label lblsco=new Label();
        @FXML Label lblque=new Label();
        @FXML Label lbla=new Label();
        @FXML Label lblb=new Label();
        @FXML Label lblc=new Label();
        @FXML Label lbld=new Label();
        @FXML Button btnstart=new Button("Start");
        @FXML Button but1=new Button();
        @FXML Button but2=new Button();
        @FXML Button but3=new Button();
        @FXML Button but4=new Button();
        @FXML Button exit=new Button("Exit");
         MediaPlayer note1=new MediaPlayer(new Media(this.getClass().getResource("sound/RingofFortune.mp3").toString()));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        note1.play();
        note1.setCycleCount(MediaPlayer.INDEFINITE);
        btnstart.setVisible(true);
        exit.setVisible(false);
        lblpro.setVisible(false);
        lbltime.setVisible(false);
        lblsco.setVisible(false);
        lblque.setVisible(false);
        but1.setVisible(false);
        but2.setVisible(false);
        but3.setVisible(false);
        but4.setVisible(false);
        lbla.setVisible(false);
        lblb.setVisible(false);
        lblc.setVisible(false);
        lbld.setVisible(false);
    }    
    @FXML private void btnstart(){
            btnstart.setVisible(false);
    		lblpro.setVisible(true);
    		lblsco.setVisible(true);
    		lbltime.setVisible(true);
    		lblque.setVisible(true);
    		but1.setVisible(true);
    		but2.setVisible(true);
    		but3.setVisible(true);
    		but4.setVisible(true);
    		exit.setVisible(false);
    		lbla.setVisible(false);
    		lblb.setVisible(false);
    		lblc.setVisible(false);
    		lbld.setVisible(false);
    		
    		getquestion();
    		startTask();
    }
    @FXML private void exit(ActionEvent event)throws IOException{
        try{
        	File f = new File("record.txt");
    		PrintWriter record = new PrintWriter(new FileWriter(f,true));
    		
    		Scanner s = new Scanner("Your score "+sco+"%");
    		while(s.hasNext()){
    			String out = s.nextLine();
    			record.println(out);
    		}
    		record.close();
    		s.close();
    	}catch(IOException ex){
    		JOptionPane.showMessageDialog(null,"I/O error.\nClosing program...");
    	}
        note1.stop();
         Parent home=FXMLLoader.load(getClass().getResource("childHome.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(hone);
        stage.show();
        stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));

    }
    @FXML private void but1(){
        if(butA==ans1){
        		sco = sco+5;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lbla.setVisible(true);
        		lbla.setText(t);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}else{
        		sco = sco;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lbla.setVisible(true);
        		lbla.setText(f);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}
    }
    @FXML private void but2(){
              	if(butB==ans1){
        		sco = sco+5;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lblb.setVisible(true);
        		lblb.setText(t);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}else{
        		sco = sco;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lblb.setVisible(true);
        		lblb.setText(f);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}
    }
    @FXML private void but3(){
        if(butC==ans1){
        		sco = sco+5;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lblc.setVisible(true);
        		lblc.setText(t);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}else{
        		sco = sco;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lblc.setVisible(true);
        		lblc.setText(f);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}
    }
    @FXML private void but4(){
        	if(butD==ans1){
        		sco = sco+5;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lbld.setVisible(true);
        		lbld.setText(t);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}else{
        		sco = sco;
        		lblsco.setText(String.valueOf(sco)+"%");
        		i=2;
        		lbld.setVisible(true);
        		lbld.setText(f);
        		but1.setDisable(true);
    			but2.setDisable(true);
    			but3.setDisable(true);
    			but4.setDisable(true);
        	}
    }
    public void startTask(){
	// Create a Runnable
	Runnable task = new Runnable(){
            public void run(){
			for(i = 10; i >=0; i--){
            try{
		// Get the Status
		final String status = "" + i ;
                // Update the Label on the JavaFx Application Thread
			Platform.runLater(new Runnable(){
		    	public void run(){
		        	lbltime.setText(status);
		    	}
	        });			
            Thread.sleep(1000);
            }catch (InterruptedException e){
				e.printStackTrace();
            }
			}
			Platform.runLater(() -> {
                	getquestion();
                	startTask();
                });
            }
	};

	// Run the task in a background thread
	Thread backgroundThread = new Thread(task);
	// Terminate the running thread if the application exits
	backgroundThread.setDaemon(true);
	// Start the thread
	backgroundThread.start();
	}
    public void runTask(){
	
    }
     public void getquestion(){
    	but1.setDisable(false);
    	but2.setDisable(false);
    	but3.setDisable(false);
    	but4.setDisable(false);
    	lbla.setVisible(false);
    	lblb.setVisible(false);
    	lblc.setVisible(false);
    	lbld.setVisible(false);
    	
    	proA = (int)(1+Math.random()*101);
        proB = (int)(1+Math.random()*101);
        proC = (int)(1+Math.random()*11);
        o = (int)(1+Math.random()*4);
        b = (int)(1+Math.random()*4);
        ans1 = 0;
    	if(count<20){
        
        if (o==0){
        	lblpro.setText("("+proA +"+"+proB+")*"+proC);
        }else if(o==1){
        	lblpro.setText("("+proA +"-"+proB+")*"+proC);
        }else if(o==2){
        	lblpro.setText(proA+"+"+proB+"*"+proC);
        }else{
        	lblpro.setText(proA+"-"+proB+"*"+proC);
        }
        
        if (o==0){
        	ans1 = (proA+proB)*proC;
        }else if(o==1){
        	ans1 = (proA-proB)*proC;
        }else if(o==2){
        	ans1 = proA+proB*proC;
        }else{
        	ans1 = proA-proB*proC;
        }
        
        if (b==0){
        	butA=ans1;
        	butB=ans1-11;
        	butC=ans1-10;
        	butD=ans1+10;
        	
        	but1.setText(String.valueOf(butA));
        	but2.setText(String.valueOf(butB));
        	but3.setText(String.valueOf(butC));
        	but4.setText(String.valueOf(butD));
        }else if(b==1){
        	butA=ans1+10;
        	butB=ans1;
        	butC=ans1-10;
        	butD=ans1+11;
        	
        	but1.setText(String.valueOf(butA));
        	but2.setText(String.valueOf(butB));
        	but3.setText(String.valueOf(butC));
        	but4.setText(String.valueOf(butD));
        }else if(b==2){
        	butA=ans1+11;
        	butB=ans1-10;
        	butC=ans1;
        	butD=ans1+10;
        	
        	but1.setText(String.valueOf(butA));
        	but2.setText(String.valueOf(butB));
        	but3.setText(String.valueOf(butC));
        	but4.setText(String.valueOf(butD));
        }else{
        	butA=ans1+10;
        	butB=ans1-11;
        	butC=ans1-10;
        	butD=ans1;
        	
        	but1.setText(String.valueOf(butA));
        	but2.setText(String.valueOf(butB));
        	but3.setText(String.valueOf(butC));
        	but4.setText(String.valueOf(butD));
        }
        count++;
        lblque.setText(String.valueOf(count)+"/20");
    	}
    	else{
    		lblpro.setVisible(true);
    		lblsco.setVisible(false);
    		lbltime.setVisible(false);
    		lblque.setVisible(false);
    		but1.setVisible(false);
    		but2.setVisible(false);
    		but3.setVisible(false);
    		but4.setVisible(false);
    		lbla.setVisible(false);
    		lblb.setVisible(false);
    		lblc.setVisible(false);
    		lbld.setVisible(false);
    		String result=new String();
        
        	if(sco>=80){
        		result="A";
        	}else if(sco>=60){
        		result="B";
        	}else if(sco>=40){
        		result="C";
        	}else{
        		result="F";
        	}
        
    		lblpro.setText("You get "+String.valueOf(sco)+"%\nYou are "+result);
    		exit.setVisible(true);
    	}
    	
    	
    }
}
