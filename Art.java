import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Art here.
 * 
 * @author Felix, Jerry, Jean
 * @version May 2 2024
 */
public abstract class Art extends Valuable
{
    protected  Visitor[] visitors;
    private boolean isNew = false;
    //protected String spawnerType;
    //protected GreenfootImage image;
    protected int price;
    protected int actNumber;
    protected boolean willVibrate;
    protected int defaultX, defaultY;//store orginial x and y values, used for vibration
    protected int t=0;//transparency
    
    /** 
     * Constructor for art
     * 
     * @param image     The image of the art piece
     * @param price     The value of the art piece
     * @param index     The index of this valuable
     * @param x     The x-coordinate 
     * @param y     The y-coordinate 
     */
    public Art(GreenfootImage image, int index, int price, int x, int y){
        //super(ART_IMAGE, price, -1, x, y);
        //this.spawnerType = spawnerType;
        super(image, index, price, x, y);
        actNumber = 0;
        defaultX = x;
        defaultY = y;
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
