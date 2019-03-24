/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author lim
 */
public class EasyController implements Initializable{
@FXML private AnchorPane anchor;
@FXML private ImageView c1;
@FXML private ImageView c2;
@FXML private ImageView c3;
@FXML private ImageView c4;
@FXML private ImageView c5;
@FXML private ImageView c6;
@FXML private ImageView c7;
@FXML private ImageView c8;
@FXML private ImageView c9;
@FXML private ImageView p1;
@FXML private ImageView p2;
@FXML private ImageView p3;
@FXML private ImageView p4;
@FXML private ImageView p5;
@FXML private ImageView p6;
@FXML private ImageView p7;
@FXML private ImageView p8;
@FXML private ImageView p9;
@FXML private Label a1;
@FXML private Label a2;
@FXML private Label a3;
@FXML private Label a4;
@FXML private TextField ans;
@FXML private Label check;
@FXML private Label cover;
@FXML private Rectangle rect;
@FXML private Label percent;
@FXML private ImageView congrats;
@FXML private Button back;
@FXML private ImageView h1;
@FXML private ImageView h2;
@FXML private ImageView h3;
@FXML private Label yeah;
    static int count=0;
    static int count2=0; 
    static int r1=(int)(Math.random()*9);
    static int r2=(int)(Math.random()*9);
    static int life=3;
    static int victorycount=0;
    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
    File file2=new File("D:/NetBeansProjects/MyProject/src/myproject/Gif/heartbeat.gif");
    Image heart=new Image(file2.toURI().toString());
     File file = new File("D:/NetBeansProjects/MyProject/src/myproject/image/heatlost.png");
        Image image = new Image(file.toURI().toString());
        File lol=new File("D:/NetBeansProjects/MyProject/src/myproject/Gif/cry2.gif");
        Image im=new Image(lol.toURI().toString());
         public Stage stage;
         MediaPlayer note1=new MediaPlayer(new Media(this.getClass().getResource("sound/easy.mp3").toString()));
          @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition ft=new FadeTransition(Duration.seconds(2),anchor);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        
        note1.play();
        back.setDisable(true);
        ans.requestFocus();
        r1=(int)(Math.random()*9);
        r2=(int)(Math.random()*9);
        // TODO 149 118
        a2.setText("+");
        a4.setText("=");
        count=0;
        count2=0;
        life=3;
        victorycount=0;
        a1.setText(r1+"");
        a3.setText(r2+"");
  cover.setVisible(false);
  congrats.setOpacity(0);
  back.setOpacity(0);
  yeah.setOpacity(0);
if(count<r1){
    createNextTransition();
}
    if(count2<r2){
        newTransition();
    }
FillTransition fillTransition=new FillTransition(Duration.seconds(1),rect,Color.AQUAMARINE,Color.PINK);
        fillTransition.setAutoReverse(true);
        fillTransition.setCycleCount(Animation.INDEFINITE);
       fillTransition.play();
       ans.setOnKeyPressed(e->{
           if(e.getCode().equals(KeyCode.ENTER)){
              start();
           }
       });
    }
    @FXML private void bb(ActionEvent event)throws IOException{
        note1.stop();
                 FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(anchor);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play(); 
 
     
        ft.setOnFinished(e->{
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
    }        
    @FXML private void start(){
        if(ans.getText().equals("")){
            check.setText("Please enter number");
            check.setOpacity(1);
        }
        else if(!ans.getText().matches("\\d+")){
            check.setText("Enter numeric values");
            ans.setText("");
            check.setOpacity(1);
        }
        else{
            int final_ans=Integer.parseInt(ans.getText());
      if(final_ans==(r1+r2)){
          AudioClip note=new AudioClip(this.getClass().getResource("sound/correct.wav").toString());
          note.play();
          check.setText("Correct!!");
         
          r1=(int)(Math.random()*9);
          r2=(int)(Math.random()*9);
          next();
          victorycount+=10;
          Victory();
          

       if(victorycount==100){
           AudioClip note2=new AudioClip(this.getClass().getResource("sound/win.wav").toString());
           note2.play();
           note1.stop();
        cover.setVisible(true);
        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(3000));
        ft.setNode(congrats);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        FadeTransition ft2=new FadeTransition();
        ft2.setDuration(Duration.millis(3000));
        ft2.setNode(yeah);
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ft2.play(); 
        back.setDisable(false);
        FadeTransition ft3=new FadeTransition();
        ft3.setDuration(Duration.millis(3000));
        ft3.setNode(back);
        ft3.setFromValue(0);
        ft3.setToValue(1);
        ft3.play();
        
       }
     
      }
      else{
          life--;
           MediaPlayer note=new MediaPlayer(new Media(this.getClass().getResource("sound/incorrect.mp3").toString()));
           note.play();
          if(life==0){
               MediaPlayer note4=new MediaPlayer(new Media(this.getClass().getResource("sound/lose(normal).mp3").toString()));
           note4.play();
           note1.stop();
              check.setText("You lose");
             cover.setVisible(true);
             h1.setImage(image);
             congrats.setImage(im);
             back.setDisable(false);
             yeah.setText("Sorry...");
               FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(3000));
        ft.setNode(congrats);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        FadeTransition ft2=new FadeTransition();
        ft2.setDuration(Duration.millis(3000));
        ft2.setNode(yeah);
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ft2.play(); 
        FadeTransition ft3=new FadeTransition();
        ft3.setDuration(Duration.millis(3000));
        ft3.setNode(back);
        ft3.setFromValue(0);
        ft3.setToValue(1);
        ft3.play();
          }
          else if(life==2){
               check.setText("Wrong.Try again"); 
                         h3.setImage(image);

          }
          else if(life==1){
               check.setText("Wrong.Try again"); 
               h2.setImage(image);
          }
          
          
      }
     FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(3000));
        ft.setNode(check);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
        ans.setText("");
        }
        ans.requestFocus();
      
    }
    @FXML private void back(ActionEvent event)throws IOException{
        note1.stop();
                 FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(1000));
        ft.setNode(anchor);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play(); 
 
     
        ft.setOnFinished(e->{
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
    });
    }
    private void createNextTransition(){
              TranslateTransition tt=new TranslateTransition();
            tt.setDuration(Duration.seconds(0.5));
            switch(count){
                 case 0: tt.setToX(341);tt.setToY(307);tt.setNode(c1);break;
                 case 1: tt.setToX(431);tt.setToY(307);tt.setNode(c2);break;
                 case 2: tt.setToX(521);tt.setToY(307);tt.setNode(c3);break;
                 case 3: tt.setToX(611);tt.setToY(307);tt.setNode(c4);break;
                 case 4: tt.setToX(341);tt.setToY(347);tt.setNode(c5);break;
                case 5: tt.setToX(431);tt.setToY(347);tt.setNode(c6);break;
                case 6: tt.setToX(521);tt.setToY(347);tt.setNode(c7);break;
                case 7: tt.setToX(611);tt.setToY(347);tt.setNode(c8);break;    
             }
             tt.play();
             tt.setOnFinished(e->{
                count++; 
                if(count<r1){
                    createNextTransition();
                }
                
             });
                     
         }
    private void newTransition(){
        TranslateTransition t2=new TranslateTransition();
               t2.setDuration(Duration.seconds(0.5));
               switch(count2){
           
            case 0:t2.setToX(-371);t2.setToY(294); t2.setNode(p1);break;
            case 1:t2.setToX(-281);t2.setToY(294);t2.setNode(p2);break;
            case 2:t2.setToX(-191);t2.setToY(294);t2.setNode(p3);break;
            case 3:t2.setToX(-101);t2.setToY(294);t2.setNode(p4);break;
            case 4:t2.setToX(-371);t2.setToY(335);t2.setNode(p5);break;
            case 5:t2.setToX(-281);t2.setToY(335);t2.setNode(p6);break;
            case 6:t2.setToX(-191);t2.setToY(335);t2.setNode(p7);break;
            case 7:t2.setToX(-101);t2.setToY(335);t2.setNode(p8);break;
        }
        t2.play();
        t2.setOnFinished(e->{
            count2++;
            if(count2<r2){
                newTransition();
            }
            
        });   
    }
    private void backTransition(){
        TranslateTransition tt=new TranslateTransition();
            tt.setDuration(Duration.seconds(0.5));
            switch(count){
                 case 1: tt.setToX(0);tt.setToY(0);tt.setNode(c1);break;
                 case 2: tt.setToX(0);tt.setToY(0);tt.setNode(c2);break;
                 case 3: tt.setToX(0);tt.setToY(0);tt.setNode(c3);break;
                 case 4: tt.setToX(0);tt.setToY(0);tt.setNode(c4);break;
                 case 5: tt.setToX(0);tt.setToY(0);tt.setNode(c5);break;
                case 6: tt.setToX(0);tt.setToY(0);tt.setNode(c6);break;
                case 7: tt.setToX(0);tt.setToY(0);tt.setNode(c7);break;
                case 8: tt.setToX(0);tt.setToY(0);tt.setNode(c8);break;    
             }
             tt.play();
             tt.setOnFinished(e->{
                count--; 
                if(count>r1){
                    backTransition();
                }
             });
                     
    }
    private void back2Transition(){
        TranslateTransition t2=new TranslateTransition();
               t2.setDuration(Duration.seconds(0.5));
               switch(count2){
           
            case 1:t2.setToX(0);t2.setToY(0); t2.setNode(p1);break;
            case 2:t2.setToX(0);t2.setToY(0);t2.setNode(p2);break;
            case 3:t2.setToX(0);t2.setToY(0);t2.setNode(p3);break;
            case 4:t2.setToX(0);t2.setToY(0);t2.setNode(p4);break;
            case 5:t2.setToX(0);t2.setToY(0);t2.setNode(p5);break;
            case 6:t2.setToX(0);t2.setToY(0);t2.setNode(p6);break;
            case 7:t2.setToX(0);t2.setToY(0);t2.setNode(p7);break;
            case 8:t2.setToX(0);t2.setToY(0);t2.setNode(p8);break;
        }
        t2.play();
        t2.setOnFinished(e->{
            count2--;
            if(count2>r2){
                back2Transition();
            }
        });   
    }
    private void next(){
        r1=(int)(Math.random()*9);
        r2=(int)(Math.random()*9);
        
        a2.setText("+");
        a4.setText("=");
        a1.setText(r1+"");
        a3.setText(r2+"");
        if(count<r1){
    createNextTransition();
        }
    if(count2<r2){
        newTransition();
    }
    if(count>r1){
        backTransition();
    }
    if(count2>r2){
        back2Transition();
    }
    }
    @FXML private void save(){
        AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
        try{
      	String filename="save.txt";
      	File f = new File(filename);
      	PrintWriter p = new PrintWriter(new FileWriter(f,false));//append
      
      	p.print(life+System.lineSeparator()+victorycount);
      	
      	p.close();
      }catch(IOException e){
      	
      }
        
    }
    @FXML private void load(){
        AudioClip note=new AudioClip(this.getClass().getResource("sound/click.wav").toString());
        note.play();
        count=0;
      try{
        String filename="save.txt";
      	File f = new File(filename); 	       	      	
	Scanner s = new Scanner(f);
	while(s.hasNext()){
            String name = s.nextLine();
            if(count==0){
                if(Integer.parseInt(name)==3){
                    life=3;
                    h1.setImage(heart);
                    h2.setImage(heart);
                    h3.setImage(heart);
                }
                else if(Integer.parseInt(name)==2){
                    life=2;
                    h1.setImage(heart);
                    h2.setImage(heart);
                    h3.setImage(image);
                }
                else if(Integer.parseInt(name)==1){
                life=1;
                h1.setImage(heart);
                h2.setImage(image);
                h3.setImage(image);
            }
            }
            else if(count==1){
                victorycount=Integer.parseInt(name);
                Victory();
            }
            count++;
	 
         
	}//end while ()
			 s.close();
	 }catch(IOException e){
		 System.out.println("Exception caught: " + e.getMessage());
	}//end try   
    }
    private void Victory(){
        ScaleTransition st=new ScaleTransition();
st.setDuration(Duration.seconds((0.5)));
st.setNode(rect);  

st.setToY((victorycount/10)*28);
st.play();

percent.setText(victorycount+"%");
    }
}
