import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class GoldPot extends Valuable
{
    public final static int indexInList = 2;
    public final static int price = 700;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public GoldPot(int x, int y){
        //Set the image, and set the price to $900, and give the x and y positions
        super(new GreenfootImage("GoldPot.png"), indexInList, price, x, y);
    }
}
