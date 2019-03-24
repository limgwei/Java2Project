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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author lim
 */
/*
        
            */
public class SpecialController implements Initializable {
@FXML private AnchorPane rootPane;
@FXML private Button recoveryButton;
@FXML private Label yeah;
@FXML private Label a1;
@FXML private Label a2;
@FXML private Label a3;
@FXML private Label a4;
@FXML private Label a5;
@FXML private Label a6;
@FXML private Label a7;
@FXML private Label a8;
@FXML private Label a9;
@FXML private Label a10;
@FXML private Label b1;
@FXML private Label b2;
@FXML private Label b3;
@FXML private Label b4;
@FXML private Label b5;
@FXML private Label b6;
@FXML private Label b7;
@FXML private Label b8;
@FXML private Label b9;
@FXML private Label b10;
@FXML private Label c1;
@FXML private Label c2;
@FXML private Label c3;
@FXML private Label c4;
@FXML private Label c5;
@FXML private Label c6;
@FXML private Label c7;
@FXML private Label c8;
@FXML private Label c9;
@FXML private Label c10;
@FXML private TextField ans1;
@FXML private TextField ans2;
@FXML private TextField ans3;
@FXML private TextField ans4;
@FXML private TextField ans5;
@FXML private TextField ans6;
@FXML private TextField ans7;
@FXML private TextField ans8;
@FXML private TextField ans9;
@FXML private TextField ans10;
@FXML private GridPane gridpane;
@FXML final private List<Label> Labelist=new ArrayList<Label>();
@FXML final private List<Label> Labelist2=new ArrayList<Label>();
@FXML final private List<TextField> Labelist3=new ArrayList<TextField>();
@FXML final private List<Label> Labelist4=new ArrayList<Label>();
static int count=0;
static int countc=0;
static int counte=0;
@FXML private Button attack;
@FXML private Button skill;
@FXML private Label countdown;
@FXML private Rectangle hp;
@FXML private Rectangle mana;
@FXML private Rectangle bosshp;
@FXML private Label damage;
@FXML private ImageView zero;
@FXML private ImageView one;
@FXML private Label bosshpLabel;
static int  bossh=100;
static int h=100;
static int man=20;
@FXML private Label hpLabel;
@FXML private Label manaLabel;
private int ba=9;
static int angry=0;
@FXML ImageView skillPic;
@FXML GridPane forskill;
static int doubleattack1=1;
static int doubledefend=0;
static int countdefend=0;
@FXML Label turn;
@FXML ImageView defendup;
@FXML ImageView attackup;
final int crit=30;
@FXML Label critical;
@FXML Label cover;
@FXML ImageView congrats;
@FXML Button back;
static double Durations=2;
static int countDurations=0;
@FXML Button closeSkill;
@FXML Button ds;
    Thread background=new Thread();
    File f1=new File("D:/NetBeansProjects/MyProject/src/myproject/Gif/dragon.gif");
        Image dragon=new Image(f1.toURI().toString());
        File f2=new File("D:/NetBeansProjects/MyProject/src/myproject/image/recovery.jpg");
        Image recovery=new Image(f2.toURI().toString());
        File f3=new File("D:/NetBeansProjects/MyProject/src/myproject/image/doubleattack.png");
        Image doubleattack=new Image(f3.toURI().toString());
        File f4=new File("D:/NetBeansProjects/MyProject/src/myproject/image/defend.jpg");
        Image defend=new Image(f4.toURI().toString());
        File f5=new File("D:/NetBeansProjects/MyProject/src/myproject/image/defend.png");
        Image defendup1=new Image(f5.toURI().toString());
        File f6=new File("D:/NetBeansProjects/MyProject/src/myproject/image/attack.png");
        Image attackup1=new Image(f6.toURI().toString());
        File f7=new File("D:/NetBeansProjects/MyProject/src/myproject/Gif/cry4.gif");
        Image losing=new Image(f7.toURI().toString());
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        public Stage stage;
        MediaPlayer note1=new MediaPlayer(new Media(this.getClass().getResource("sound/special.mp3").toString()));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        closeSkill.setVisible(false);
        Durations=2;
        countDurations=0;
        cover.setVisible(false);
        count=0;
        counte=0;
        countc=0;
        bossh=100;
        h=100;
        man=20;
        ba=9;
        angry=0;
        doubleattack1=1;
        doubledefend=0;
        countdefend=0;
        countdown.setVisible(false);
         Labelist.add(a1);
    Labelist.add(a2);
    Labelist.add(a3);
    Labelist.add(a4);
    Labelist.add(a5);
    Labelist.add(a6);
    Labelist.add(a7);
    Labelist.add(a8);
    Labelist.add(a9);
    Labelist.add(a10);
    Labelist4.add(c1);
    Labelist4.add(c2);
    Labelist4.add(c3);
    Labelist4.add(c4);
    Labelist4.add(c5);
    Labelist4.add(c6);
    Labelist4.add(c7);
    Labelist4.add(c8);
    Labelist4.add(c9);
    Labelist4.add(c10);
    
