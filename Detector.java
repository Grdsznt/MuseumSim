import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be used on objects to detect if they are touching a certain type of class.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Detector extends Actor
{
    //Size
    private int length = 40;
    private int width = 20;
    //Draw the image
    private int[] xPoints = {0,length,length};
    private int[] yPoints = {width/2,0,width};
    private GreenfootImage triangle = new GreenfootImage(length,width);
    
    //Store its own guard
    private Guard guard;
    
    public Detector(Guard guard){
        //Draw
        triangle.setColor(Color.GRAY);
        triangle.fillPolygon(xPoints, yPoints,3);
        //Set image
        setImage(triangle);
        //Get its own guard
        this.guard = guard;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
