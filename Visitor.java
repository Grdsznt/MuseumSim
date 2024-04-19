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
    protected boolean playing = false, flag = false, toSpot = false, isNew=false, leaving=false, insane=false;
    private int visitDuration;// in units of acts
    private SpotManager.DetailedSpot target;
    
    
    
    public void addedToWorld(World w){
        if(!isNew){//prevent z sort problems
            isNew=true;
            //attempts to target, if unable then remove as would do nothing
            target=SpotManager.attemptTarget(this);
            if(target==null)getWorld().removeObject(this);
        }
        
        
        
        MuseumRoom2.income +=100;
        
    }
   
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
        
    }
    
    
    //get the number of visitors
    public static int getNumVisitors(){
        return numberOfVisitors;
    }
    
    
    
}
