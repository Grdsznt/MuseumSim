import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Arts.
 * 
 * @author Jean
 * @version May 2024
 */
public class PaintingMan extends Art
{
    public final static int indexInList = 1;
    public static final int price = 1500;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public PaintingMan(int x, int y) {
        super(new GreenfootImage("paintingArt.png"), indexInList, price, x, y);
    }
}
