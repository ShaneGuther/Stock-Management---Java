/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shane
 */
public class FileManagement {
    public static void main(String[]args){
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
            double quantity = Double.parseDouble(fields[3]);
            boolean avail = Boolean.parseBoolean(fields[4]);
            double price = Double.parseDouble(fields[5]);
            char fieldSect = fields[6].charAt(0);
            //char fieldSect = fields[3].charAt(0);
            //char fieldSect = 'a';
     
           // cropList.add(newCrop);
           // System.out.println(newCrop.toString());
            
            
            
            
            }
        }catch(FileNotFoundException e){
            System.out.println("Can't read from file");
        }finally{
            if(fileInput != null){
                fileInput.close();
            }
        }
    }    

  

    public void fileWriting(ArrayList a, String name, String type, int quantity, boolean avail, double price, char fieldSect){
        Scanner input = new Scanner(System.in);
        //ArrayList<Student> studentList = new ArrayList<>();
        //1. create file object
        //check existance if desired
         File file = new File("studentInfo.csv");
        //2. create file writer
        PrintWriter output = null;
        try{
            output = new PrintWriter(file);
            
        
        //3. read student info from user and write in CSV format
        for(int i = 0; i < a.size(); i++){
            String itemName = name;
            String itemType = type;
            int itemQuant = quantity;
            boolean itemAvail = avail;
            double itemPrice = price;
            char itemSect = fieldSect;
            Crop newCrop = new Crop(itemName, itemType, itemQuant, itemAvail, itemPrice, itemSect);
           // studentList.add(newStudent);
            output.println(newCrop);
        }
            //output.println(newStudent.getId(), newStudent.getName());
             //output.println(addArrayToFile(studentList));
        }catch(FileNotFoundException e){
            System.out.println("File cannot be created " + e);
            
        }
        //4.close the file/writer
        finally{
            if(output != null)
                output.close();
}
    }
}
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package finalproject;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
///**
// *
// * @author shane
// */
//public class FileManagement {
//    public static void main(String[]args){
//                File file = new File("studentInfo.csv");
//        //Step 2: create file reader
//        //-Scanner class: file reader
//        //  -1 method -- hasXXXXX(); - hasNext(), hasNextLine(), hasNextInt() ....
//        //  -2 method -- nextXXXX(); - has nextInt(), Double(), next(), nextLine()....
//        
//        Scanner fileInput = null;
//        try{
//            //Step 2: create reader over the file object   
//            fileInput = new Scanner(file);
//            
//            //Step 3: Read file
//            while(fileInput.hasNext()) {//check if there is more data in the file
//            String record = fileInput.nextLine();
//           // System.out.println(record);
//            //from a record, create a student object
//            //- split the String into three fields, id, name mark]
//            //use split method with a delimiter
//            String[] fields = record.split(","); //tokenizing
//            int id = Integer.parseInt(fields[0]);
//            //System.out.println("hi");
//            String name = fields[1];
//            String type = fields[2];
//            double quantity = Double.parseDouble(fields[3]);
//            boolean avail = Boolean.parseBoolean(fields[4]);
//            double price = Double.parseDouble(fields[5]);
//            char fieldSect = fields[6].charAt(0);
//            //char fieldSect = fields[3].charAt(0);
//            //char fieldSect = 'a';
//            Crop newCrop = new Crop(id, name, type);
//           // cropList.add(newCrop);
//            System.out.println(newCrop.toString());
//            
//            
//            
//            
//            }
//        }catch(FileNotFoundException e){
//            System.out.println("Can't read from file");
//        }finally{
//            if(fileInput != null){
//                fileInput.close();
//            }
//        }
//    }    
//}
//  
//
//    public void fileWriting(ArrayList a, String name, String type, int quantity, boolean avail, double price, char fieldSect){
//        Scanner input = new Scanner(System.in);
//        //ArrayList<Student> studentList = new ArrayList<>();
//        //1. create file object
//        //check existance if desired
//         File file = new File("studentInfo.csv");
//        //2. create file writer
//        PrintWriter output = null;
//        try{
//            output = new PrintWriter(file);
//            
//        
//        //3. read student info from user and write in CSV format
//        for(int i = 0; i < a.size(); i++){
//            String itemName = name;
//            String itemType = type;
//            int itemQuant = quantity;
//            boolean itemAvail = avail;
//            double itemPrice = price;
//            char itemSect = fieldSect;
//            Crop newCrop = new Crop(itemName, itemType, itemQuant, itemAvail, itemPrice, itemSect);
//           // studentList.add(newStudent);
//            output.println(newCrop);
//        }
//            //output.println(newStudent.getId(), newStudent.getName());
//             //output.println(addArrayToFile(studentList));
//        }catch(FileNotFoundException e){
//            System.out.println("File cannot be created " + e);
//            
//        }
//        //4.close the file/writer
//        finally{
//            if(output != null)
//                output.close();
//}}
//        
//       
//    
//       
//    