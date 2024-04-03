import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be used on objects to detect if they are touching a certain type of class.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Detector extends Actor
{
    int[] xPoints = {0,10,10};
    int[] yPoints = {3,6,0};
    GreenfootImage triangle = new GreenfootImage(10,6);
    
    public Detector(){
        triangle.setColor(Color.GRAY);
        triangle.fillPolygon(xPoints, yPoints,3);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
