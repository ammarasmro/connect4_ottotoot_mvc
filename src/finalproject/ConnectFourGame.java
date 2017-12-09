/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * The specifics of the connect four game
 * It differs by its activate disc function and the winning hands
 * 
 * @author ammarasmro
 */
public class ConnectFourGame extends GamePlay {
    
    
    public ConnectFourGame(int row, int column, String playerOneName, String playerTwoName, Pane gameplayPane) {
        super(row, column, playerOneName, playerTwoName, gameplayPane);
        setDiscTypeForPlayerInitializer(new Disc(Color.RED, "R"), playerOne);
        setDiscTypeForPlayerInitializer(new Disc(Color.YELLOW, "Y"), playerTwo);
//        playerOne.setDiscTypeForPlayer(new Disc(Color.RED, "R"));
//        playerTwo.setDiscTypeForPlayer(new Disc(Color.YELLOW, "Y"));
        
        initializeWinningLists();
        makeColumns(gameplayPane);
        System.out.println("ConnectFourGame constructed!");
    }
    
    public void initializeWinningLists(){
        winningOne.add(new Disc(Color.RED, "R"));
        winningOne.add(new Disc(Color.RED, "R"));
        winningOne.add(new Disc(Color.RED, "R"));
        winningOne.add(new Disc(Color.RED, "R"));
        winningTwo.add(new Disc(Color.YELLOW, "Y"));
        winningTwo.add(new Disc(Color.YELLOW, "Y"));
        winningTwo.add(new Disc(Color.YELLOW, "Y"));
        winningTwo.add(new Disc(Color.YELLOW, "Y"));
    }
    
    @Override
    public void activateDisc(Disc disc, Player player){
        disc.activate();
        disc.setColor(player.getDiscTypeForPlayer().getColor());
        disc.setLabel(player.getDiscTypeForPlayer().getLabel());
    }
    
    
    @Override
    public Group getDisc(){
        Group rootGroup = new Group();
        Circle disc = new Circle(40);
        disc.setFill(currentPlayer.getDiscTypeForPlayer().getColor());
        rootGroup.getChildren().add(disc);
        return rootGroup;
    }
    
    public static void main(String[] args){
        System.out.println("Main!!");
        GamePlay game = new ConnectFourGame(6, 7, "Ammar", "Jarvis", new Pane());
        System.out.println(game.getGrid().toString());
//        game.computerizePlayerTwo();
        game.deComputerizePlayerTwo("Friday");
        int input = 0;
        boolean validNumber = false;
        while(!game.hasGameEnded()){
            Scanner scanner=new Scanner(System.in);
            validNumber=true;
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer number");
                validNumber=false;
            }
            System.out.println(input);
            game.playTurn(input);
            System.out.println(game.getGrid().contentsToString());
        }
        
        
    }
        
}
