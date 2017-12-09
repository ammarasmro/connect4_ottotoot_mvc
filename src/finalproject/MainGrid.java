/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 * Initializes the underlying grid
 * Puts a grid on the view
 * Adds the disc holder
 * Useful printing methods
 *
 * @author ammarasmro
 */
public class MainGrid {
    private int columns;
    private int rows;
    private Disc[][] mainGrid;
    private final int discRadius = 80;
    private Shape gridShape;
    private Pane discRoot = new Pane();
    
    public MainGrid(int dimV, int dimH, Pane gameplayPane){
        this.rows = dimV;
        this.columns = dimH;
        this.mainGrid = new Disc[dimV][dimH];
        initializeGrid();
        gameplayPane.getChildren().clear();
        gridShape = makeGrid(gameplayPane);
        System.out.println("MainGrid constructed!");
    }
    
    private void initializeGrid(){
        for(int i = 0; i < mainGrid.length; i++){
            for(int j = 0; j < mainGrid[i].length; j++){
                mainGrid[i][j] = new Disc(i, j);
            }
        }
    } 
    
    public void setBackgroundColour(Color backgroundColour){
        gridShape.setFill(backgroundColour);
    }
    
    public int getLength(){
        return mainGrid.length;
    }
    
    public Disc[][] getGrid(){
        return mainGrid;
    }
    
    @Override
    public String toString(){
        String res = "";
        for(Disc[] a: mainGrid){
            for(Disc i: a){
                res = res + i.getCoordinates() + " ";
            }
            res += "\n";
        }
        return res;
    }
    
    public String contentsToString(){
        String res = "";
        for(Disc[] a: mainGrid){
            for(Disc i: a){
                res = res + String.format("%s   ", i.getLabel());
//                res = res + i.getCoordinates() + " ";
            }
            res += "\n";
        }
        return res;
    }
    
    
    
    
    
    public Shape makeGrid(Pane gameplayPane){
        Shape shape = new Rectangle((columns + 1) * discRadius, (rows + 1) * discRadius);
        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++){
                Circle circle = new Circle(discRadius / 2);
                circle.setCenterX(discRadius / 2);
                circle.setCenterY(discRadius / 2);
                circle.setTranslateX(x * (discRadius + 5) + discRadius / 4);
                circle.setTranslateY(y * (discRadius + 5) + discRadius / 4);
                
                shape = shape.subtract(shape, circle);
            }
        }
        
        shape.setFill(Color.BLUE);
        gameplayPane.getChildren().add(discRoot);
        gameplayPane.getChildren().add(shape);
        return shape;
    }   

    
    public static void main(String[] args){
        System.out.println("MainGrid started!");
        MainGrid mainGrid = new MainGrid(6,7, new Pane());
        
        System.out.println(mainGrid);
    }
}
