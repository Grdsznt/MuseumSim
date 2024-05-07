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
    private boolean isMoving;
    /**
     * Constructor for the drop down menu
     * 
     * @param w     The width of the menu
     * @param h     The height of the menu
     */
    public DropDownMenu(int w, int h){
        cover.scale(660, 550);
        setImage(cover);
        width = w;
        height = h;
        speed = 0;
        actNum = 0;
        isMoving = false;
    }
    /**
     * Act - do whatever the dropDownMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //set default location to top of the screen
        if(actNum == 0){
            setLocation(width/2, 0);
        }
        if(isMoving){
            //sliding lasts 90 acts
            if(actNum <= 90){
                //function for speed f(x) = 1.6^(x+5) - 0.9
                //integral of f(actNum) is around 10 between 0 < actNum < 5, thus it will end up in the middle of the screen
                speed = Math.pow(1.6,-1*(actNum/18 - 5))-0.9;
                setLocation(width/2, getY() + speed);
            }
            else{
                isMoving = false;
            }
            actNum++;
        }
    }
    /**
     * Checks if it is still moving
     * 
     * @return  If it is moving
     */
    public boolean checkIfMoving(){
        //if actNum is <= 90 that means dropdownmenu is still moving
        return isMoving;
    }
    public void moveNow(){
        isMoving = true;
    }
}
