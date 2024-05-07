import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Valuable Pots.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class AntiquePotShort extends Valuable
{
    public final static int indexInList = 4;
    public final static int price = 2000;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public AntiquePotShort(int x, int y){
        //Set the image, set the price to $7000, and give the x and y positions
        super(new GreenfootImage("valuableArtPot2.png"), indexInList, price, x, y);
    }
}
