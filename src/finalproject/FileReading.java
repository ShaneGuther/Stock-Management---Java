/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shane
 */
public class FileReading {
    //private static ArrayList<Crop> cropList = new ArrayList<>();
    public static void main(String[]args){
  
        //File Reading
        //Step 1: Create file object
        File file = new File("studentInfo.csv");
        //Step 2: create file reader
        //-Scanner class: file reader
        //  -1 method -- hasXXXXX(); - hasNext(), hasNextLine(), hasNextInt() ....
        //  -2 method -- nextXXXX(); - has nextInt(), Double(), next(), nextLine()....
        
        Scanner fileInput = null;
        try{
            //Step 2: create reader over the file object   
            fileInput = new Scanner(file);
            
            //Step 3: Read file
            while(fileInput.hasNext()) {//check if there is more data in the file
            String record = fileInput.nextLine();
           // System.out.println(record);
            //from a record, create a student object
            //- split the String into three fields, id, name mark]
            //use split method with a delimiter
            String[] fields = record.split(","); //tokenizing
            int id = Integer.parseInt(fields[0]);
            //System.out.println("hi");
            String name = fields[1];
            String type = fields[2];
            //char fieldSect = fields[3].charAt(0);
            //char fieldSect = 'a';
            Crop newCrop = new Crop(id, name, type);
           // cropList.add(newCrop);
            System.out.println(newCrop.toString());
            
            
            
            
            }
        }catch(FileNotFoundException e){
            System.out.println("Can't read from file");
        }finally{
            if(fileInput != null){
                fileInput.close();
            }
        }
    }    
}
//class Crop{
//    private String id;
//    private String name;
//    private String type;
//    
//
//    public Crop(String id, String name, String type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        
//    }
//    
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//    
//    @Override
//    public String toString(){
//        return "ID " + getId() + " | Name:" + getName() + " | Type: " + getType();
//    }
//    
//}