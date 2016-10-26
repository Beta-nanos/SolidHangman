package solidhangman;

import java.util.Scanner;


public class SolidHangman {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String replayAnswer;
       
       System.out.println("");
       Hangman game = new ConsoleHangman();
       
       do {
            game.init();
            String winner = game.play();
            System.out.println(winner + " has won.");
            System.out.print("1. Show statistics.\n"
                    + "2. Play again?\nAnswer: ");
            replayAnswer = scan.next();
            
            switch(replayAnswer){
                case "1":
                    game.showStats();
                    break;
                case "2":
                default:
                    replayAnswer = "y";
                    break;
            }
       } while(replayAnswer.equals("y"));
    }
    
}
