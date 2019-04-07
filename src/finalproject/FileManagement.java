
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
        
    }
    public void fileReading(){
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
            
            String name = fields[0];
            String type = fields[1];
            int quant = Integer.parseInt(fields[2]);          
            boolean avail = Boolean.parseBoolean(fields[3]);
            double price = Double.parseDouble(fields[4]);
            char fieldSect = fields[6].charAt(0);
            //char fieldSect = fields[3].charAt(0);
            //char fieldSect = 'a';
            Crop newCrop = new Crop(name, type, quant, avail, price, fieldSect);
           // cropList.add(newCrop);
            System.out.println(newCrop);
            
            
            
            
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

    
}