    Labelist2.add(b1);
    Labelist2.add(b2);
    Labelist2.add(b3);
    Labelist2.add(b4);
    Labelist2.add(b5);
    Labelist2.add(b6);
    Labelist2.add(b7);
    Labelist2.add(b8);
    Labelist2.add(b9);
    Labelist2.add(b10);
    Labelist3.add(ans1);
    Labelist3.add(ans2);
    Labelist3.add(ans3);
    Labelist3.add(ans4);
    Labelist3.add(ans5);
    Labelist3.add(ans6);
    Labelist3.add(ans7);
    Labelist3.add(ans8);
    Labelist3.add(ans9);
    Labelist3.add(ans10);
    gridpane.setVisible(false);
    damage.setVisible(false);
    forskill.setVisible(false);
    critical.setVisible(false);
    FadeTransition ft=new FadeTransition(Duration.seconds(2),rootPane);
    ft.setFromValue(0);
    ft.setToValue(1);
    ft.play();
    
    note1.play();
    note1.setCycleCount(MediaPlayer.INDEFINITE);
    }
@FXML
private void attack(){
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    if(man==20){
    }
    else{
        man+=2;
    }
    if(man>20){
        man=20;
    }
    ScaleTransition st3=new ScaleTransition();
    manaLabel.setText(man+"");
    st3.setNode(mana);
    st3.setDuration(Duration.seconds(Durations));
    double mm=man/20.00;
    st3.setToX(mm);
    st3.play();
if(man>=5){
        skill.setDisable(false);
    }
  set();
  startTask();
  countdown.setVisible(true);
   gridpane.setOnKeyPressed(e->{
       if(e.getCode().equals(KeyCode.ENTER)){
           
           if(count>=9){
                int a=Integer.parseInt(Labelist.get(count).getText());
               int b=Integer.parseInt(Labelist4.get(count).getText());
               String ans="";
               if(Labelist2.get(count).getText().equals("+")){
                   ans=String.valueOf(a+b);
               }
               else if(Labelist2.get(count).getText().equals("-")){
                   ans=String.valueOf(a-b);
               }
          
           if(Labelist3.get(count).getText().equals(ans)){
               countc++;
           }
               startTask_damage();
                
             background.stop();
               gridpane.setVisible(false);
               menuClose();
               countdown.setVisible(false);
               
           }
           else{
               counte++;
           for(int i=0;i<Labelist3.size();i++){
               Labelist3.get(i).setEditable(false);
           }
           Labelist3.get(counte).setEditable(true);
               int a=Integer.parseInt(Labelist.get(count).getText());
               int b=Integer.parseInt(Labelist4.get(count).getText());
               String ans="";
               if(Labelist2.get(count).getText().equals("+")){
                   ans=String.valueOf(a+b);
               }
               else if(Labelist2.get(count).getText().equals("-")){
                   ans=String.valueOf(a-b);
               }
          
           if(Labelist3.get(count).getText().equals(ans)){
               countc++;
           }
           count++;
         Labelist3.get(count).requestFocus();
           }
       }
   });
   }

