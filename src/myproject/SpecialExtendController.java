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
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author lim
 */
public class SpecialExtendController implements Initializable {
@FXML AnchorPane rootPane;
@FXML AnchorPane anchorPane;
@FXML GridPane skillGp;

@FXML Rectangle bosshpRectangle;
@FXML Rectangle hpRectangle;
@FXML Rectangle manaRectangle;
@FXML Rectangle heroAngryRectangle;

@FXML Button attack;
@FXML Button skill;
@FXML Button a;
@FXML Button b;
@FXML Button c;
@FXML Button d;
@FXML Button skillDragon;
@FXML Button skillRecover;
@FXML Button skillDefendUp;
@FXML Button skillAttackUp;
@FXML Button Ulti;
@FXML Button Speed;
@FXML Button closeSkill;

@FXML Label bosshpLabel;
@FXML Label hpLabel;
@FXML Label manaLabel;
@FXML Label CountDown;
@FXML Label damage;
@FXML Label Question;
@FXML Label DefendTurn;
@FXML Label BossTalking;
@FXML Label HeroTalk;

@FXML ImageView hero;
@FXML ImageView boss;
@FXML ImageView skillPic;
@FXML ImageView AttackUpImage;
@FXML ImageView DefendUpImage;
@FXML ImageView finalHit;


static int bosshp=100;
static int hp=100;
static int mana=20;
static int heroAngry=0;
static int turn=0;
static int bossSkill=0;
static int n1=0;
static int n2=0;
static int ans=0;
static int correctAns=0;
static final int crit=30;
static double Durations1=1;
static double Durations2=2;
static double Durations3=3;
static int countDurations=0;
static int defUp=0;
static int defTurn=0;
static int AtkUp=1;

Thread background=new Thread();
Thread bd=new Thread();
List<Button> Choice=new ArrayList<Button>();
public Stage stage;
Dimension dd= Toolkit.getDefaultToolkit().getScreenSize();
        File f9=new File("D:/NetBeansProjects/MyProject/src/myproject/image/boss.png");
        Image bossImage=new Image(f9.toURI().toString());
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
        File f7=new File("D:/NetBeansProjects/MyProject/src/myproject/image/BossHit.jpg");
        Image losing=new Image(f7.toURI().toString());
        File f8=new File("D:/NetBeansProjects/MyProject/src/myproject/image/Ultimate.jpg");
        Image win=new Image(f8.toURI().toString());
        MediaPlayer note1=new MediaPlayer(new Media(this.getClass().getResource("sound/final.mp3").toString()));
        File f10=new File("D:/NetBeansProjects/MyProject/src/myproject/image/heroJumping.png");
        Image heroImage=new Image(f10.toURI().toString());
        MediaPlayer note3=new MediaPlayer(new Media(this.getClass().getResource("sound/finalBattle.mp3").toString()));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
      FadeTransition ft=new FadeTransition(Duration.seconds(1),rootPane);
           ft.setFromValue(0);
           ft.setToValue(1);
           ft.play();
           ft.setOnFinished(e->{
               starting();
           });
     menuClose();
    
        finalHit.setVisible(false);
        
