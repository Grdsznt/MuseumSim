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
        visitors = new Visitor[len];
        actNumber = 0;
    }
    
    public void addedToWorld(World w){
        if(!isNew ){
            isNew = true;
        }
    }

    public void act(){
        
        
    }
    
    public Visitor[] getVisitors(){
        return visitors;
    }
    
    public void placeVisitors(Visitor v, int spotNumber){
        visitors[spotNumber] = v;
    }
    
}