private void set(){
    count=0;
    countc=0;
    counte=0;
    ds.setVisible(false);
    gridpane.setVisible(true);
    ans1.requestFocus();
  attack.setVisible(false);
  skill.setVisible(false);
     for(int i=0;i<Labelist3.size();i++){
       Labelist3.get(i).setText("");
   }
  for(int i=0;i<Labelist.size();i++){
       int a=(int)(Math.random()*10);
       Labelist.get(i).setText(a+"");
   }
   for(int i=0;i<Labelist2.size();i++){
       int a=(int)(Math.random()*2);
       char[]chara={'+','-'};
       Labelist2.get(i).setText(chara[a]+"");
   }
   for(int i=0;i<Labelist4.size();i++){
       int a=(int)(Math.random()*10);
       Labelist4.get(i).setText(a+"");
   }
   for(int i=0;i<Labelist3.size();i++){
               Labelist3.get(i).setEditable(false);
           }
           Labelist3.get(counte).setEditable(true);
}
@FXML
private void skill(){
    closeSkill.setVisible(true);
    forskill.setVisible(true);
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    if(h>=100){
        recoveryButton.setDisable(true);
    }
    else{
        recoveryButton.setDisable(false);
    }
}
private void startTask(){
     countc=0;
    Runnable task=new Runnable(){
        public void run(){
            runTask();
        }
    };
    background=new Thread(task);
    background.setDaemon(true);
    background.start();
    
}
private void runTask(){
   
    for(int i=25;i>=0;i--){
        try{
            	final String status =  i + "";

				// Update the Label on the JavaFx Application Thread
				Platform.runLater(new Runnable()
				{  
                                    @Override
		            public void run()
		            {
                            countdown.setText(status);

		            }
                            
		        });			

				Thread.sleep(1000);
        }
       	catch (InterruptedException e)
      {
	e.printStackTrace();
       }
           
    }
   
    
    Platform.runLater(() -> {
       startTask_damage();
    });
ds.setVisible(true);
  menuClose();
 countdown.setVisible(false);
  gridpane.setVisible(false);
        background.stop();
}
private void startTask_damage(){
    Runnable task=new Runnable(){
        public void run(){
            runTask_damage();
        }
    };
    Thread bd=new Thread(task);
    bd.setDaemon(true);
    bd.start();
}
private void runTask_damage(){
    damage.setVisible(true);
    for(int i=30;i>=0;i--){
      try{
       int a=(int)(Math.random()*10);
       Platform.runLater(()->{
           damage.setText(String.valueOf(a));
       });
       Thread.sleep(50);
    }
      
    catch(InterruptedException e){
        e.printStackTrace();
    }  
    }
    Platform.runLater(()->{
       displayDamage();
    });
    
}
private void displayDamage(){
    
    int a=(int)(Math.random()*101);
    if(a<crit){
        doubleattack1*=2;
    }
      damage.setText(String.valueOf(countc*doubleattack1)) ;
      FadeTransition ft=new FadeTransition();
      ft.setNode(damage);
      ft.setDuration(Duration.seconds(Durations));
      ft.setFromValue(0);
      ft.setToValue(1);
      ft.play();
      ft.setOnFinished(e->{
          if(a<crit){
              critical.setVisible(true);
          }
          FadeTransition ft2=new FadeTransition();
           ft2.setNode(damage);
         ft2.setDuration(Duration.seconds(Durations));
         ft2.setFromValue(1);
         ft2.setToValue(0);
         ft2.play();
         ft2.setOnFinished(ev->{
             critical.setVisible(false);
             damage.setOpacity(1);
              damage.setVisible(false);
              TranslateTransition tt=new TranslateTransition();
              tt.setNode(zero);
              tt.setToX(516);
              tt.setDuration(Duration.seconds(Durations));
             tt.setAutoReverse(true);
              tt.setCycleCount(2);
              tt.play();
              tt.setOnFinished(eve->{
                 bossh-=countc*doubleattack1;
                 if(bossh<=0){
                     bossDie();
                 }
                 else{
                     bosshpLabel.setText(String.valueOf(bossh));
                      ScaleTransition st=new ScaleTransition();
                 st.setNode(bosshp);
                 st.setDuration(Duration.seconds(Durations));
                 double hh=bossh/100.00;
                st.setToX(hh);
                 st.play();
                 st.setOnFinished(even->{
                    bossAttack();
                 });
                 }
                
              });
         });
      });
     
    }
