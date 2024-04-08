import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imgUp, imgPressed;
    
    public Button() {
        //imgUp = new GreenfootImage("");
        //imgPressed = new GreenfootImage("");
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            //  干啥
            // push down animation
        }
    }
}
