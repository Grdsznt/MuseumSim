import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonaLisa here.
 * 
 * @author Jean, (your name) 
 * @version (a version number or a date)
 */
public class MonaLisa extends Valuable
{
    public static final int price = 10000;
    
    /**
     * A constructor.
     * 
     * @param x     The x position
     * @param y     The y position
     */
    public MonaLisa(int x, int y) {
        super(new GreenfootImage("paintingArt2.png"), -1, price, x, y);
    }
}
