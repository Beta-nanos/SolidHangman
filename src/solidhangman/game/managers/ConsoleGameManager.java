
package solidhangman.game.managers;

import solidhangman.game.exceptions.WrongInputException;
import java.util.List;
import java.util.Scanner;
import solidhangman.OPTION;
import solidhangman.Player;

public class ConsoleGameManager implements GameManager{
    private List<Player> players;
    
    Scanner scan = new Scanner(System.in);
    public ConsoleGameManager() {
    }

    @Override
    public void showGameMenu() {
        System.out.println("1.Add new word\n2. Show statistics\n3.Exit");
    }

    @Override
    public OPTION getChoiceAnswer() throws WrongInputException{
       char option = scan.next().toUpperCase().charAt(0);
       OPTION chosenOption;
       
            switch (option){
                case '1':
                        chosenOption = OPTION.PLAY;
                    break;
                 case '2':
                     chosenOption = OPTION.SHOW_STATS;
                    break;
                 case '3':
                     chosenOption = OPTION.EXIT;
                    break;
                 default:
                     throw new WrongInputException(option);
            }
            return chosenOption;
    }

    @Override
    public void showStats() {
        for(Player player:players){
            player.showMyStats();
        }
    }

    @Override
    public Player nextPlayerToPlay(Player currentPlayer) {
        int indexCurrentPlayer = players.indexOf(currentPlayer);
        if(indexCurrentPlayer == players.size()-1)
            return players.get(0);
        else
            return players.get(indexCurrentPlayer + 1);
    }

    @Override
    public void initPlayers(List<Player> players) throws WrongInputException{
        this.players = players;
        System.out.print("1. One player.\n2. Two player\nOption: ");
        char option = scan.next().toUpperCase().charAt(0);
        switch (option){
            case '1':
                    createPlayers(1);
                break;
            case '2':
                    createPlayers(2);
                break;
            default:
                throw new WrongInputException(option);
        }
    }
    
    private void createPlayers(int amount){
        for(int i =0; i < amount; i++){
            this.players.add(new Player("Player "+(i+1)));
        }
    }
    
}