        closeSkill.setVisible(false);
        defTurn=0;
        AtkUp=1;
        defUp=0;
        skillGp.setVisible(false);
        Durations1=1;
        Durations2=2;
        Durations3=3;
        countDurations=0;
        Choice.add(a);
        Choice.add(b);
        Choice.add(c);
        Choice.add(d);
        // TODO
        bosshp=100;
        hp=100;
        mana=20;
        heroAngry=0;
        turn=0;
        bossSkill=0;
        ans=0;
        correctAns=0;
        anchorPane.setVisible(false);
        CountDown.setVisible(false);
        heroAngryRectangle.setVisible(false);
        Ulti.setVisible(false);
        Ulti.setDisable(true);
        damage.setVisible(false);
        
        
        
    }    
   @FXML private void attack(){
        startTask();
        menuClose();
        GetQuestionAndChoices();
        CountDown.setVisible(true);
        anchorPane.setVisible(true);
        correctAns=0;
        AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
    }
   @FXML private void start(ActionEvent e){
       String checkAnswer="";
        if(e.getSource().equals(a)){
            checkAnswer=a.getText();
        }
        else if(e.getSource().equals(b)){
            checkAnswer=b.getText();
        }
        else if(e.getSource().equals(c)){
            checkAnswer=c.getText();
        }
        else if(e.getSource().equals(d)){
            checkAnswer=d.getText();
        }
        if(checkAnswer.equals(String.valueOf(ans))){
            correctAns++;
        }
        GetQuestionAndChoices();
        AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
      
    }
   @FXML private void skill(){
       skillGp.setVisible(true);
       closeSkill.setVisible(true);
       if(hp==100){
           skillRecover.setDisable(true);
       }
       else if(turn>=4){
           skillRecover.setDisable(true);
       }
       else {
          skillRecover.setDisable(false); 
       }
       AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
   }
   @FXML private void speed(){
       if(countDurations==0){
           Durations1=0.5;
           Durations2=1;
           Durations3=1.5;
           countDurations++;
           Speed.setText("Speed(2)");
       }
       else if(countDurations==1){
           Durations1=0.25;
           Durations2=0.5;
           Durations3=0.75;
           countDurations++;
           Speed.setText("Speed(4)");
       }
       else if(countDurations==2){
           Durations1=1;
           Durations2=2;
           Durations3=3;
           countDurations=0;
           Speed.setText("Speed(1)");
       }
       AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
   }
   private void startTask(){
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
       for(int i=15;i>=0;i--){
           try{
               final String status=i+"";
               Platform.runLater(() -> {
                CountDown.setText(status);  
               });
               Thread.sleep(1000);
           }
           catch(InterruptedException e){
               e.printStackTrace();
           }
           
       }
       Platform.runLater(()->{
           damageTask();
          
       });
          
          anchorPane.setVisible(false);
          CountDown.setVisible(false);
          damage.setVisible(true);
          background.stop();
          
   }
   private void GetQuestionAndChoices(){
      int random=(int)(Math.random()*2);
      n1=(int)(Math.random()*21);
      n2=(int)(Math.random()*21);
      ans=0;
      String set="";
      if(random==0){
         set="+";
         ans=n1+n2;
      }
      else if(random==1){
          set="-";
          ans=n1-n2;
      }
      Question.setText(n1+set+n2+"=??");
      Collections.shuffle(Choice);
       Choice.get(0).setText(ans+"");
       Choice.get(1).setText((ans+1)+"");
       Choice.get(2).setText((ans-1)+"");
       Choice.get(3).setText((ans*2)+"");
      
   }
   private void damageTask(){
       Runnable task=new Runnable(){
         public void run(){
             runDamageTask();
         }  
       };
       Thread bd=new Thread(task);
       bd.setDaemon(true);
       bd.start();
   }
   private void runDamageTask(){
       damage.setOpacity(1);
       for(int i=30;i>=0;i--){
           try{
               int random=(int)(Math.random()*10);
            final String status=random+"";
            Platform.runLater(()->{
                damage.setText(status);
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
       damage.setText((correctAns*AtkUp)+"");
       FadeTransition FadeOut=new FadeTransition(Duration.seconds(Durations2),damage);
       FadeOut.setFromValue(0);
       FadeOut.setToValue(1);
       FadeOut.play();
       FadeOut.setOnFinished(e->{
       FadeTransition FadeIn=new FadeTransition(Duration.seconds(Durations2),damage);
       FadeIn.setFromValue(1);
       FadeIn.setToValue(0);
       FadeIn.play();
       FadeIn.setOnFinished(ev->{
       FadeTransition HeroFade=new FadeTransition(Duration.seconds(Durations1),hero);
       HeroFade.setFromValue(1);
       HeroFade.setToValue(0);
       HeroFade.play();
       HeroFade.setOnFinished(eve->{
       TranslateTransition HeroMovingTop=new TranslateTransition(Duration.seconds(0.001),hero);
       HeroMovingTop.setToY(-150);
       hero.setX(601);
       HeroMovingTop.play();
       FadeTransition HeroFadeOut=new FadeTransition(Duration.seconds(Durations1),hero);
       HeroFadeOut.setFromValue(0);
       HeroFadeOut.setToValue(1);
       HeroFadeOut.play();
       HeroFadeOut.setOnFinished(even->{
       TranslateTransition HeroMoving=new TranslateTransition(Duration.seconds(Durations1),hero);
       HeroMoving.setToY(0);
       HeroMoving.play();
       HeroMoving.setOnFinished(event->{
       bossHp();
       FadeTransition HeroFadeIn=new FadeTransition(Duration.seconds(Durations1),hero);
       HeroFadeIn.setFromValue(1);
       HeroFadeIn.setToValue(0);
       HeroFadeIn.play();
       HeroFadeIn.setOnFinished(event1->{
       hero.setX(0);
       FadeTransition HeroFadeOutAgain=new FadeTransition(Duration.seconds(Durations1),hero);
       HeroFadeOutAgain.setFromValue(0);
       HeroFadeOutAgain.setToValue(1);
       HeroFadeOutAgain.play();
       });
       });
       });
       });    
       });
       });
   }
   private void bossHp(){
       bosshp-=correctAns*AtkUp;
       if(bosshp<=0){
           bossRevive();
       }
       else{
       double hh=bosshp/100.0;
       bosshpLabel.setText(bosshp+"");
       ScaleTransition bossHp=new ScaleTransition(Duration.seconds(Durations3),bosshpRectangle);
       bossHp.setToX(hh);
       bossHp.play();
       bossHp.setOnFinished(e->{
       bossAttack(); 
       });
       }
       
       
   }
   private void bossAttack(){
       TranslateTransition HeroDragUp=new TranslateTransition(Duration.seconds(Durations1),hero);
       HeroDragUp.setToY(-100);
       HeroDragUp.play();
       
       RotateTransition bossRotate=new RotateTransition(Duration.seconds(Durations1),boss);
       bossRotate.setToAngle(45);
       bossRotate.play();
       HeroDragUp.setOnFinished(ev->{
       PauseTransition HeroStop=new PauseTransition(Duration.seconds(Durations1));
       HeroStop.play();
       HeroStop.setOnFinished(eve->{
       TranslateTransition HeroDragDown=new TranslateTransition(Duration.seconds(Durations1),hero);
       HeroDragDown.setToY(0);
       HeroDragDown.play();
       
       RotateTransition bossRotate2=new RotateTransition(Duration.seconds(Durations1),boss);
       bossRotate2.setToAngle(0);
       bossRotate2.play();
       
       HeroDragDown.setOnFinished(even->{
       heroAttacked(); 
       });
       });
       });
   }
   private void heroAttacked(){
       hp-=100-defUp;
       if(hp<=0){
           HeroDie();
       }
       else{
         double hh=hp/100.0;
       hpLabel.setText(hp+"");
       ScaleTransition Hp=new ScaleTransition(Duration.seconds(Durations2),hpRectangle);
       Hp.setToX(hh);
       Hp.play();
       Hp.setOnFinished(e->{
           if(mana==20){}
           else{
              mana+=2;
              if(mana>20){
                  mana=20;
              }
           manacost();
           if(mana>=5){
               skill.setDisable(false);
             skill.setOpacity(1);
           }
           }
           AtkUp=1;
           AttackUpImage.setImage(null);
           if(defTurn>0){
               defTurn--;
               DefendTurn.setText(defTurn+"");
           }
           if(defTurn==0){
               defUp=0;
              DefendUpImage.setImage(null);
              DefendTurn.setText("");
           }
           
           turn++;
           if(turn==2){
               BossSkill("SkillSeal");
           }
           else if(turn==3){
               skill.setDisable(false);
               skill.setOpacity(1);
               menuDisplay();
           }
           else if(turn==4){
               BossSkill("RecoverStole");
               skillRecover.setDisable(true);
              skillRecover.setOpacity(0.5);
           }
           else if(turn==6){
               BossSkill("Invincible");
              
           }
           else if(turn==7){
               AtkUp=1;
               menuDisplay();
           }
           else{
               menuDisplay();
           }
           
       });  
       }
       
   }
   private void menuDisplay(){
       
      attack.setVisible(true);
        skill.setVisible(true);
        Speed.setVisible(true);
  }
   private void menuClose(){
       attack.setVisible(false);
        skill.setVisible(false);
        Speed.setVisible(false);
   }
   private void manacost(){
     
       manaLabel.setText(mana+"");
      if(mana<5){
             skill.setDisable(true);
             skill.setOpacity(0.5);
         }
      else{
          skill.setDisable(false);
             skill.setOpacity(1);
      }
      ScaleTransition manaBurn=new ScaleTransition(Duration.seconds(Durations2),manaRectangle);
      double hh=mana/20.0;
      manaBurn.setToX(hh);
      manaBurn.play();
  }
   @FXML private void dragon(){
         mana-=5;
         closeSkill.setVisible(false);
    skillGp.setVisible(false);
    manacost();
    menuClose();
    skillPic.setImage(dragon);
    FadeTransition DragonShown=new FadeTransition(Duration.seconds(Durations1),skillPic);
    DragonShown.setFromValue(0);
    DragonShown.setToValue(1);
    DragonShown.play();
    DragonShown.setOnFinished(e->{
    TranslateTransition DragonMove=new TranslateTransition(Duration.seconds(Durations2),skillPic);
    DragonMove.setToX(1000);
    DragonMove.play();
    DragonMove.setOnFinished(ev->{
    skillPic.setOpacity(0);
    TranslateTransition DragonBack=new TranslateTransition(Duration.seconds(0.001),skillPic);
    DragonBack.setToX(0);
    DragonBack.play();
    dragonDamage();
    });
    });   
    AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
    
        note.play();
}
   @FXML private void recovery(){
       AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
         mana-=5;
         closeSkill.setVisible(false);
    skillGp.setVisible(false);
    manacost();
    menuClose();
    skillPic.setImage(recovery);
    FadeIn();
    hp+=20;
        if(hp>100){
            hp=100;
        }
       hpLabel.setText(String.valueOf(hp));
       ScaleTransition st=new ScaleTransition();
       st.setNode(hpRectangle);
       st.setDuration(Duration.seconds(Durations2));
       double hh=hp/100.00;
       st.setToX(hh);
       st.play();
      
}
   @FXML private void DefendUp(){
       AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
         mana-=5;
         closeSkill.setVisible(false);
       skillGp.setVisible(false);
      menuClose();
     skillPic.setImage(defend);
      FadeIn();
     defUp=10;
     defTurn=2;
     DefendUpImage.setImage(defendup1);
     DefendTurn.setText(defTurn+"");
     manacost();
}
   @FXML private void AttackUp(){
       AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
         mana-=5;
         closeSkill.setVisible(false);
       skillGp.setVisible(false);
    menuClose();
    skillPic.setImage(doubleattack);
    FadeIn();
    AtkUp*=2;
    AttackUpImage.setImage(attackup1);
    manacost();
    
}
   private void dragonDamage(){
    bosshp-=10;
    if(bosshp<=0){
        bossRevive();
    }
    else{
    double hh=bosshp/100.0;
    bosshpLabel.setText(bosshp+"");
    ScaleTransition bossHp=new ScaleTransition(Duration.seconds(Durations3),bosshpRectangle);
    bossHp.setToX(hh);
    bossHp.play();
    bossHp.setOnFinished(e->{
    menuDisplay();
    }); 
    }
    
}
   private void FadeIn(){
       FadeTransition ft=new FadeTransition();
    ft.setNode(skillPic);
    ft.setDuration(Duration.seconds(Durations1));
    ft.setFromValue(0);
    ft.setToValue(1);
    ft.play();
    ft.setOnFinished(e->{
        FadeTransition ft2=new FadeTransition();
    ft2.setNode(skillPic);
    ft2.setDuration(Duration.seconds(Durations1));
    ft2.setFromValue(1);
    ft2.setToValue(0);
    ft2.play();
    ft2.setOnFinished(ev->{
       menuDisplay(); 
    });
    });
   }
   @FXML private void closeskill(){
       AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
       skillGp.setVisible(false);
       closeSkill.setVisible(false);
   }
   private void bossRevive(){
       bosshp=0;
       bosshpLabel.setText(0+"");
       ScaleTransition bossHp=new ScaleTransition(Duration.seconds(Durations3),bosshpRectangle);
       bossHp.setToX(0);
       bossHp.play();
       BossTalk("Revive");
       bossRegen();
       attack.setDisable(true);
       skill.setDisable(true);
       Speed.setDisable(true);
       skill.setOpacity(0.5);
       menuDisplay();
   }
   private void HeroDie(){
       hpLabel.setText(0+"");
       ScaleTransition Hp=new ScaleTransition(Duration.seconds(Durations3),hpRectangle);
       Hp.setToX(0);
       Hp.play();
       Hp.setOnFinished(e->{
           FadeTransition ft=new FadeTransition(Duration.seconds(1),rootPane);
           ft.setFromValue(1);
           ft.setToValue(0);
           ft.play();
           ft.setOnFinished(ev->{
                try{
            note1.stop();
       Parent home=FXMLLoader.load(getClass().getResource("SpecialExtend.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)rootPane.getScene().getWindow();
        stage.setScene(hone);
        stage.show();
        stage.setX(dd.width/2-(stage.getWidth()/2));
        stage.setY(dd.height/2-(stage.getHeight()/2));
        
        }
        catch(IOException a){
            
        }
           });
        
       });
   }
   private void BossSkill(String a){
       //skill cant use
       //recover stolen
       //no damage one turn
       if(a.equals("SkillSeal")){
           BossTalk("Seal");
          skill.setVisible(true);
          TranslateTransition skillMove=new TranslateTransition(Duration.seconds(Durations2),skill);
          skillMove.setToY(-150);
          skillMove.play();
          skillMove.setOnFinished(e->{
          FadeTransition skillLost=new FadeTransition(Duration.seconds(Durations2),skill);
          skillLost.setFromValue(1);
          skillLost.setToValue(0);
          skillLost.play();
          skillLost.setOnFinished(ev->{
              skill.setOpacity(0.5);
              skill.setLayoutY(643);
              skill.setDisable(true);
              menuDisplay();
          });
          });
       }
       else if(a.equals("RecoverStole")){
           BossTalk("Steal");
           skillPic.setImage(recovery);
           FadeTransition bossSteal=new FadeTransition(Duration.seconds(Durations1),skillPic);
           bossSteal.setFromValue(0);
           bossSteal.setToValue(1);
           bossSteal.play();
           bossSteal.setOnFinished(e->{
              TranslateTransition toBoss=new TranslateTransition(Duration.seconds(Durations2),skillPic);
              toBoss.setToX(464);
              toBoss.play();
              toBoss.setOnFinished(ev->{
              FadeTransition recoverBoss=new FadeTransition(Duration.seconds(Durations1),skillPic);
              recoverBoss.setFromValue(1);
              recoverBoss.setToValue(0);
              recoverBoss.play();
              recoverBoss.setOnFinished(eve->{
              bosshp+=20;
              double hh=bosshp/100.0;
              bosshpLabel.setText(bosshp+"");
              ScaleTransition bosshp=new ScaleTransition(Duration.seconds(Durations3),bosshpRectangle);
              bosshp.setToX(hh);
              bosshp.play();
              TranslateTransition toBoss2=new TranslateTransition(Duration.seconds(0.001),skillPic);
              toBoss2.setToX(0);
              toBoss2.play();
              
              menuDisplay();
              });
                  
              
              });
           });
       }
       else if(a.equals("Invincible")){
           BossTalk("Armor");
           skillPic.setImage(defend);
           FadeTransition bossSteal=new FadeTransition(Duration.seconds(Durations1),skillPic);
           bossSteal.setFromValue(0);
           bossSteal.setToValue(1);
           bossSteal.play();
           bossSteal.setOnFinished(e->{
              TranslateTransition toBoss=new TranslateTransition(Duration.seconds(Durations2),skillPic);
              toBoss.setToX(464);
              toBoss.play();
              toBoss.setOnFinished(ev->{
              FadeTransition recoverBoss=new FadeTransition(Duration.seconds(Durations1),skillPic);
              recoverBoss.setFromValue(1);
              recoverBoss.setToValue(0);
              recoverBoss.play();
              recoverBoss.setOnFinished(eve->{
              AtkUp=0;    
              TranslateTransition toBoss2=new TranslateTransition(Duration.seconds(0.001),skillPic);
              toBoss2.setToX(0);
              toBoss2.play();
              
              menuDisplay();
              });
                  
              
              });
           });
       }
       else if(a.equals("forever")){
           
       }
       
       
   }
   private void BossTalk(String a){
      if(a.equals("Crit")){
          BossTalking.setText("Cancel Crit!");
      }
      else if(a.equals("Seal")){
          BossTalking.setText("Skill Seal!");
      }
      else if(a.equals("Steal")){
          BossTalking.setText("Recovery Steal!");
      }
      else if(a.equals("Armor")){
          BossTalking.setText("I am Invincible!");
      }
      else if(a.equals("Revive")){
          BossTalking.setText("Legends Never Die!");
         
      }
     
     
      FadeTransition ft=new FadeTransition(Duration.seconds(1),BossTalking);
      ft.setFromValue(0);
      ft.setToValue(1);
      ft.play();
      ft.setOnFinished(e->{
      AudioClip note=new AudioClip(this.getClass().getResource("sound/laugh.wav").toString());
      note.play();
      FadeTransition ft2=new FadeTransition(Duration.seconds(1),BossTalking);
      ft2.setFromValue(1);
      ft2.setToValue(0);
      ft2.play();   
      });
  }
   private void bossRegen(){
       bosshp+=100;
       bosshpLabel.setText(bosshp+"");
       ScaleTransition st=new ScaleTransition(Duration.seconds(3),bosshpRectangle);
       st.setToX(1);
       st.play();
       st.setOnFinished(e->{
           bossHit();
       });
   }
   private void bossHit(){
       finalHit.setVisible(true);
       finalHit.setImage(losing);
       FadeTransition BossHit=new FadeTransition(Duration.seconds(3),finalHit);
       BossHit.setFromValue(0);
       BossHit.setToValue(1);
       BossHit.play();
       BossHit.setOnFinished(e->{
       AudioClip note=new AudioClip(this.getClass().getResource("sound/thunder.wav").toString());
        note.play();
       PauseTransition pause=new PauseTransition(Duration.seconds(3));
       pause.play();
       pause.setOnFinished(ev->{
       FadeTransition BossHit2=new FadeTransition(Duration.seconds(3),finalHit);
       BossHit2.setFromValue(1);
       BossHit2.setToValue(0);
       BossHit2.play();  
       BossHit2.setOnFinished(eve->{
          HeroDamaged(); 
          finalHit.setVisible(false);
       });
       });
       });
       
   }
   private void HeroDamaged(){
       hp=1;
       hpLabel.setText(hp+"");
       double hh=hp/100.0;
       ScaleTransition st=new ScaleTransition(Duration.seconds(3),hpRectangle);
       st.setToX(hh);
       st.play();
       st.setOnFinished(e->{
           
      FadeTransition BossHit=new FadeTransition(Duration.seconds(3),HeroTalk);
       BossHit.setFromValue(0);
       BossHit.setToValue(1);
       BossHit.play();
       note1.stop();
        MediaPlayer note2=new MediaPlayer(new Media(this.getClass().getResource("sound/HeroShout.mp3").toString()));
        note2.setAutoPlay(true);
       BossHit.setOnFinished(ev->{
        
        
        note3.setCycleCount(MediaPlayer.INDEFINITE);
       note3.setAutoPlay(true);
       FadeTransition BossHit2=new FadeTransition(Duration.seconds(3),HeroTalk);
       BossHit2.setFromValue(1);
       BossHit2.setToValue(0);
       BossHit2.play();
       BossHit2.setOnFinished(eve->{
           HeroIsBack();
       });
       });
       });
   }
   private void HeroIsBack(){
       heroAngryRectangle.setVisible(true);
       FadeTransition angryMode=new FadeTransition(Duration.seconds(2),heroAngryRectangle);
       angryMode.setFromValue(0);
       angryMode.setToValue(1);
       angryMode.play();
       angryMode.setOnFinished(e->{
       Ulti.setVisible(true);
       Ulti.setDisable(false);
       TranslateTransition UltiMove=new TranslateTransition(Duration.seconds(3),Ulti);
       UltiMove.setToX(-306);
       UltiMove.setToY(-314);
       UltiMove.play();
       });
       
     
   }
   @FXML private void lastly(){
       Ulti.setVisible(false);
       Ulti.setDisable(true);
       
       ScaleTransition angryBar=new ScaleTransition(Duration.seconds(3),heroAngryRectangle);
       angryBar.setToX(0);
       angryBar.play();
       finalHit.setVisible(true);
       finalHit.setImage(win);
       FadeTransition BossHit=new FadeTransition(Duration.seconds(2),finalHit);
       BossHit.setFromValue(0);
       BossHit.setToValue(1);
       BossHit.play();
       BossHit.setOnFinished(e->{
       PauseTransition pause=new PauseTransition(Duration.seconds(2));
       pause.play();
       pause.setOnFinished(ev->{
       FadeTransition BossHit2=new FadeTransition(Duration.seconds(2),finalHit);
       BossHit2.setFromValue(1);
       BossHit2.setToValue(0);
       BossHit2.play();  
       BossHit2.setOnFinished(eve->{
       BossDamaged();
       });
       });
       });
   }
   private void BossDamaged(){
    bosshpLabel.setText(0+"");
    ScaleTransition Bosshp=new ScaleTransition(Duration.seconds(Durations3),bosshpRectangle);
    Bosshp.setToX(0);
    Bosshp.play();
    
   Bosshp.setOnFinished(e->{
       damage.setVisible(true);
    damage.setText("You win");
     FadeTransition ft=new FadeTransition(Duration.seconds(2),damage);
     ft.setFromValue(0);
     ft.setToValue(1);
     ft.play();
     note3.stop();
     ft.setOnFinished(ev->{
         FadeTransition ft2=new FadeTransition(Duration.seconds(2),rootPane);
     ft2.setFromValue(1);
     ft2.setToValue(0);
     ft2.play();
     ft2.setOnFinished(eve->{
          try{
         Parent home=FXMLLoader.load(getClass().getResource("Producer.fxml"));
        Scene hone=new Scene(home);
        stage=(Stage)rootPane.getScene().getWindow();
        stage.setScene(hone);
        stage.show();
        stage.setX(dd.width/2-(stage.getWidth()/2));
        stage.setY(dd.height/2-(stage.getHeight()/2));  
         }
       catch(IOException even){
         
     }
     });
        
     });
      
   });
   
    
   }
   private void starting(){
       FadeTransition bossFadeIn=new FadeTransition(Duration.seconds(Durations2),boss);
       bossFadeIn.setFromValue(1);
       bossFadeIn.setToValue(0);
       bossFadeIn.play();
       bossFadeIn.setOnFinished(e->{
       boss.setImage(bossImage);
       FadeTransition bossFadeOut=new FadeTransition(Duration.seconds(Durations2),boss);
       bossFadeOut.setFromValue(0);
       bossFadeOut.setToValue(1);
       bossFadeOut.play();
       bossFadeOut.setOnFinished(ev->{
       FadeTransition HeroFadeIn=new FadeTransition(Duration.seconds(Durations2),hero);
       HeroFadeIn.setFromValue(1);
       HeroFadeIn.setToValue(0);
       HeroFadeIn.play();
       HeroFadeIn.setOnFinished(eve->{
       hero.setImage(heroImage);
       FadeTransition HeroFadeOut=new FadeTransition(Duration.seconds(Durations2),hero);
       HeroFadeOut.setFromValue(0);
       HeroFadeOut.setToValue(1);
       HeroFadeOut.play();
       HeroFadeOut.setOnFinished(even->{
       note1.setCycleCount(MediaPlayer.INDEFINITE);
       note1.setAutoPlay(true);
        
       menuDisplay();
        BossTalk("Crit");
       });});});});
   }
}

