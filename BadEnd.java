import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BadEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadEnd extends EndWorld
{
    private static GreenfootImage BG = new GreenfootImage("ruinedMuseum.png");
    /**
     * Constructor for objects of class BadEnd.
     * 
     */
    public BadEnd(MuseumRoom room)
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
