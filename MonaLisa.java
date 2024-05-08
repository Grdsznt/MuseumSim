import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Arts.
 * 
 * @author Jean
 * @version May 2024
 */
public class MonaLisa extends Art
{
    public final static int indexInList = 0;
    public static final int price = 1000;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public MonaLisa(int x, int y) {
        super(new GreenfootImage("paintingArt2.png"), indexInList, price, x, y);
    }
}
