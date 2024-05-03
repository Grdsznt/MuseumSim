import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoodEnd here.
 * medium ending of the game
 * @author Nick
 * @version (a version number or a date)
 */
public class MidEnd extends EndWorld
{
    private static GreenfootImage BG = new GreenfootImage("goodMuseum.png");
    /**
     * Constructor for objects of class BadEnd.
     * 
     */
    public MidEnd(MuseumRoom room)
    {
        super(room);
        BG.scale(1000,800);
        setBackground(BG);
    }
    public void act(){
        super.act();
        dropDownMenu.moveNow();
    }
}
