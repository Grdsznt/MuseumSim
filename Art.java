import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Art here.
 * 
 * @author Felix, Jerry
 * @version (a version number or a date)
 */
public abstract class Art extends Valuable
{
    protected  Visitor[] visitors;
    private boolean isNew = false;
    protected String spawnerType;
    protected GreenfootImage image;
    protected double price;
    protected int actNumber;
    protected boolean willVibrate;
    protected int defaultX, defaultY;//store orginial x and y values, used for vibration
    protected int t=0;//transparency
    /**
     * Act - do whatever the Art wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Art(GreenfootImage ART_IMAGE, double price){
        super(ART_IMAGE, price);
        image = ART_IMAGE;
        this.price = price;
        this.spawnerType = spawnerType;
    }
    
    public void addedToWorld(World w){
        actNumber = 0;
        defaultX = getX(); defaultY = getY();
        willVibrate = false;
        
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
        if(actNumber==  60){
            stopVibrating();
        }
        actNumber++;
    }
    //call this method to vibrate the art
    public void vibrate(){
        willVibrate = true;
    }
    public void stopVibrating(){
        willVibrate = false;
    }
}
