import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Pot extends Valuable
{
    public final static int indexInList = 0;
    public final static int price = 500;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public Pot(int x, int y){
        //Set the image, and set the price to $100, and give the x and y positions
        super(new GreenfootImage("PinkPot.png"), indexInList, 500, x, y);
    }
}