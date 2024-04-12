    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo.*;
/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends Button
{
    private GreenfootImage imageUp;
    private GreenfootImage imageDown;
    static int mouseNumber;
    public HomeButton() {
        imageUp = new GreenfootImage("homeUp.png");
        imageDown = new GreenfootImage("homeDown.png");
    }
    /**
     * Act - do whatever the HomeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        mouseNumber = MouseInfo.getButton();
        
        
        // Add your action code here.
    }
    
    
}
