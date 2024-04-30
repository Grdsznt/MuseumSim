import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DayCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayCounter extends Actor
{
    private int dayCount = 0;
    /**
     * Act - do whatever the DayCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setImage(new GreenfootImage("Day: " + dayCount, 24, Color.BLACK, Color.WHITE));
    }
    
    public void incrementDayCount() {
        dayCount++;
    }
    
}