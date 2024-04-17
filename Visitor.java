import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Visitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visitor extends Human
{
    private static int numberOfVisitors = 0;
    public boolean playing  = false; 
    private int visitDuration;// in units of acts
    public Visitor(int time){
        visitDuration = time;
        numberOfVisitors++;
    }
    /**
     * Act - do whatever the Visitor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(visitDuration <= 0){
            numberOfVisitors--;
            getWorld().removeObject(this);
        }
        visitDuration--;
    }
    //get the number of visitors
    public static int getNumVisitors(){
        return numberOfVisitors;
    }
    
    
}
