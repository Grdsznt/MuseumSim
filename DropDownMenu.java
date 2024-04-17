import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class dropDownMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropDownMenu extends SuperSmoothMover
{
    private static GreenfootImage cover = new GreenfootImage("Robber/drawingFrame.png");
    
    private double speed;
    private int actNum;
    //height and width of the world the object is in
    private int width, height;
    public DropDownMenu(int w, int h){
        cover.scale(600, 500);
        setImage(cover);
        width = w;
        height = h;
        speed = 0;
        actNum = 0;
        setLocation(width/2, 0);
    }
    /**
     * Act - do whatever the dropDownMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //sliding lasts 
        if(actNum <= 120){
            //function for speed f(x) = 1.5^(x+5) - 0.9
            //integral of f(actNum) is around 10 between 0 < actNum < 5, thus it will end up in the middle of the screen
            speed = Math.pow(1.5,-1*(actNum/24 - 5))-0.9;
            setLocation(width/2, getY() + speed);
        }
        
        
        
        actNum++;
    }
}
