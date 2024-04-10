import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robber extends People
{
    private double speed;
    private int targetRadius;
    private int xDirection;//+1 right, -1 left
    private int yDirection;//+1 down, -1 up
    public Robber(double s, int tR, int xD, int yD){
        speed = s; 
        targetRadius = tR;
        
    }
    /**
     * Act - do whatever the Robber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void targetValuable(){
        
    }
}
