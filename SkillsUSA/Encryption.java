/**
 * This class includes functions that encrypt or decrypt the given value from an array of int 
 * @author 3490
 */
import java.util.ArrayList;
import java.util.Arrays;
class Encryption{
    private String[] array;
    private String str;
    private String msg;
    private int numHolder;
    private int lastNum;
    private int[] arrayHolder;
    private int enOrde;
    
    Encryption(){
        arrayHolder=new int[4];    
    }
    //takes an array of int and a boolean(true for encrypt;false for decrypt) 
    //returns an array of string
    public String[] crypt(int[] num, boolean en_or_de){
        if(en_or_de){
            enOrde=7;
            msg="Encrypted Message:";
        }else {
            enOrde=3;
            msg="Decrypted Message:";
        }
        array=new String[num.length];
        //loop through the entire array
        for(int i=0;i<num.length;i++){
            numHolder=num[i];
            str="";
        //loop backwards 4 times
        for(int j=3;j>=0;j--){
            //take the last integer from a 4 digit number
            lastNum=numHolder%10;
            //encrypt the message
            lastNum=(lastNum+enOrde)%10;
            //put the number into the arrayHolder as a separated interger
            arrayHolder[j]=lastNum;
            //takes out the last num from a 4 digit number
            numHolder/=10;
        
                  
            }
        //It uses nor operator to swap the integer
        //swap 1st and 3rd integer
        arrayHolder[0]=arrayHolder[0]^arrayHolder[2];
        arrayHolder[2]=arrayHolder[2]^arrayHolder[0];
        arrayHolder[0]=arrayHolder[0]^arrayHolder[2];
        //swaping 2nd digit and the fourth
        arrayHolder[1]=arrayHolder[1]^arrayHolder[3];
        arrayHolder[3]=arrayHolder[3]^arrayHolder[1];
        arrayHolder[1]=arrayHolder[1]^arrayHolder[3];
        //turning all 4 individual integer into a string
        for(int j=0;j<4;j++){
            str+=String.valueOf(arrayHolder[j]);
        }
        //put the string of encryped value into an array of string
        array[i]=str;
        }
        //tells the user the incrypted message
        System.out.println(msg);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        System.out.println("----------------------------------------------");
        return array;
  }//end encrypt 
  //takes an array of int and return an array of String
  
}//end class
