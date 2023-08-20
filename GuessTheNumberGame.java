package GuessTheNumber;
import java.util.*;

class Game{
   double GeneratedNumber;
   int number;
   int count=0;
   String name;

   Game (){
       GeneratedNumber=Math.floor(Math.random()*100);
   }

   public void Detail(int n,String name){
       number=n;
       this.name=name;
   }

   public boolean PlayGame(){

       if(number== GeneratedNumber){
           return true;
       }
       else
       {return false;}


   }
   public void Count(){
       count++;
   }

}
public class GuessTheNumberGame {
    public static void main(String args []){
        Game g= new Game();

        System.out.println("Welcome to Guess The number Game\nRULES:\nYou will get five chances to guess the correct number , if you succeed in guessing the right number you will win .");
        System.out.println("Enter 's' to start : ");
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();

        if(str.equalsIgnoreCase("s"))
        { System.out.println("Enter your user name : ");
        String name=sc.nextLine();

        while (g.count<=4) {

            System.out.println("Enter the number between 1-100 : ");
            int Number = sc.nextInt();
            g.Detail(Number,name);

            if (g.PlayGame()==true) {
                g.Count();
                System.out.println(name + "Congratulation , you guessed the right number .");
                System.out.println("Your Score is : 1 out of "+g.count+" chances.");
                break;
            }
            else if (g.PlayGame()==false) {
                if(g.GeneratedNumber<g.number)
                {
                    g.Count();
                    System.out.println("The number you had entered is big , please enter a smaller number .");
                }

                 else if (g.GeneratedNumber>g.number)
                 {
                  g.Count();
                  System.out.println("The number you had entered is small , please enter a larger number .");
                 }
            }


            }

        System.out.println("GAME ENDED");

        }
    }

