import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Valuable Pots.
 * 
 * @author Jean
 * @version May 2024
 */
public class AntiqueTeaPot extends Valuable
{
    public final static int indexInList = 5;
    public final static int price = 10000;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public AntiqueTeaPot(int x, int y){
        //Set the image, and set the price to $10000, and give the x and y positions
        super(new GreenfootImage("valuableTeaPot.png"), indexInList, price, x, y);
    }
}
