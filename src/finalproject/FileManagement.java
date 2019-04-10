/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedReader;
import javafx.fxml.FXML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javafx.collections.ObservableList;

/**
 *
 * @author shane
 */
public class FileManagement {
     //public ArrayList<Crop> cropList = new ArrayList<>();
    @FXML
    
   // private FXMLDocumentController doc;
    public static void main(String[]args){
        
    }
       
    public void fileReading(ObservableList a){
        try{
        
        Scanner fileInput = null;
        String line = "";
        String file = "farmInfo.csv";
        //ArrayList<String> csvList = new ArrayList<>();
        //Scanner lineToken;
        //BufferedReader reader = new BufferedReader(new FileReader(file));
         //try{
            
            //Step 2: create reader over the file object   
            //fileInput = new Scanner(file);
            
           
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);            
                while((line = br.readLine())!=null) {
                    String[] record = line.split(",");
                    Integer itemId = Integer.parseInt(record[0].trim());
                    String name = record[1].trim();
                    String type = record[2].trim();
                    Integer quantity = Integer.parseInt(record[3].trim());
                    Double price = Double.parseDouble(record[4].trim());
                    String fieldSect = record[5].trim();
                    //Crop oldCrop = new Crop(name, type, quantity, price, fieldSect);
                    a.add(new Crop(itemId, name, type, quantity, price, fieldSect));
                }
                br.close();
            
                }catch(FileNotFoundException ex){
                    System.out.println("Error2" + ex);
                }catch(IOException e){
                    System.out.println("Error" + e);
                }finally{
                }
    }
    public void fileWriting(ObservableList b, Integer id, String name, String type, int quantity, double price, String fieldSect){
        //Scanner input = new Scanner(System.in);
        //ArrayList<Student> studentList = new ArrayList<>();
        //1. create file object
        //check existance if desired
         File file = new File("farmInfo.csv");
        //2. create file writer
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileWriter(file, true));
            Integer itemId = id;
            String itemName = name;
            String itemType = type;
            Integer itemQuant = quantity;       
            Double itemPrice = price;
            String itemSect = fieldSect;
            Crop newCrop = new Crop(itemId, itemName, itemType, itemQuant, itemPrice, itemSect);
      
                b.add(newCrop);
            output.println(itemId + "," + itemName + ","+ itemType + "," + itemQuant + 
                    "," + itemPrice + "," + fieldSect);
        
        }catch(FileNotFoundException e){
            System.out.println("File cannot be created " + e);
            
        }catch(IOException ex){
             System.out.println("IO Exception " + ex);
        }
        //Release file reading resources
        finally{
            if(output != null)
                output.close();
        }
    }
    public void itemDeleting(ObservableList a, int id){
        //a.remove(new Crop(1, "h", "g", 1, 5.1, "j"));
    }
}
       