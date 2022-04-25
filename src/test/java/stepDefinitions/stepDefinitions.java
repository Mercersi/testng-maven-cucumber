package stepDefinitions;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;

public class stepDefinitions {
    
    WebDriver driver;
    int len = 5;
    int tal = 12;
    int [][] arr ={ {1,2,3,4,5,6,7,8,9,010,011,012},                 
		            {11,12,13,14,15,16,17,18,19,191,192,193},
		            {21,22,23,24,25,26,27,28,29,291,292,293},
		            {31,32,33,34,35,36,37,38,39,391,392,393},
		            {41,42,43,44,45,46,47,48,49,491,492,493} };


    @Then("init data-loader {string} {string}")
    public void data_loader(String num,String cmd){
        boolean check = false;
        // String regex = "^[${_getData[...][...]}]$";

        //${_getData[i][j]}
        if((cmd.substring(0,11).equals("${_getData[")) 
        && (cmd.substring(12, 14).equals("][")) 
        && (cmd.substring(15,17).equals("]}")))
        {
           int i = Integer.parseInt(cmd.substring(11, 12));
           int j = Integer.parseInt(cmd.substring(14, 15));
           System.out.println(num+" var ["+i+"]"+"["+j+"]: "+arr[i][j]);
           check = true;
        }
        //${_getData[ii][j]}
        else if ((cmd.substring(0,11).equals("${_getData[")) 
        && (cmd.substring(12, 15).equals("][")) 
        && (cmd.substring(16,18).equals("]}")))
        {
           int i = Integer.parseInt(cmd.substring(11, 13));
           int j = Integer.parseInt(cmd.substring(15, 16));
           System.out.println(num+" var ["+i+"]"+"["+j+"]: "+arr[i][j]);
           check = true;
        }
        //${_getData[i][jj]}
        else if ((cmd.substring(0,11).equals("${_getData[")) 
        && (cmd.substring(12, 14).equals("][")) 
        && (cmd.substring(16,18).equals("]}")))
        {
           int i = Integer.parseInt(cmd.substring(11, 12));
           int j = Integer.parseInt(cmd.substring(14, 16));
           System.out.println(num+" var ["+i+"]"+"["+j+"]: "+arr[i][j]);
           check = true;
        }
        //${_getData[ii][jj]}
        else if ((cmd.substring(0,11).equals("${_getData[")) 
        && (cmd.substring(13, 15).equals("][")) 
        && (cmd.substring(17,19).equals("]}"))) 
        {
           int i = Integer.parseInt(cmd.substring(11, 13));
           int j = Integer.parseInt(cmd.substring(15, 17));
           if (i > tal || j > len) 
           {System.out.println(num+ " I and J out of range");}
           else System.out.println(num+" var ["+i+"]"+"["+j+"]: "+arr[i][j]);
           check = true;
        }

        //${_getData[1111][111]}
        if(((cmd.substring(0,11).equals("${_getData[")==true) 
        && ((cmd.substring(13, 15).equals("][")==false) 
        || (cmd.substring(18,19).equals("]}")==false)))
        && (check == false))
        {
           System.out.println(num+" error message: I and J out of range");
        }
        else if (check == false ) {
            System.out.println(num +" error message: Wrong format command");
        }
    }

 



}
