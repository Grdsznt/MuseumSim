import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ruinedMuseum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RuinedMuseum extends World
{
    
    /**
     * Constructor for objects of class ruinedMuseum.
     * 
     */
    
    public RuinedMuseum()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        addObject(new DropDownMenu(getWidth(), getHeight()), getWidth()/2, 0);
    }
}
