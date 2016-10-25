package solidhangman;

import java.util.Scanner;


public class SolidHangman {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String replayAnswer;
        
        do {
            Hangman game = new ConsoleHangman();
            game.init();
            String winner = game.play();
            System.out.println(winner + " has won.");
            System.out.print("Do you want to play again? Y/N: ");
            replayAnswer = scan.next();
        } while(replayAnswer.toLowerCase().charAt(0) == 'y');
    }
    
}