private void bossAttack(){
    attackup.setImage(null);
    doubleattack1=1;
    if(bossh<=30&&angry==0){
        angry++;
        ba*=2;
        ScaleTransition bossangry=new ScaleTransition();
                 bossangry.setNode(one);
                 bossangry.setDuration(Duration.seconds(Durations));
                bossangry.setToX(2);
                bossangry.setToY(2);
                bossangry.play();
                bossangry.setOnFinished(e->{
                     TranslateTransition tt2=new TranslateTransition();
              tt2.setNode(one);
              tt2.setToX(-516);
              tt2.setDuration(Duration.seconds(Durations));
             tt2.setAutoReverse(true);
              tt2.setCycleCount(2);
              tt2.play();
              tt2.setOnFinished(ev->{
                  menuDisplay();
                  h-=ba-doubledefend;
                  if(h<=0){
                      h=0;
                        hpLabel.setText(String.valueOf(0));
                 ScaleTransition st2=new ScaleTransition();
                 st2.setNode(hp);
                 st2.setDuration(Duration.seconds(Durations));
                 congrats.setImage(losing);
                 yeah.setText("We lose");
                st2.setToX(0);
                 st2.play();
                 st2.setOnFinished(eve->{
                     ending();
                 });
                 }
                  else{
                             hpLabel.setText(String.valueOf(h));
                 ScaleTransition st2=new ScaleTransition();
                 st2.setNode(hp);
                 st2.setDuration(Duration.seconds(Durations));
                 double hh2=h/100.00;
                st2.setToX(hh2);
                 st2.play();
                 st2.setOnFinished(eve->{
         if(doubledefend>0){
        countdefend--;
        turn.setText(countdefend+"");
    }
    if(countdefend==0){
        doubledefend=0;
        turn.setText("");
        defendup.setImage(null);
    } 
    
    
                 });
                  }
               
              });
                });
                
    }
    else{TranslateTransition tt2=new TranslateTransition();
              tt2.setNode(one);
              tt2.setToX(-516);
              tt2.setDuration(Duration.seconds(Durations));
             tt2.setAutoReverse(true);
              tt2.setCycleCount(2);
              tt2.play();
              tt2.setOnFinished(e->{
                  menuDisplay();
                  h-=ba-doubledefend;
                  if(h<=0){
                      h=0;
                        hpLabel.setText(String.valueOf(0));
                 ScaleTransition st2=new ScaleTransition();
                 st2.setNode(hp);
                 st2.setDuration(Duration.seconds(Durations));
                 congrats.setImage(losing);
                 yeah.setText("We lose");
                st2.setToX(0);
                 st2.play();
                 st2.setOnFinished(eve->{
                     ending();
                 });
                 }
                  else{
                       hpLabel.setText(String.valueOf(h));
                 ScaleTransition st2=new ScaleTransition();
                 st2.setNode(hp);
                 st2.setDuration(Duration.seconds(Durations));
                 double hh2=h/100.00;
                st2.setToX(hh2);
                 st2.play();
                 st2.setOnFinished(ev->{
                    if(doubledefend>0){
        countdefend--;
        turn.setText(countdefend+"");
    }
    if(countdefend==0){
        doubledefend=0;
        turn.setText("");
        defendup.setImage(null);
    } 
                 });
                  }
                
              });
}}
private void bossDie(){
    note1.stop();
     bosshpLabel.setText(String.valueOf(0));
    ScaleTransition st=new ScaleTransition();
    st.setNode(bosshp);
    st.setDuration(Duration.seconds(Durations));
    st.setToX(0);
    st.play();
    st.setOnFinished(e->{
       RotateTransition rt=new RotateTransition(); 
       rt.setNode(one);
       rt.setDuration(Duration.seconds(Durations));
       rt.setFromAngle(360);
       rt.setToAngle(270);
       rt.play();
       rt.setOnFinished(ev->{
           if(h<=10){
                    AudioClip note=new AudioClip(this.getClass().getResource("sound/warning.wav").toString());
               note.setCycleCount(2);
               note.play();
                  damage.setVisible(true);
                  damage.setText("Warning");
            FadeTransition ft=new FadeTransition(Duration.seconds(1),damage);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setAutoReverse(true);
            ft.setCycleCount(6);
            ft.play();
            ft.setOnFinished(eve->{
                FadeTransition ft2=new FadeTransition(Duration.seconds(2),rootPane);
                ft2.setFromValue(1);
                ft2.setToValue(0);
                ft2.play();
                ft2.setOnFinished(even->{
                 try{
            
       Parent home=FXMLLoader.load(getClass().getResource("SpecialExtend.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)rootPane.getScene().getWindow();
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
            else{
               ending();
      AudioClip note=new AudioClip(this.getClass().getResource("sound/win(special).wav").toString());
      note.play();
           }
       });
    });
}
@FXML private void dragon(){
    closeSkill.setVisible(false);
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    menuClose();
    skillPic.setImage(dragon);
    FadeTransition ft=new FadeTransition();
    ft.setNode(skillPic);
    ft.setDuration(Duration.seconds(Durations));
    ft.setFromValue(0);
    ft.setToValue(1);
    ft.play();
    ft.setOnFinished(e->{
       TranslateTransition tt=new TranslateTransition();
        tt.setNode(skillPic);
    tt.setDuration(Duration.seconds(Durations));
    
    tt.setToX(1000);
    tt.play();
   tt.setOnFinished(ev->{
       
      skillPic.setOpacity(0);
       bossh-=7;
      if(bossh<=0){
          bossDie();
      }
            else{
       bosshpLabel.setText(String.valueOf(bossh));
       ScaleTransition st=new ScaleTransition();
       st.setNode(bosshp);
       st.setDuration(Duration.seconds(Durations));
       double hh=bossh/100.00;
       st.setToX(hh);
       st.play();   
      }
       
       TranslateTransition tt2=new TranslateTransition();
        tt2.setNode(skillPic);
    tt2.setDuration(Duration.seconds(Durations));
    
    tt2.setToX(0);
    tt2.play();
    tt2.setOnFinished(eve->{
        menuDisplay();
    });
   });
    });
     forskill.setVisible(false);
    manacost();
    if(man<5){
             skill.setDisable(true);
        
         }
}
@FXML private void defend(){
    closeSkill.setVisible(false);
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    skillPic.setImage(defend);
    FadeIn();
     forskill.setVisible(false);
     doubledefend=7;
     countdefend=2;
     defendup.setImage(defendup1);
     turn.setText(countdefend+"");
     manacost();
     if(man<5){
             skill.setDisable(true);
         }
}
@FXML private void recovery(){
    closeSkill.setVisible(false);
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    menuClose();
        skillPic.setImage(recovery);
         FadeTransition ft=new FadeTransition();
    ft.setNode(skillPic);
    ft.setDuration(Duration.seconds(Durations));
    ft.setFromValue(0);
    ft.setToValue(1);
    ft.play();
    ft.setOnFinished(e->{
        FadeTransition ft2=new FadeTransition();
    ft2.setNode(skillPic);
    ft2.setDuration(Duration.seconds(Durations));
    ft2.setFromValue(1);
    ft2.setToValue(0);
    ft2.play();
    ft2.setOnFinished(ev->{
       menuDisplay();
        h+=20;
        if(h>100){
            h=100;
        }
       hpLabel.setText(String.valueOf(h));
       ScaleTransition st=new ScaleTransition();
       st.setNode(hp);
       st.setDuration(Duration.seconds(Durations));
       double hh=h/100.00;
       st.setToX(hh);
       st.play();
       
    });
    });
         forskill.setVisible(false);
         manacost();
         if(man<5){
             skill.setDisable(true);
         }
}
@FXML private void doubleattack(){
    closeSkill.setVisible(false);
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    skillPic.setImage(doubleattack);
    FadeIn();
    forskill.setVisible(false);
    doubleattack1*=2;
    attackup.setImage(attackup1);
    manacost();
    if(man<5){
             skill.setDisable(true);
         }
}
private void FadeIn(){
    FadeTransition ft=new FadeTransition();
    ft.setNode(skillPic);
    ft.setDuration(Duration.seconds(Durations));
    ft.setFromValue(0);
    ft.setToValue(1);
    ft.play();
    ft.setOnFinished(e->{
        FadeTransition ft2=new FadeTransition();
    ft2.setNode(skillPic);
    ft2.setDuration(Duration.seconds(Durations));
    ft2.setFromValue(1);
    ft2.setToValue(0);
    ft2.play();
    ft2.setOnFinished(ev->{
    menuDisplay();
    });
    });
}
private void manacost(){
    man-=5;
    ScaleTransition st=new ScaleTransition();
    manaLabel.setText(man+"");
    st.setNode(mana);
    st.setDuration(Duration.seconds(Durations));
    double mm=man/20.00;
    st.setToX(mm);
    st.play();
}
@FXML private void ending(){
      cover.setVisible(true);
        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(Durations));
        ft.setNode(congrats);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        FadeTransition ft2=new FadeTransition();
        ft2.setDuration(Duration.millis(Durations));
        ft2.setNode(yeah);
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ft2.play(); 
        FadeTransition ft3=new FadeTransition();
        ft3.setDuration(Duration.millis(Durations));
        ft3.setNode(back);
        ft3.setFromValue(0);
        ft3.setToValue(1);
        ft3.play();
        note1.stop();
}
@FXML private void back(ActionEvent event)throws IOException {
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
   try{
            
       Parent home=FXMLLoader.load(getClass().getResource("Producer.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(hone);
        stage.show();
        stage.setX(d.width/2-(stage.getWidth()/2));
        stage.setY(d.height/2-(stage.getHeight()/2));
        }
        catch(IOException a){
            
        }
}
@FXML private void doubleSpeed(){
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
if(countDurations==0){
    Durations=1;
    countDurations++;
    ds.setText("Speed(2)");
    
}
else if(countDurations==1){
     Durations=0.5;
     countDurations++;
     ds.setText("Speed(4)");
}
else if(countDurations==2){
    Durations=2;
    countDurations=0;
    ds.setText("Speed(1)");
}
}
private void menuDisplay(){
    attack.setVisible(true);
    skill.setVisible(true);
    ds.setVisible(true);
}
private void menuClose(){
    attack.setVisible(false);
    skill.setVisible(false);
    ds.setVisible(false);
}
@FXML private void closeskill(){
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    note.play();
    closeSkill.setVisible(false);
    forskill.setVisible(false);
}
}
 