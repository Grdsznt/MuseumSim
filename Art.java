import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Art here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Art extends Actor
{
    protected  Visitor[] visitors;
    private boolean isNew = false;
    protected int actNumber;
    private int len;
    protected int t=0;//transparency
    /**
     * Act - do whatever the Art wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Art(){
        
        len=spots.length;
        visitors = new Visitor[len];
        actNumber = 0;
        visitors=new Visitor[spots.length];
    }
    
    public void addedToWorld(World w){
        if(!isNew ){
            isNew = true;
            SpotManager.addGame(this);
        }
    }

    public void act(){
        
        
    }
    
    public Visitor[] getVisitors(){
        return visitors;
    }
    
    
    public SpotManager.Spot[] getSpots(){
        return spots;
    }
    
    public void placeVisitors(Visitor v, int spotNumber){
        visitors[spotNumber] = v;
    }
    
}
