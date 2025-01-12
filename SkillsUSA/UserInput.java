/** Function : This class ask and collect the input from the user and pass it into other function
 * @author 3490
 */
import java.io.File; 
import java.util.ArrayList;
import java.util.Scanner;
class UserInput{
    private boolean userContinue;
    private String read;
    private ArrayList<String> info=new ArrayList<String>();
    private String[] returnValue;
    private ReadFile test= new ReadFile();
    Encryption call =new Encryption();
    UserInput(){
        userContinue=true;
    }
    //start asking user question and expect input from user
    public void start(){
        //will loop until the user doesn't want to continue
        while(userContinue){
            //ask question
            System.out.println("Do you want to encrypt(en) or decrypt(de) a message?");
            Scanner userInput=new Scanner(System.in);
            try{
                //stores lowercase user input
                read=userInput.next().toLowerCase();
                if(read.equals("de")){
                    System.out.println("Enter the message that you want to decrypt and type done when you are finished"); 
                    //calls the function and tells it what to do based on true and false
                    function(false);
                }else if(read.equals("en")){
                    System.out.println("Enter the message that you want to encrypt and type done when you are finished");
                    function(true);
                }else{
                    //when the user type something else
                    System.out.println("Please type de or en for decryption/encryption");
                }
            }catch (Exception e){
                //tells the user to input the right data type
                System.out.println("Please don't type anything other than a string");
            }
            
        }
    }
    //takes a boolean to do encrypt or decrypt
    public void function(boolean n){
        Scanner userInput=new Scanner(System.in);
        //loop until the user doesn't want to continue
        while(userContinue){
            try{
                read=String.valueOf(userInput.next().toLowerCase());
                if(!read.equals("done")){
                    //add the value that the user want to encrypt or decrypt
                    info.add(read); 
                }else{
                    //when user type done, it stop the loop
                    userContinue=false;
                }
            }catch(Exception e){
                //catch the user's strange behavior
                System.out.println("oof");
            }
        }
        //set the size of the array
        returnValue=new String[info.size()];
        //convert the data from ArrayList to an array of String
        for(int i=0;i<info.size();i++){
                returnValue[i]=info.get(i);
        }
        //writes the input value in a file
        WriteFile.writeInput(returnValue);
        //calls the function that read and filter the value and encrypt/decrypt and write it into the output file
        WriteFile.writeOutput(call.crypt(test.read(),n));
        //make sure the loop runs
        userContinue=true;
        //ask the user whether if they want to continue and ask them whether they want to delete file or not
        while(userContinue){
            System.out.println("Do you want to clear the file?y/n");
            try{
                read=userInput.next().toLowerCase();
                if(read.equals("y")){
                    System.out.println("Which file do u want to output(o), input(i), or both(b) file ?");
                    try{
                        read=userInput.next().toLowerCase();
                        //calls the function that delete the file
                        if(read.equals("o")){
                            WriteFile.deleteFile(false,true);
                        }else if(read.equals("i")){
                            WriteFile.deleteFile(true,false);
                        }else if(read.equals("b")){
                            WriteFile.deleteFile(true,true);
                        }else{
                            //calls the user out when they input something that isn't o/i/b
                            System.out.println("Please answer by using o/i/b for only output, only intput,both");
                        }
                        }catch(Exception e){
                            System.out.println("Please answer by using o/i/b for only output, only intput,both");
                        }  
                }else if(read.equals("n")){
                    //stop the loop when user doesn't want to delete file
                    userContinue=false;
                }else{
                    //tells the user to input the right input
                    System.out.println("Please answer by using y/n for Yes or No");
                }
            }catch(Exception e){
                System.out.println("Please answer by using y/n for Yes or No");
            }
        }
        //make sure the loop runs
        userContinue=true;
            while(userContinue){
                System.out.println("Do you want to continue?(y/n)");
                try{
                    read=userInput.next();
                    if(read.equals("y")){
                        //if the user wants to continue call the "start" function
                        start();
                        //stop the loop
                        userContinue=false;
                        
                    }else if(read.equals("n")){
                        //stop the loop, thus stop the program
                        userContinue=false;
                    }else{
                        //tells the user to input the right value
                        System.out.println("Please answer by using y/n for Yes or No");
                    }
                }catch(Exception e){
                    //tells the user to input the right value
                    System.out.println("Please answer by using y/n for Yes or No");
                }
        }
    }
}