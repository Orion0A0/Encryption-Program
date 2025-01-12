/** Function : This class writes information recieved from UserInput class into "input" file and deletes file seclected
 *             It tells the user when it is done creating file or have error while creating it
 *             
 * @author 3490
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class WriteFile{
    //this function takes an array of strings
    public static void writeOutput(String[] str){
        try{
            //creates a file called output.txt
            FileWriter output = new FileWriter("output.txt");
            //loop through the array given and write it into "output" file
            for(int i=0;i<str.length;i++){
                output.write(str[i]+"\n");
            }
            //close the file after writing
            output.close();
            System.out.println("Successfully created the output file");
            System.out.println("----------------------------------------------");
        }catch(IOException e){
            System.out.println("Error while creating output file");
        }
    }//end writeOutput
    public static void writeInput(String[] str){
        try{
            //create a file called "input"
            FileWriter myWriter = new FileWriter("input.txt");
            for(int i=0;i<str.length;i++){
               myWriter.write(str[i]+"\n");
            }
            //close the file 
            myWriter.close();
            System.out.println("Successfully created the input file");
            System.out.println("----------------------------------------------");
        }catch(IOException e){
            System.out.println("Error while creating input file");
        }
    }
    //takes two boolean 
    public static void deleteFile(boolean in_put, boolean out){
        try{
            //create object from File class the parentheses matches the name of the file 
            File input=new File("intput.txt");
            File output=new File("output.txt");
            //if the "in_put" or the "out" is true, it will delete file that correspond to its name
            if(in_put){
                System.out.println(input.delete());
            }
            if(out){
                System.out.println(output.delete());
            }
            
        }catch(Exception e){
            //when can't find any file to delete
            System.out.println("There are no file left to be clear");
        }
        
    }
}
