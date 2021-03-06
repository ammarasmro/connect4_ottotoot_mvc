/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Random;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author ammarasmro
 */
public class OTTOandTOOTGame extends GamePlay {
    
    /**
     * 
     * @param row by default it is 6 but it was left as a variable for future development
     * @param column by default it is 6 but it was left as a variable for future development
     * @param playerOneName Name of the first player
     * @param playerTwoName Name of the second player
     * @param gameplayPane The pane from the view so that the model can add views from here
     */
    public OTTOandTOOTGame(int row, int column, String playerOneName, String playerTwoName, Pane gameplayPane) {
        super(row, column, playerOneName, playerTwoName, gameplayPane);
        setDiscTypeForPlayerInitializer(new Disc(Color.WHITE, "O"), playerOne);
        setDiscTypeForPlayerInitializer(new Disc(Color.WHITE, "T"), playerTwo);
        // Put the winning combinations in two lists
        initializeWinningLists();
        // Add columns, listeners, and an indicator
        makeColumns(gameplayPane);
        System.out.println("ConnectFourGame constructed!");
    }
    
    /**
     * Assign OTTO for the first player and TOOT for the second
     */
    public void initializeWinningLists(){
        winningOne.add(new Disc(Color.WHITE, "O"));
        winningOne.add(new Disc(Color.WHITE, "T"));
        winningOne.add(new Disc(Color.WHITE, "T"));
        winningOne.add(new Disc(Color.WHITE, "O"));
        winningTwo.add(new Disc(Color.WHITE, "T"));
        winningTwo.add(new Disc(Color.WHITE, "O"));
        winningTwo.add(new Disc(Color.WHITE, "O"));
        winningTwo.add(new Disc(Color.WHITE, "T"));
    }
    
    /**
     * Activate the discs by adding color and a label and setting the label visible
     * @param disc
     * @param player 
     */
    @Override
    public void activateDisc(Disc disc, Player player){
        disc.activate();
        disc.setColor(player.getDiscTypeForPlayer().getColor());
        disc.setLabel(player.getDiscTypeForPlayer().getLabel());
        disc.setLabelVisibility(true);
    }
    
    /**
     * Set the disc type of the current player when they click on it from the UI
     * @param disc 
     */
    public void pickDiscType(Disc disc){
        currentPlayer.setDiscTypeForPlayer(disc);
    }
    
    /**
     * This method also assigns a random choice of discs for the next play
     * @return Get a disc according to the specifications of OTTO and TOOT
     */
    @Override
    public Group getDisc(){
        Group rootGroup = new Group();
        Circle disc = new Circle(40);
        disc.setFill(currentPlayer.getDiscTypeForPlayer().getColor());
        Text text = new Text(currentPlayer.getDiscTypeForPlayer().getLabel());
        Random rand = new Random();
        if(currentPlayer instanceof ComputerizedPlayer)
            currentPlayer.setDiscTypeForPlayer(new Disc(Color.WHITE,(rand.nextInt(2) == 0) ? "O" : "T"));
        text.setTextAlignment(TextAlignment.CENTER);
        rootGroup.getChildren().addAll(disc, text);
        return rootGroup;
    }
    
}
