/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 * represents the location in column and row notation
 * @author ammarasmro
 */
public class Coordinates {
    private int x;
    private int y;
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return "X: " + getX() + " "
                + "Y: " + getY();
    }
    
    public static void main(String[] args){
        System.out.println("Started Coordinates!");
        Coordinates test = new Coordinates(3,4);
        System.out.println(test);
    }
}
