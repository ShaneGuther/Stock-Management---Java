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
import java.util.Scanner;
import javafx.collections.FXCollections;
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
    
    public ObservableList fileReading(ObservableList a){
        ObservableList<Crop>temp= FXCollections.observableArrayList();
        try{
        
        Scanner fileInput = null;
        String line = "";
        String file = "farmInfo.csv";        
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);            
                while((line = br.readLine())!=null) {
                    String[] record = line.split(",");
                    //Integer itemId = Integer.getInteger(record[0].trim());
                    String name = record[1].trim();
                    String type = record[2].trim();
                    Integer quantity = Integer.parseInt(record[3].trim());
                    Double price = Double.parseDouble(record[4].trim());
                    String fieldSect = record[5].trim();
                    //Crop oldCrop = new Crop(name, type, quantity, price, fieldSect);
                    temp.add(new Crop(temp.size()+1, name, type, quantity, price, fieldSect));
                }
                
                br.close();
            
                }catch(FileNotFoundException ex){
                    System.out.println("Error2" + ex);
                }catch(IOException e){
                    System.out.println("Error" + e);
                }catch (NumberFormatException b){
                System.out.println("Error" +b);
                }
                finally{
                }return temp;
    }
    public void fileWriting(ObservableList b, String type, String name, int quantity, double price, String fieldSect){
        //Scanner input = new Scanner(System.in);
        //ArrayList<Student> studentList = new ArrayList<>();
        //1. create file object
        //check existance if desired
         File file = new File("farmInfo.csv");
        //2. create file writer
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileWriter(file, true));
            //Integer itemId = id;
            String itemType = type;
            String itemName = name;
            Integer itemQuant = quantity;       
            Double itemPrice = price;
            String itemSect = fieldSect;
            Crop newCrop = new Crop((b.size()+1), itemName, itemType, itemQuant, itemPrice, itemSect);
      
                b.add(newCrop);
            output.println((b.size()+1) + "," + itemName + ","+ itemType + "," + itemQuant + 
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
        public ObservableList itemDeleting(ObservableList<Crop> g, Integer id){
            PrintWriter output = null;
            try{
        File file = new File("farmInfo.csv");
        int count = 0;
        //output = null;
        output = new PrintWriter(new FileWriter(file, false));
        g.remove(g.get(id-1));
        for(Crop d : g){    
        count++;
        output.println(count + "," + d.getItemName() + ","+ d.getItemType() + "," + d.getItemQuantity() + 
        "," + d.getPricePerPound() + "," + d.getFieldSection());
        }
            }catch(IOException e){
             System.out.println("error" + e);
             }finally{
                if (output != null) output.close();
            }
            return g;
        }
        
        
        
        
        public void itemUpdating(ObservableList<Crop> a, String type, String name, int quantity, double price, String fieldSect){
                PrintWriter output = null;
            try{
        File file = new File("farmInfo.csv");
        int count1 = 0;
        //output = null;
        output = new PrintWriter(new FileWriter(file, false));
        //a.set(id-1, a.get());
        for(Crop d : a){
        count1++;
        output.println(count1 + "," + d.getItemName() + ","+ d.getItemType() + "," + d.getItemQuantity() + 
        "," + d.getPricePerPound() + "," + d.getFieldSection());
        }
            }catch(IOException e){
             System.out.println("error" + e);
             }finally{
                if (output != null) output.close();
            }
        
        }
        }


       
