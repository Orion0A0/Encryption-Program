/** Function : This class read the "input" file written by other class and return an array of int
 * @author 3490
 */
import java.io.File; 
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
class ReadFile{
    private int [] arrayOfNum;
    private int numHolder;
    private ArrayList<Integer> data= new ArrayList<Integer>();
    private String check;
    private static int count=0;
    private boolean go;
    ReadFile(){
        go=true;
    }
    //reads data from file named input.txt and return and array of int
    public  int[] read(){
        File input= new File("input.txt");
        //clear the value inside"data"
        data.clear();
        //reset counter
        count=0;
        //loop until everything in the file of input.txt has been scanned
        try{
            Scanner scan=new Scanner(input);
            while(go){
                try{  
                    while(scan.hasNextLine()){
                        //count how many lines has been process
                        count++;
                        //input the user input into "check"
                        check=scan.nextLine();
                        //convert "check" into int
                        numHolder=Integer.parseInt(check);
                        //filter out the data that has more than 4 int
                        if(check.length()==4){
                            //add the filtered data into "numHolder"
                            data.add(numHolder);
                        }else{
                            //tells the user which line is filtered 
                            System.out.println("Line "+count+" has over/under 4 digit"); 
                        }
                    }
                    arrayOfNum= new int[data.size()];
                    //convert "data" into an array of int
                    for(int i=0;i<data.size();i++){
                        arrayOfNum[i]=data.get(i);
                    }
                    //stop the loop
                    go=false;
                }catch(Exception e){
                    // if there isn't anything left in the file, stop the loop
                    if(!scan.hasNextLine()){
                        go=false;
                    }
                    //tells the user which line is not integer
                    System.out.println("Line "+ count+" not an integer");
                }
            }    
                }catch(IOException e){
                    //when file failed to create
                    System.out.println("File not found");
                }
        //delete the file or reset the file
        input.delete();
        //pass an array of integer into the next function
        return arrayOfNum;
    }
}

    

    
    
  //end method
//end class
