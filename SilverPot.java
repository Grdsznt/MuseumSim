import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class SilverPot extends Valuable
{
    public final static int indexInList = 1;
    public final static int price = 500;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public SilverPot(int x, int y){
        //Set the image, and set the price to $700, and give the x and y positions
        super(new GreenfootImage("SilverPot.png"), indexInList, price, x, y);
    }
}
