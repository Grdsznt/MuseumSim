import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Valuable Pots.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class AntiquePotTall extends Valuable
{
    public final static int indexInList = 3;
    public final static int price = 5000;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public AntiquePotTall(int x, int y){
        //Set the image, and set the price to $5000, and give the x and y positions
        super(new GreenfootImage("valuableArtPot.png"), indexInList, price, x, y);
    }
}
