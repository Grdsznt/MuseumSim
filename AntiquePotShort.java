import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Valuable Pots.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class AntiquePotShort extends Valuable
{
    public final static int price = 7000;
    
    public AntiquePotShort(){
        //Set the image, and set the price to $7000
        super(new GreenfootImage("valuableArtPot2.png"), price);
    }
}
