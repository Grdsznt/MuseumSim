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
    protected boolean willVibrate;
    protected int defaultX, defaultY;//store orginial x and y values, used for vibration
    private int len;
    protected int t=0;//transparency
    /**
     * Act - do whatever the Art wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Art(){
        visitors = new Visitor[len];
        actNumber = 0;
        defaultX = getX(); defaultY = getY();
	      willVibrate = false;
    }
    
    public void addedToWorld(World w){
        if(!isNew ){
            isNew = true;
        }
    }

    public void act(){
        //vibration section
        if(willVibrate){
            int strength = 6;//vibration strength
            int offset = Greenfoot.getRandomNumber(strength + 1);
            setLocation(defaultX + offset - strength/2, defaultY + offset - strength/2);
        }
        else{
            setLocation(defaultX, defaultY);
        }
        
    }
    //call this method to vibrate the art
    public void vibrate(){
        willVibrate = true;
    }
    public void stopVibrating(){
        willVibrate = false;
    }
    
    public Visitor[] getVisitors(){
        return visitors;
    }
    
    public void placeVisitors(Visitor v, int spotNumber){
        visitors[spotNumber] = v;
    }
    
}
