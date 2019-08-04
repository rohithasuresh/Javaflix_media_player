/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPlayer;

import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.ChoiceBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import jdk.nashorn.internal.parser.TokenType;
import org.json.JSONObject;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;


/**
 *
 * @author main
 */
public class FXMLDocumentController implements Initializable {
    String selectItem;
    String comboValue;
    @FXML
    private MediaView mkv;
    private MediaPlayer mp;
    private Media me;
    
    
    
    @FXML
    Slider volumeControler;
    
    @FXML
    public ComboBox<String> comCatogary;
    
    @FXML
    public TextField txtAuto;
    
    @FXML
    public ListView<String> listView;
    
    //*****************************
    public void getInput(){
   
      //  return 5;
    }

    //****************************
            
    ObservableList<String> Catagarylist=FXCollections.observableArrayList("Movies","Songs");
    String[] asd={"aqw","qwe","zxc"};
    String[] arrayList=new String[100];
    String[] aLine=new String[100];
    int lineCount=0;
    String[] commandLine=new String[100];
    List<String> list1 = new ArrayList();
    int a=0;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       
        
        
        
        try{
        
            

        }
        
        catch (Exception e)
        {
        System.out.println(e);
        }
        
    
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     //   String selectItem=txtAuto.getText().toString();
       String path=new File("src/MediaPlayer/movies/Romeo.mp4").getAbsolutePath();
       me=new Media(new File(path).toURI().toString());
       mp=new MediaPlayer(me);
        mkv.setMediaPlayer(mp);
        // mp.setAutoPlay(true);
         DoubleProperty width=mkv.fitWidthProperty();
          DoubleProperty height=mkv.fitHeightProperty();
          width.bind(Bindings.selectDouble(mkv.sceneProperty(),"width"));
          height.bind(Bindings.selectDouble(mkv.sceneProperty(),"height"));
         // TextFields.bindAutoCompletion(txtAuto, asd);
          volumeControler.setValue(mp.getVolume()*100);
          volumeControler.valueProperty().addListener(new InvalidationListener() {

           @Override
           public void invalidated(Observable observable) {
               mp.setVolume(volumeControler.getValue()/100);
           }
       });
       comCatogary.setItems(Catagarylist);
       comboValue=comCatogary.getValue();
        
       
       
    }  
    public void getSelectItem(){
    list1.clear();
   
    for(int j = 0; j < aLine.length - 1; j++){
                    aLine[j] = aLine[j+1];}
    try{
    //*****************create command line array
    //String[] aLine=new String[20000];
    
    
            //int zxc=10;
            
            
    Runtime rt = Runtime.getRuntime();
    String[] commands = {"cmd.exe", "/c", "cd \"C:\\Users\\shanaka\\Desktop\\suresh\\MediaPlayerTask\\src\\MediaPlayer\\movies\" && dir"};
    //String[] commands = {"cmd.exe", "/c", "cd \"C:\\Users\\shanaka\\Desktop\\New folder (2)\" && python test9.py sh;arp"};
  // 
    Process proc = rt.exec(commands);

    BufferedReader stdInput = new BufferedReader(new 
    InputStreamReader(proc.getInputStream()));

    BufferedReader stdError = new BufferedReader(new 
    InputStreamReader(proc.getErrorStream()));
    



    String s = null;
    while ((s = stdInput.readLine()) != null) {
    //System.out.println(s);
     commandLine[lineCount]=s;
   // System.out.println(commandLine[lineCount]);
       // System.out.println(lineCount);
     lineCount++;
}
      System.out.println("********************************");    
    for(int i=7;i<lineCount-2;i++){
        String[] words=commandLine[i].split("\\s+");  
        int qw=0; 
        for(String w:words){ 
            qw+=1;
           // System.out.println(qw+"****"+w); 
            aLine[qw]=w;
           
            
      // System.out.println("********************************");        
    
    }   // System.out.println(aLine[5]);
       
        arrayList[a]=aLine[5];
        a+=1;
    }   
    for(int i=0;i<a;i++){
        list1.add(arrayList[i]);
    }
        
         TextFields.bindAutoCompletion(txtAuto, list1);
           for(int i=0;i<a;i++){
               System.out.println(i+"*****/"+arrayList[i]);
           
           }
    }catch(Exception e){} 
    }
    
    public void getSelectItem2(){
         list1.clear();
        
         for(int j = 0; j < aLine.length - 1; j++){
                    aLine[j] = aLine[j+1];
                }
       // Arrays.fill(aLine, ""); 
     try{
    
       
    Runtime rt = Runtime.getRuntime();
    String[] commands = {"cmd.exe", "/c", "cd \"C:\\Users\\shanaka\\Desktop\\suresh\\MediaPlayerTask\\src\\MediaPlayer\\Songs\" && dir"};
    //String[] commands = {"cmd.exe", "/c", "cd \"C:\\Users\\shanaka\\Desktop\\New folder (2)\" && python test9.py sh;arp"};
  // 
    Process proc = rt.exec(commands);

    BufferedReader stdInput = new BufferedReader(new 
    InputStreamReader(proc.getInputStream()));

    BufferedReader stdError = new BufferedReader(new 
    InputStreamReader(proc.getErrorStream()));
    



    String s = null;
    while ((s = stdInput.readLine()) != null) {
    //System.out.println(s);
     commandLine[lineCount]=s;
   // System.out.println(commandLine[lineCount]);
       // System.out.println(lineCount);
     lineCount++;
}
      System.out.println("********************************");    
    for(int i=7;i<lineCount-2;i++){
        String[] words=commandLine[i].split("\\s+");  
        int qw=0; 
        for(String w:words){ 
            qw+=1;
           // System.out.println(qw+"****"+w); 
            aLine[qw]=w;
           
            
      // System.out.println("********************************");        
    
    }   // System.out.println(aLine[5]);
        arrayList[a]=aLine[5];
        a+=1;
    }  
           //List<String> list2 = new ArrayList();
    for(int i=0;i<a;i++){
        
         list1.add(arrayList[i]);
    }
        
         TextFields.bindAutoCompletion(txtAuto, list1);
    }catch(Exception e){}  
      TextFields.bindAutoCompletion(txtAuto, arrayList);
    
    }
    
    
    
    public void play(ActionEvent event){
      if(comCatogary.getValue()=="Movies"){
          mp.stop();
         String selectItem=txtAuto.getText().toString();
       String path=new File("src/MediaPlayer/movies/"+selectItem).getAbsolutePath();
       me=new Media(new File(path).toURI().toString());
       mp=new MediaPlayer(me);
        mkv.setMediaPlayer(mp);
         mp.setAutoPlay(true);
         DoubleProperty width=mkv.fitWidthProperty();
          DoubleProperty height=mkv.fitHeightProperty();
          width.bind(Bindings.selectDouble(mkv.sceneProperty(),"width"));
          height.bind(Bindings.selectDouble(mkv.sceneProperty(),"height"));
         // TextFields.bindAutoCompletion(txtAuto, asd);
          volumeControler.setValue(mp.getVolume()*100);
          volumeControler.valueProperty().addListener(new InvalidationListener() {

           @Override
           public void invalidated(Observable observable) {
               mp.setVolume(volumeControler.getValue()/100);
           }
       });
       comCatogary.setItems(Catagarylist);
       comboValue=comCatogary.getValue();
       // getInput();
      // selectItem=listView.getSelectionModel().getSelectedItem().toString();
        // lable.setText(comCatogary.getValue());
       // lable2.setText(comboValue);
    //mp.play();
   // mp.setRate(1);
      }else  if(comCatogary.getValue()=="Songs"){
         mp.stop();
         String selectItem=txtAuto.getText().toString();
       String path=new File("src/MediaPlayer/Songs/"+selectItem).getAbsolutePath();
       me=new Media(new File(path).toURI().toString());
       mp=new MediaPlayer(me);
        mkv.setMediaPlayer(mp);
         mp.setAutoPlay(true);
         DoubleProperty width=mkv.fitWidthProperty();
          DoubleProperty height=mkv.fitHeightProperty();
          width.bind(Bindings.selectDouble(mkv.sceneProperty(),"width"));
          height.bind(Bindings.selectDouble(mkv.sceneProperty(),"height"));
         // TextFields.bindAutoCompletion(txtAuto, asd);
          volumeControler.setValue(mp.getVolume()*100);
          volumeControler.valueProperty().addListener(new InvalidationListener() {

           @Override
           public void invalidated(Observable observable) {
               mp.setVolume(volumeControler.getValue()/100);
           }
       });
       comCatogary.setItems(Catagarylist);
       comboValue=comCatogary.getValue();
       // getInput();
      // selectItem=listView.getSelectionModel().getSelectedItem().toString();
        // lable.setText(comCatogary.getValue());
       // lable2.setText(comboValue);
    //mp.play();
   // mp.setRate(1);
      }
   }
    public void pause(ActionEvent event){
    mp.pause();
   }
    public void fast(ActionEvent event){
   
  if(comCatogary.getValue()=="Movies"){
    
     getSelectItem();
     
  }else if(comCatogary.getValue()=="Songs"){
      getSelectItem2();      
  }
   // mp.setRate(2);
   }
    public void slow(ActionEvent event){
      //   listView.getItems().clear();
    mp.setRate(0.5);
   }
    public void reload(ActionEvent event){
    mp.seek(mp.getStartTime());
    mp.play();
   }
    public void start(ActionEvent event){
   mp.seek(mp.getStartTime());
   mp.stop();
   }
    public void last(ActionEvent event){
    mp.seek(mp.getTotalDuration());
    mp.stop();
   }
}
